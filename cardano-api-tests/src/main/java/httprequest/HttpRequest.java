package httprequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpRequest extends HttpRequestClientFactory {

    private static String GetMimeTypes(File file) {
        switch (FilenameUtils.getExtension(file.getName())) {
            case "jpg":
            case "png":
                return "image/png";
            case "wav":
            case "au":
                return "audio/mpeg";
            case "csv":
                return "text/csv";
        }
        return null;
    }
    public static void setBaseUrl(String url) {
        setAllUrl(url);
    }

    private RequestSpecification getCurrentReqSpec() {
        return HttpRequestClientFactory.getFilterReqSpec();
    }

    private class HttpRequestBuilder{
        private String pathParamName = null;
        private String pathParamValueString = null;
        private Object pathParamValue = null;
        private Map<String, Object> params = null;
        private Map<String, String> pathParameters = null;
        private Object body = null;
        private RequestSpecification requestSpecification = given().spec(getFilterReqSpec());
        /**
         * Build request with single Path Parameter
         * @param pathParamName
         * @param pathParamValue
         */
        private HttpRequestBuilder(String pathParamName, Object pathParamValue){
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
        }

        private HttpRequestBuilder(Map<String, Object> params){
            this. params = params;
        }

        private HttpRequestBuilder(Object body){
            this.body = body;
        }

        private HttpRequestBuilder(String pathParam, String pathParamValue){
            this.pathParamName = pathParam;
            this.pathParamValueString = pathParamValue;
        }

        private HttpRequestBuilder(Map<String, Object> params, String pathParamName,
                                   Object pathParamValue){
            this.params = params;
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
        }

        private HttpRequestBuilder(Object body, String pathParamName,
                                   Object pathParamValue){
            this.body = body;
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
        }

        private HttpRequestBuilder(Map<String, Object> params,
                                   Map<String, String> pathParameters){
            this.params = params;
            this.pathParameters = pathParameters;
        }

        public HttpRequestBuilder() {
        }

        public HttpRequestBuilder(Object body, String pathParamName, Object pathParamValue, Map<String, Object> params) {
            this.body = body;
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
            this.params = params;
        }

        public HttpRequestBuilder(Object body, Map<String, String> pathParams, Map<String, Object> params) {
            this.body = body;
            this.pathParameters = pathParams;
            this.params = params;
        }

        public RequestSpecification create(){
            if(pathParamValue != null){
                this.requestSpecification.pathParam(this.pathParamName,this.pathParamValue);
            }
            if(pathParamValueString != null){
                this.requestSpecification.pathParam(this.pathParamName,this.pathParamValueString);
            }
            if(params != null){
                this.requestSpecification.params(this.params);
            }
            if(body != null){
                requestSpecification.body(body);
            }
            if(pathParameters != null){
                requestSpecification.pathParams(pathParameters);
            }
            return this.requestSpecification;
        }
    }

    @Setter
    private String pathParam, pathParamValue, url;
    private Map<String, String> pathParameters;

    /**
     * send GET (example: /store-orders)
     *
     * @param url - URL of API endpoint
     * @return Response object instance
     */
    public Response sendGet(String url) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder().create();
        return doGet(url,httpRequest);
    }

    /**
     * send GET with path parameter (example: /store-orders/{id})
     *
     * @param url            - URL of API endpoint
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendGet(String url, String pathParamName, Object pathParamValue) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParamName, pathParamValue).create();
        return doGet(url , httpRequest);
    }

    /**
     * send GET with request parameters (example: /store-orders?param1=value1)
     *
     * @param url    - URL of API endpoint
     * @param params - map of request params, in form of key/value pairs, where is param's name
     *               (param1) and value is param's value (value1)
     * @return Response object instance
     */
    public Response sendGet(String url, Map<String, Object> params) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(params).create();
        return doGet(url,httpRequest);
    }

    /**
     * send GET with request parameters (example: /store-orders?param1=value1)
     *
     * @param url            - URL of API endpoint
     * @param pathParameters - map of request path Parameters, in form of key/value pairs, where is pathParameters's name
     *                       (param1) and value is pathParameters's value (value1)
     * @return Response object instance
     */
    public Response sendGetWithPathParams(String url, Map<String, Object> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create().pathParams(pathParameters);
        return doGet(url,httpRequest);
    }

    /**
     * send GET with request parameters (example: /store-orders?param1=value1)
     *
     * @param url            - URL of API endpoint
     * @param pathParameters - map of request path Parameters, in form of key/value pairs, where is pathParameters's name
     *                       (param1) and value is pathParameters's value (value1)
     * @param params         - map of request query Parameters, in form of key/value pairs, where is queryParameters's name
     *                       (param1) and value is queryParameters's value (value1)
     * @return Response object instance
     */
    public Response sendGetWithPathParams(String url, Map<String, String> pathParameters, Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(params).create().pathParams(pathParameters);
        return doGet(url,httpRequest);
    }

    public Response sendGet(String url, String pathParam, String pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParam,pathParamValue).create();
        return doGet(url,httpRequest);
    }

    public Response sendGet(String url, Map<String, Object> params, String pathParamName,
                            Object pathParamValue) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(params,pathParamName,pathParamValue).create();
        return doGet(url,httpRequest);
    }


    public Response sendGet(String url, Map<String, Object> params,
                            Map<String, String> pathParameters) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(params,pathParameters).create();
        return doGet(url,httpRequest);
    }

    /**
     * send POST with object payload
     *
     * @param url  - URL of API endpoint
     * @param body - request payload (in form of object instance)
     * @return Response object instance
     */
    public Response sendPost(String url, Object body) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create();
        return doPost(url,httpRequest);
    }

    /**
     * send POST with string payload
     *
     * @param url  - URL of API endpoint
     * @param body - request payload (in form of JSON string)
     * @return Response object instance
     */
    public Response sendPost(String url, String body) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create();
        return doPost(url,httpRequest);
    }

    /**
     * send POST with path param and string payload
     *
     * @param url            - URL of API endpoint
     * @param body           - request payload (in form of JSON string)
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendPost(String url, String body, String pathParamName, Object pathParamValue) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body,pathParamName,pathParamValue).create();
        return doPost(url,httpRequest);
    }

    public Response sendPost(String url, Object body, String pathParamName, Object pathParamValue) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body,pathParamName,pathParamValue).create();
        return doPost(url,httpRequest);
    }

    public Response sendPost(String url, Object body, Map<String, String> pathParameters) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().pathParams(pathParameters);
        return doPost(url,httpRequest);
    }

    public Response sendPostWithParams(String url, Object body, Map<String, Object> params) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().queryParams(params);
        return doPost(url,httpRequest);
    }

    public Response sendPostWithParams(String url, Object body, String pathParamName, Object pathParamValue, Map<String, Object> params) {
        //done
        RequestSpecification httpRequest = new HttpRequestBuilder(body, pathParamName, pathParamValue).create().queryParams(params);
        return doPost(url,httpRequest);
    }

    public Response sendPost(String url, Map<String, File> formData, String pathParamName,
                             Object pathParamValue) {
        RequestSpecification req = given();
        for (Map.Entry<String, File> entry : formData.entrySet()){
            req.multiPart(entry.getKey(), entry.getValue(), GetMimeTypes(entry.getValue()));
        }
        return req.spec(getCurrentReqSpec()).
                header("Content-Type", "multipart/form-data").
                pathParam(pathParamName, pathParamValue).
                when().
                post(url).
                then().
                log().
                ifError().
                extract().response();
    }

    public Response sendPost(String url, Map<String, File> formData) {
        RequestSpecification req = given();
        for (Map.Entry<String, File> entry : formData.entrySet()){
            req.multiPart(entry.getKey(), entry.getValue(), GetMimeTypes(entry.getValue()));
        }
        return req.spec(getCurrentReqSpec()).
                header("Content-Type", "multipart/form-data").
                when().
                post(url).
                then().
                log().
                ifError().
                extract().response();
    }

    public Response sendPostImplicit(String url, Map<String, Object> formData) {
        RequestSpecification req = given();
        for (Map.Entry<String, Object> entry : formData.entrySet()){
            if (entry.getValue() instanceof File){
                req.multiPart(entry.getKey(), (File) entry.getValue(), GetMimeTypes((File) entry.getValue()));
            } else {
                req.multiPart(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        Response res =  req.spec(getCurrentReqSpec()).
                header("Content-Type", "multipart/form-data").
                when().
                post(url).
                then().
                log().
                ifError().
                extract().response();
        setResponse(res);
        return res;

    }

    public Response sendPostWithPathParams(String url, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create().pathParams(pathParameters);
        return doPost(url,httpRequest);
    }

    /**
     * send POST without object or request parameter
     *
     * @param url - URL of API endpoint
     * @return Response object instance
     */
    public Response sendPost(String url) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create();
        return doPost(url,httpRequest);
    }

    /**
     * send PUT without object payload
     *
     * @param url - URL of API endpoint
     * @return Response object instance
     */
    public Response sendPut(String url) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create();
        return doPut(url,httpRequest);
    }

    /**
     * send PUT with object payload
     *
     * @param url  - URL of API endpoint
     * @param body - request payload (in form of object instance)
     * @return Response object instance
     */
    public Response sendPut(String url, Object body) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create();
        return doPut(url,httpRequest);
    }

    /**
     * send PUT with path param and string payload
     *
     * @param url            - URL of API endpoint
     * @param body           - request payload (in form of JSON string)
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendPut(String url, Map<String, Object> body, String pathParamName,
                            Object pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParamName,pathParamValue).create().body(body);
        return doPut(url,httpRequest);
    }

    public Response sendPut(String url, Object body, String pathParamName, Object pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body,pathParamName,pathParamValue).create();
        return doPut(url,httpRequest);
    }

    public Response sendPut(String url, Object body, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().pathParams(pathParameters);
        return doPut(url,httpRequest);
    }

    public Response sendPutWithPathParams(String url, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create().pathParams(pathParameters);
        return doPut(url,httpRequest);
    }

    /**
     * send PUT with path param and string payload
     *
     * @param url            - URL of API endpoint
     * @param body           - request payload (in form of JSON string)
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendPut(String url, Object body, String pathParamName, Object pathParamValue,
                            Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body,pathParamName,pathParamValue,params).create();
        return doPut(url,httpRequest);
    }

    /**
     * send PATCH without object payload
     *
     * @param url - URL of API endpoint
     * @return Response object instance
     */
    public Response sendPatch(String url) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create();
        return doPatch(url,httpRequest);
    }

    /**
     * send PATCH with object payload
     *
     * @param url  - URL of API endpoint
     * @param body - request payload (in form of object instance)
     * @return Response object instance
     */
    public Response sendPatch(String url, Object body) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create();
        return doPatch(url,httpRequest);
    }

    /**
     * send PATCH with path param and string payload
     *
     * @param url            - URL of API endpoint
     * @param body           - request payload (in form of JSON string)
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendPatch(String url, Map<String, Object> body, String pathParamName,
                              Object pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParamName, pathParamValue).create().body(body);
        return doPatch(url,httpRequest);
    }

    public Response sendPatch(String url, Object body, String pathParamName, Object pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body,pathParamName, pathParamValue).create();
        return doPatch(url,httpRequest);
    }

    public Response sendPatch(String url, Object body, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().pathParams(pathParameters);
        return doPatch(url,httpRequest);
    }

    /**
     * send PATCH with path param and string payload
     *
     * @param url            - URL of API endpoint
     * @param body           - request payload (in form of JSON string)
     * @param pathParamName  - name of path param, ie. "id"
     * @param pathParamValue - value of path param, i.e. "94a23187-7fad-4358-976d-67e049d1fcd7"
     * @return Response object instance
     */
    public Response sendPatch(String url, Object body, String pathParamName, Object pathParamValue,
                              Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body, pathParamName,pathParamValue,params).create();
        return doPatch(url,httpRequest);
    }

    public Response sendPatch(String url, Object body, Map<String, String> pathParameters,
                              Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body, pathParameters ,params).create();
        return doPatch(url,httpRequest);
    }

    /**
     * send DELETE without parameters (example: /store-orders)
     *
     * @param url - URL of API endpoint
     * @return Response object instance
     */
    public Response sendDelete(String url) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create();
        return doDelete(url,httpRequest);
    }

    /**
     * send DELETE without parameters (example: /store-orders)
     *
     * @param url            - URL of API endpoint
     * @param pathParamName
     * @param pathParamValue
     * @return Response object instance
     */
    public Response sendDelete(String url, String pathParamName, Object pathParamValue) {
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParamName,pathParamValue).create();
        return doDelete(url,httpRequest);
    }

    public Response sendDelete(String url, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder().create().pathParams(pathParameters);
        return doDelete(url,httpRequest);
    }


    /**
     * send DELETE without parameters (example: /store-orders)
     *
     * @param url            - URL of API endpoint
     * @param pathParamName
     * @param pathParamValue
     * @param params
     * @return Response object instance
     */
    public Response sendDelete(String url, String pathParamName, Object pathParamValue,
                               Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(pathParamName,pathParamValue).create().params(params);
        return doDelete(url,httpRequest);
    }

    public Response sendDelete(String url, Map<String, String> pathParameters,
                               Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(params).create().pathParams(pathParameters);
        return doDelete(url,httpRequest);
    }

    public Response sendDelete(String url, Object body, Map<String, String> pathParameters) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().pathParams(pathParameters);
        return doDelete(url,httpRequest);
    }

    public Response sendDelete(String url, String body, Map<String, Object> params) {
        RequestSpecification httpRequest = new HttpRequestBuilder(body).create().params(params);
        return doDelete(url,httpRequest);
    }

    private Response doPost(String url, RequestSpecification requestSpecification) {
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                post(url).
                then().
                log().ifValidationFails().
                extract().response();
        setResponse(res);
        return res;
    }

    private Response doPut(String url, RequestSpecification requestSpecification) {
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                put(url).
                then().
                log().ifValidationFails().
                extract().response();
        setResponse(res);
        return res;
    }

    private Response doPatch(String url, RequestSpecification requestSpecification) {
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                patch(url).
                then().
                log().ifValidationFails().
                extract().response();
        setResponse(res);
        return res;
    }

    private Response doGet(String url, RequestSpecification requestSpecification) {
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                get(url).
                then().
                log().ifValidationFails().
                extract().response();
        setResponse(res);
        return res;
    }

    private Response doDelete(String url, RequestSpecification requestSpecification) {
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                delete(url).
                then().
                log().ifValidationFails().
                extract().response();
        setResponse(res);
        return res;
    }
}
