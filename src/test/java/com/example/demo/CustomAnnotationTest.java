package com.example.demo;


import com.example.demo.api.NumberAdder;
import com.example.demo.entity.Number;
import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class CustomAnnotationTest {

    @Test
    public void testNullNumberThrowsException()
    {
        Number number = new Number(1,0,3);

        NumberAdder adder = new NumberAdder();
        Exception exception = assertThrows(Exception.class,()->{
            adder.addElement(number);
    });
        String message = "The value is zero";

        assertEquals(message,exception.getMessage());


    }

    @Test
    public void testReturnSumOfAnnotatedField()
    {
        Number number = new Number(1,2,3);

        NumberAdder adder = new NumberAdder();
        int sum=0;

        try {
             sum = adder.addElement(number);
        }
        catch (Exception e)
        {

        }

        assertEquals(sum,5);

    }



}
