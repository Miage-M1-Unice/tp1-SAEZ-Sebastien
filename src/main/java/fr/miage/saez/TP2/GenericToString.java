package fr.miage.saez.TP2;

import org.apache.commons.lang3.ArrayUtils;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class GenericToString {

    private String result = "";

    public String toString(Object obj, int deep) throws IllegalAccessException {
        if(deep > 0) {
            result += obj.getClass().getName() + "[";
            Field[] fields = ArrayUtils.addAll(obj.getClass().getDeclaredFields(), obj.getClass().getSuperclass().getDeclaredFields());

            for (Field field : fields) {
                field.setAccessible(true);

                result += field.getName() + " = ";
                if(field.get(obj).getClass().isArray()){
                    result += "{";
                    for(int i = 0; i<Array.getLength(field.get(obj));i++){
                        result += Array.get(field.get(obj),i);
                        if(i!= (Array.getLength(field.get(obj))-1)){
                            result += ",";
                        }

                    }
                    result += "}";

                }else{
                    result += field.get(obj);
                    result += "; ";

                    if(!field.getType().isPrimitive()){
                        deep--;
                        this.toString(field.get(obj), deep);
                    }
                }



            }

            result += "]";
        }
        return this.result;
    }

    static public void main(String[] args) {
        try {
          //  System.out.println(new GenericToString().toString(new Point(12,24),2));

            Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
            pol.getBounds();
            System.out.println(new GenericToString().toString(pol, 2));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
