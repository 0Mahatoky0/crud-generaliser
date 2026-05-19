package util;

import java.sql.Date;

import util.exeption.IncastableClassExeption;

public class CastUtil {

    public static Object valueOf(Class<?> type,String valueString) throws IncastableClassExeption {
        //valeur si integer
        if(type.equals(Integer.class) || type.equals(int.class) ) {
            return Integer.valueOf(valueString);
        }

        //valeur si double
        if(type.equals(Double.class) || type.equals(double.class)) {
            return Double.valueOf(valueString);
        }

        //valeur si string
        if(type.equals(String.class)) {
            return valueString;
        }
        
        //valeur si Date
        if(type.equals(Date.class)) {
            return Date.valueOf(valueString);
        }

        throw new IncastableClassExeption(type);
    }
}
