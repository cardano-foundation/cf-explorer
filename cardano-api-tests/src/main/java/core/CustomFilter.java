package core;

import groovy.util.XmlParser;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.internal.NameAndValue;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.internal.path.xml.XmlPrettifier;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import util.LogHelper;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class CustomFilter implements Filter {

    private static final LogHelper log = LogHelper.getInstance();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        String requestBuilder = "\n" +
                requestSpec.getURI() +
                "\n" +
                requestSpec.getMethod() +
                "\n" +
                toMapConverter(requestSpec.getHeaders()) +
                "\n" +
                toMapConverter(requestSpec.getCookies()) +
                "\n" +
                getPrettifiedBodyIfPossible(requestSpec) +
                "\n" +
                "*************";
        log.info(requestBuilder);  //Log your request where you need it
        String responseBuilder = "\n\n" +
                response.getStatusLine() +
                "\n" +
                response.getStatusCode() +
                "\n" +
                toMapConverter(response.getHeaders()) +
                "\n" +
                getPrettifiedBodyIfPossible(response,response.getBody()) +
                "\n";
        log.info(responseBuilder); //Log your response where you need it
        return response;
    }

    private static Map<String, String> toMapConverter(Iterable<? extends NameAndValue> items) {
        Map<String, String> result = new HashMap();
        items.forEach((h) -> {
            result.put(h.getName(), h.getValue());
        });
        return result;
    }

    private static String getPrettifiedBodyIfPossible(ResponseOptions responseOptions, ResponseBody responseBody) {
        String contentType = responseOptions.getContentType();
        String responseAsString = responseBody.asString();
        if (isBlank(contentType) || !(responseOptions instanceof RestAssuredResponseOptionsImpl)) {
            return responseAsString;
        }

        RestAssuredResponseOptionsImpl responseImpl = (RestAssuredResponseOptionsImpl) responseOptions;
        ResponseParserRegistrar rpr = responseImpl.getRpr();
        Parser parser = rpr.getParser(contentType);

        return prettify(responseAsString, parser);
    }

    private static String getPrettifiedBodyIfPossible(FilterableRequestSpecification requestSpecification) {
        String contentType = requestSpecification.getContentType();
        if (requestSpecification.getBody() == null){
            return "";
        }
        String resquestAsString = requestSpecification.getBody().toString();

        Parser parser = Parser.fromContentType(contentType);

        return prettify(resquestAsString, parser);
    }

    private static String prettify(String body, Parser parser) {
        String prettifiedBody;
        try {
            switch (parser) {
                case JSON:
                    prettifiedBody = JsonPrettifier.prettifyJson(body);
                    break;
                case XML:
                    prettifiedBody = XmlPrettifier.prettify(new XmlParser(false, false), body);
                    break;
                case HTML:
                    prettifiedBody = XmlPrettifier.prettify(new XmlParser(new org.ccil.cowan.tagsoup.Parser()), body);
                    break;
                default:
                    prettifiedBody = body;
                    break;
            }
        } catch (Exception e) {
            // Parsing failed, probably because the content was not of expected type.
            prettifiedBody = body;
        }
        return prettifiedBody;
    }
}
