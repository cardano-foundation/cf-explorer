package util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    public JsonUtils() {
    }

    public static JsonObject readJsonFile(String fileName) {
        JsonObject object = null;
        Gson gson = new Gson();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try {
            InputStream is = classloader.getResourceAsStream(fileName);
            Throwable var5 = null;

            try {
                InputStreamReader streamReader = new InputStreamReader(is);
                Throwable var7 = null;

                try {
                    BufferedReader reader = new BufferedReader(streamReader);
                    Throwable var9 = null;

                    try {
                        object = (JsonObject)gson.fromJson(reader, JsonObject.class);
                    } catch (Throwable var56) {
                        var9 = var56;
                        throw var56;
                    } finally {
                        if (reader != null) {
                            if (var9 != null) {
                                try {
                                    reader.close();
                                } catch (Throwable var55) {
                                    var9.addSuppressed(var55);
                                }
                            } else {
                                reader.close();
                            }
                        }

                    }
                } catch (Throwable var58) {
                    var7 = var58;
                    throw var58;
                } finally {
                    if (streamReader != null) {
                        if (var7 != null) {
                            try {
                                streamReader.close();
                            } catch (Throwable var54) {
                                var7.addSuppressed(var54);
                            }
                        } else {
                            streamReader.close();
                        }
                    }

                }
            } catch (Throwable var60) {
                var5 = var60;
                throw var60;
            } finally {
                if (is != null) {
                    if (var5 != null) {
                        try {
                            is.close();
                        } catch (Throwable var53) {
                            var5.addSuppressed(var53);
                        }
                    } else {
                        is.close();
                    }
                }

            }
        } catch (Exception var62) {
            var62.printStackTrace();
        }

        return object;
    }

    public static List<String> parseJsonArrayToListString(JsonObject jsonObject, String jsonPath) {
        JsonElement jsonElement = jsonObject.get(jsonPath);
        Type listType = (new TypeToken<List<String>>() {
        }).getType();
        return (List)(new Gson()).fromJson(jsonElement, listType);
    }

    public static String getFromJwt(String jwt, String fieldName) {
        String jwtPayloadEncoded = jwt.split("\\.")[1];
        String jwtPayloadDecoded = new String(Base64.getDecoder().decode(jwtPayloadEncoded));
        return parseJsonStringToJsonObject(jwtPayloadDecoded).get(fieldName).getAsString();
    }

    public static JsonObject parseJsonStringToJsonObject(String jsonAsString) {
        return (new JsonParser()).parse(jsonAsString).getAsJsonObject();
    }

    public static String parseMapToJsonString(Map<String, String> map) {
        return (new Gson()).toJson(map);
    }

    public static JsonArray getFromJwtAsJsonArray(String jwt, String fieldName) {
        String jwtPayloadEncoded = jwt.split("\\.")[1];
        String jwtPayloadDecoded = new String(Base64.getDecoder().decode(jwtPayloadEncoded));
        return parseJsonStringToJsonObject(jwtPayloadDecoded).get(fieldName).getAsJsonArray();
    }

    public class CustomSerializer extends JsonSerializer<Object> {
        public CustomSerializer() {
        }

        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeStartObject();
            jgen.writeObjectField(value.getClass().getName(), value);
            jgen.writeEndObject();
        }
    }
}