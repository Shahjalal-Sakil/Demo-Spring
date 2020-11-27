package com.example.demo.api;

import com.example.demo.annotations.AdderClass;
import com.example.demo.annotations.NotZero;
import com.example.demo.annotations.NumberIncrement;

import java.lang.reflect.Field;

public class NumberAdder {

    public int getSum(Object object) throws IllegalAccessException
    {
        Class<?> cls = object.getClass();
        int sum = 0;

        for(Field field: cls.getDeclaredFields())
        {
            if(field.isAnnotationPresent(NumberIncrement.class))
            {

                field.setAccessible(true);
                sum += (int) field.get(object);

            }
        }

        return sum;
    }

    public void checkZero(Object object) throws NullPointerException,IllegalAccessException
    {
        Class<?> cls = object.getClass();
        for(Field field: cls.getDeclaredFields())
        {
            if(field.isAnnotationPresent(NotZero.class))
            {

                field.setAccessible(true);
                if ((int)field.get(object)==0)
                {
                    throw new NullPointerException("The value is zero");
                }
            }
        }

    }

    public int addElement(Object object) throws IllegalAccessException,Exception
    {
        Class<?> cls = object.getClass();
        if (cls.isAnnotationPresent(AdderClass.class))
        {
            checkZero(object);
            return getSum(object);
        }
        else{
            throw new Exception("Not Eligible");
        }

    }
}
