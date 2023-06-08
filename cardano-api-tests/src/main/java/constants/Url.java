package constants;


import com.google.gson.JsonObject;
import util.JsonUtils;

public class Url {
    public static String API;
    public Url(String env) {
        JsonObject map;
        map = JsonUtils.readJsonFile("url.json");
        JsonObject environment = map.getAsJsonObject(env);
        API = environment.get("API").getAsString();
        }
}
