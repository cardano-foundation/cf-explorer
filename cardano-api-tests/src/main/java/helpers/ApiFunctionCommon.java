package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Random;

public class ApiFunctionCommon {
    public static Map<String, Object> RemoveKeys(Map<String, Object> source, String[] keys){
        for(String key : keys) {
            if(source.containsKey(key)) source.remove(key);
            for (Map.Entry<String, Object> entry : source.entrySet()) {
                if(entry.getValue() instanceof Map) {
                    ObjectMapper oMapper = new ObjectMapper();
                    Map<String, Object> childMap = oMapper.convertValue(entry.getValue(), Map.class);
                    if(childMap.containsKey(key)) childMap.remove(key);
                }
            }
        }
        return source;
    }
    public static double getRandomNumberBetweenRange(double min, double max) {
        Random r = new Random();
        double x = min + (max - min) * r.nextDouble();
        return Math.round(x * 100.0) / 100.0;
    }
}
