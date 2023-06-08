package httprequest;

import core.CustomFilter;
import io.restassured.config.HeaderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

import static io.restassured.RestAssured.given;

public class HttpRequestClientFactory {
    private static ThreadLocal<Response> response = new ThreadLocal<>();
    private static String baseUrl;


    public Response getResponse() {
        return response.get();
    }

    public void setResponse(Response res) { response.set(res); }

    public static FilterableRequestSpecification initReqSpec() {
        FilterableRequestSpecification filterableRequestSpecification = (FilterableRequestSpecification) createCustomFilterReqSpec()
                        .config(getRestAssuredConfig());
        filterReqSpec.set(filterableRequestSpecification);
        return filterableRequestSpecification;
    }

    public static FilterableRequestSpecification getFilterReqSpec() {
        return filterReqSpec.get();
    }

    private static ThreadLocal<FilterableRequestSpecification> filterReqSpec = new ThreadLocal<>();

    public static void setAllUrl(String url) {
        getFilterReqSpec().given().baseUri(url);
    }


    private static RestAssuredConfig getRestAssuredConfig() {
        return RestAssuredConfig.newConfig()
                .headerConfig(HeaderConfig.headerConfig()
                        .overwriteHeadersWithName("access-token", "Accept", "Content-Type")).httpClient(HttpClientConfig.httpClientConfig())
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 60000)
                        .setParam("http.socket.timeout", 60000));
    }


    private static FilterableRequestSpecification createCustomFilterReqSpec() {
        return (FilterableRequestSpecification) given().
                log().ifValidationFails().filter(new CustomFilter());
    }

}
