package util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ObjectMappingUtils {

    public static String parseModelToJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        return gson.toJson(object);
    }

    public static <T> Object parseJsonToModel(String json, Class<T> c) {

        JsonDeserializer<T> deserializer = new JsonDeserializer<T>() {
            public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.isJsonNull()) {
                    return null;
                }
                return new Gson().fromJson(json, typeOfT);
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(c, deserializer);
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, c);
    }

    public static <T> List<T> parseJsonToModelList(String json, Class<T[]> c) {
        JsonDeserializer<T> deserializer = new JsonDeserializer<T>() {
            public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.isJsonNull()) {
                    return null;
                }
                return new Gson().fromJson(json, typeOfT);
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(c, deserializer);
        Gson gson = gsonBuilder.create();
        T[] jsonToObject = gson.fromJson(json, c);
        return Arrays.asList(jsonToObject);
    }

    public static <T> List<T> parseJsonArrayToModelList(JsonElement json, Class<T[]> c){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        T[] jsonToObject = gson.fromJson(json, c);
        return Arrays.asList(jsonToObject);
    }

    public static String parseModelToJsonExcludingField(Object o, String field) {
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getName().toLowerCase().contains(field);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                }).serializeNulls().create();

        return gson.toJson(o);
    }
}
