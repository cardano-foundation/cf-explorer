package core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import constants.RequestMethod;
import httprequest.HttpRequest;
import httprequest.HttpRequestClientFactory;
import util.ObjectMappingUtils;
import exceptions.NonParsableResponseException;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BaseApi extends HttpRequest {
    
    /* This method is only for sending request for 3rd party services */
    public Response send(RequestMethod requestMethod, RequestSpecification spec, String url,
                         String payload) {
        Response res = null;
        if (requestMethod.equals(RequestMethod.GET)) {
            res = given().spec(spec).log().ifValidationFails().get(url);
        }
        if (requestMethod.equals(RequestMethod.POST)) {
            res = given().spec(spec).log().ifValidationFails().body(payload).post(url);
        }
        return res;
    }

    /**
     * Validate that response status code matches to expected value and response body is non-empty
     *
     * @param statusCode - expected status code
     * @return Response object instance
     */
    public BaseApi validateResponse(int statusCode) {
        getResponse().
                then().
                log().ifValidationFails().
                statusCode(statusCode).
                and().
                body("", allOf(notNullValue(), not(""))).
                extract().
                response();
        return this;
    }

    /**
     * Validate that response status code matches to expected value
     *
     * @param statusCode - expected status code
     */
    public BaseApi validateStatusCode(int statusCode) {
        getResponse().
                then().
                log().ifValidationFails().
                statusCode(statusCode);
        return this;
    }


    /**
     * Get the Response data as string
     *
     * @return string
     */
    public String getJsonAsString() {
        return getResponse().body().asString();
    }

    /**
     * Get the response body and map it to a Java object (in other words performs deserialization of
     * JSON string into instance of POJO class)
     *
     * @param cls - class name of java object, i.e. CardBalanceResponse.class
     * @return object instance of POJO class
     */
    public <T> T getJsonAsObject(Class<T> cls) {
        return getResponse().body().as(cls, ObjectMapperType.GSON);
    }

    /**
     * Get a JsonPath view of the response body. This will let you use the JsonPath syntax to get
     * values from the response.
     *
     * @param r - Response object instance
     * @return JsonPath instance
     */
    public JsonPath getJsonPath(Response r) {
        String json = r.asString();
        return new JsonPath(json);
    }

    public JsonArray getJsonArray(Response r) {
        String json = r.asString();
        return new JsonParser().parse(json).getAsJsonArray();
    }

    public JsonObject getJsonObject(Response r) {
        String json = r.asString();
        return new JsonParser().parse(json).getAsJsonObject();
    }

    public JsonElement getJsonElement(String locator) {
        JsonObject object = getJsonObject(getResponse());
        return object.get(locator);
    }

    public String getHtmlValueByPath(String htmlPath) {
        String value = getResponse().xmlPath(XmlPath.CompatibilityMode.HTML).get(htmlPath);
        return value;
    }

    public <T> T getJsonValueByGPath(String gpathLocator) {
        T result;
        try {
            result = getResponse().path(gpathLocator);
        } catch (NullPointerException npe) {
            throw new NonParsableResponseException(
                    String.format("Response does not contain data matched to gPath %s", gpathLocator));
        }
        return result;
    }

    /**
     * Get value of specific field from response,
     *
     * @param jsonLocator - json path for target field, i.e. "id"
     * @return value if target field
     */
    public String getJsonValue(String jsonLocator) {
        String jsonValue;
        try {
            jsonValue = getJsonPath(getResponse()).get(jsonLocator).toString();
        } catch (NullPointerException npe) {
            throw new NonParsableResponseException(
                    String.format("Response does not contain field %s", jsonLocator));
        }
        return jsonValue;
    }

    /**
     * Get size of element's list in response
     *
     * @param jsonLocator - json path for target element's list
     * @return int - count of elements in target list
     */
    public int getJsonArraySize(String jsonLocator) {
        JsonPath jsonValue = getJsonPath(getResponse());
        return jsonValue.getList(jsonLocator).size();
    }

    public void setHeader(String headerName, Object headerValue) {
        HttpRequestClientFactory.getFilterReqSpec().header(headerName, headerValue);
    }

    public void setContentType(ContentType contentType) {
        HttpRequestClientFactory.getFilterReqSpec().contentType(contentType);
    }

    public void removeHeaders() {
        HttpRequestClientFactory.getFilterReqSpec().removeHeaders();
    }

    public Cookies getCookies() {
        return getResponse().getDetailedCookies();
    }

    public void removeHeader(String headerName) {
        try {
            HttpRequestClientFactory.getFilterReqSpec().removeHeader(headerName);
        } catch (NullPointerException ex) {
            System.out.println(headerName + "- Not found");
        }
    }

    public String getHeader(String headerName) {
        return getResponse().header(headerName);
    }

    public void setHeaders(Headers obj) {
        HttpRequestClientFactory.getFilterReqSpec().headers(obj);
    }

    public Headers getHeaders() {
        return HttpRequestClientFactory.getFilterReqSpec().getHeaders();
    }

    public <T> Object saveResponseObject(Class<T> c) {
        try {
            return ObjectMappingUtils.parseJsonToModel(getJsonAsString(), c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> saveResponseListObject(Class<T[]> c) {
        List<T> temp = new ArrayList<>();
        try {
            temp = ObjectMappingUtils.parseJsonToModelList(getJsonAsString(), c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public <T> Object returnObjectIfSuccess(Class<T> c) {
        try {
            if (this.getResponse().statusCode() == 200) {
                return ObjectMappingUtils.parseJsonToModel(this.getJsonAsString(), c);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return null;
    }

    public <T> List returnListObjectIfSuccess(Class<T[]> c) {
        Object temp = new ArrayList();

        try {
            if (this.getResponse().statusCode() == 200) {
                temp = ObjectMappingUtils.parseJsonToModelList(this.getJsonAsString(), c);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return (List) temp;
    }
}
