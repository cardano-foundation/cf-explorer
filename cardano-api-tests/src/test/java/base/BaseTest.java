package base;

import constants.Url;
import core.BaseApi;
import httprequest.HttpRequest;
import io.restassured.RestAssured;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void preconditions(@Optional("preprod") String env) {
        if (System.getProperty("cardanoAPI.baseEnv") == null) {
            System.setProperty("cardanoAPI.baseEnv", env);
        }
        new Url(System.getProperty("cardanoAPI.baseEnv"));
        BaseApi.initReqSpec();
        BaseApi.setBaseUrl(Url.API);
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        BaseApi.initReqSpec();
        BaseApi.setBaseUrl(Url.API);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        RestAssured.reset();
    }
    @AfterSuite(alwaysRun = true)
    public void postconditions() {
        RestAssured.reset();
    }
    public boolean isPreprodEnv() {
        return System.getProperty("cardanoAPI.baseEnv").contains("preprod");
    }
}
