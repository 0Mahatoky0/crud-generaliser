package util;

import java.util.Arrays;
import java.util.HashMap;
public class ObjectMaping {
    private static HashMap<Class<?>,ObjectMaping> map; 

    private String tableName;
    private String[] columns;

    private ObjectMaping(String tableName, String[] columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public static ObjectMaping get(Class<?> class1) {
        if(map == null) {
            map = new HashMap<>();
        }
        if(!map.containsKey(class1)) {
            ObjectMaping objMap = toObjetMap(class1);
            map.put(class1,objMap);
        }
        return map.get(class1);
    }

    public static ObjectMaping toObjetMap(Class<?> class1) {
        String tableName = GenUtil.getSimpleName(class1);
        String[] atributs = GenUtil.getAttributs(class1);
        ObjectMaping objectMaping = new ObjectMaping(tableName,atributs);
        return objectMaping;
    }

    public String getTableName() {
        return tableName;
    }

    public String[] getcolumns() {
        return columns;
    }

    @Override
    public String toString() {
        return this.tableName + " : ( " + Arrays.toString(columns) + " )" ;
    }
}
