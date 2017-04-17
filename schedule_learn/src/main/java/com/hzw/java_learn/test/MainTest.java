package com.hzw.java_learn.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("schedule.xml");
        System.out.println("starting ..................... " );
    }
}
