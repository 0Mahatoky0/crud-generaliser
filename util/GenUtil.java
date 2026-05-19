package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenUtil {
    public static void putId(Object object , int id) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
        Method setterId = getSetter("id", object);
        setterId.invoke(object, id);
    }
    public static String[] getAttributs(Class<?> class1) {
        ArrayList<String> fieldName = new ArrayList<>();
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            fieldName.add(field.getName());
        }
        return fieldName.toArray(new String[0]);
    }

    public static Object[] getFieldsValuesWithout(Object obj,List<String> ingioredField) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ObjectMaping objMap = ObjectMaping.get(obj.getClass());
        ArrayList<Object> atributesVal = new ArrayList<>();
        for (String fn : objMap.getcolumns()) {
            if(!ingioredField.contains(fn)) {
                Object fieldsVal = getFildValue(fn, obj);
                atributesVal.add(fieldsVal);
            }
        }
        return atributesVal.toArray(new Object[0]);
    }

    public static Object[] getFieldsValues(Object obj) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ObjectMaping objMap = ObjectMaping.get(obj.getClass());
        ArrayList<Object> atributesVal = new ArrayList<>();
        for (String fn : objMap.getcolumns()) {
            Object fieldsVal = getFildValue(fn, obj);
            atributesVal.add(fieldsVal);
        }
        return atributesVal.toArray(new Object[0]);
    }

    public static Object getFildValue(String filedName,Object obj) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method getter = getGetter(filedName, obj);
        Object val = getter.invoke(obj);
        return val;
    }

    private static Method getGetter(String filedName,Object obj) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
        Class<?> class1 = obj.getClass();
        String getterName = "get" + firstToUpper(filedName) ;
        return class1.getDeclaredMethod(getterName);
    }

    //reucperer les valeur d un atribut
    private static Method getSetter(String filedName,Object obj) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
        Class<?> class1 = obj.getClass();
        Field field =  class1.getDeclaredField(filedName);
        Class<?> fieldType = field.getType();
        String setterName = "set" + firstToUpper(filedName) ;
        return class1.getDeclaredMethod(setterName, fieldType);
    }

    //remplire un objet de valeur 
    public static void bindAtributObject(Object obj,Object[] atributsValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
        ObjectMaping objectMaping = ObjectMaping.get(obj.getClass());
        String[] atributsNames = objectMaping.getcolumns();
        for (int i = 0; i < atributsValues.length; i++) {
            String atributName = atributsNames[i];
            Object valueAtribut = atributsValues[i];
            Method setter = getSetter(atributName,obj);
            setter.invoke(obj,valueAtribut);
        }
    }

    
    private static String firstToUpper(String mot) {
        return  mot.substring(0, 1).toUpperCase() + mot.substring(1);
    }


    public static String getSimpleName(Class<?> class1) {
        return class1.getSimpleName();
    }
}