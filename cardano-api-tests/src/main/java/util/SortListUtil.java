package util;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

public class SortListUtil {
    public static boolean isSortedByField(List<Object> objs, List<String> fields) {
        Comparator<Object> comparator = (obj1, obj2) -> {
            for (String _field : fields) {
                String[] temp = _field.split(",");
                String field = temp[0];
                String sort = temp[1];
                Comparable<Object> value1 = (Comparable<Object>) getValue(obj1, field);
                Comparable<Object> value2 = (Comparable<Object>) getValue(obj2, field);
                int compareResult = value2.compareTo(value1);
                if (compareResult != 0) {
                    return sort.equals("ASC") ? compareResult : -compareResult;
                }
            }
            return 0;
        };
        boolean check = true;
        for (int i = 0; i < objs.size() -1; i++) {
            Object cur = objs.get(i);
            Object next = objs.get(i + 1);
            if (comparator.compare(cur, next) < 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    static Object getValue(Object obj, String f) {
        Field field = null;
        try {
            field = obj.getClass().getDeclaredField(f);

            field.setAccessible(true);
            return field.get(obj);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
