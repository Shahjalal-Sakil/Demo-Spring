package com.example.demo.api;

import com.example.demo.annotations.JsonElement;
import com.example.demo.annotations.JsonInit;
import com.example.demo.annotations.JsonSerializable;
import com.example.demo.entity.Number;
import com.example.demo.entity.Person;
import com.example.demo.service.ExceptionsClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class ObjectToJsonConverter {

    public static String ConvertToJson(Object object) throws ExceptionsClass
    {
        try
        {
            isObjectSerializable(object);
            initObject(object);
            return getJson(object);
        }
        catch (Exception e)
        {
            throw new ExceptionsClass(e.getMessage());
        }
    }

    public static void isObjectSerializable(Object object)
    {
        if(Objects.isNull(object))
        {
            throw new ExceptionsClass("Object is NuLL!!!");
        }

        Class<?> cls = object.getClass();

        if(!cls.isAnnotationPresent(JsonSerializable.class))
        {
            throw new ExceptionsClass("Class is not eligible to jsonify");
        }
    }

    public static void initObject(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<?> cls = object.getClass();
        for (Method method: cls.getDeclaredMethods())
        {

            if(method.isAnnotationPresent(JsonInit.class))
            {
                method.setAccessible(true);
                method.invoke(object);
            }
        }

    }

    public  static String getJson(Object object) throws IllegalAccessException
    {
        Class<?> cls = object.getClass();

        String str = "";

        for (Field field: cls.getDeclaredFields())
        {
            if(field.isAnnotationPresent(JsonElement.class))
            {
                field.setAccessible(true);
                str += getKey(field) + (String) field.get(object);

            }
        }

        return str;
    }

    public static String getKey(Field field)
    {
        String value = field.getAnnotation(JsonElement.class).key();

        return value.isEmpty() ? field.getName() : value;
    }


    public static void main(String[] args)
    {
       // Person person = new Person("Shahjalal","Sakil","25");
       // String res = ConvertToJson(person);

        Number number = new Number(1,0, 3);
        NumberAdder numberAdder = new NumberAdder();
        try {
            int res = numberAdder.addElement(number);

            System.out.println(res);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



}
