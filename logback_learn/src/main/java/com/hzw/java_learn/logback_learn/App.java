package com.hzw.java_learn.logback_learn;

import java.io.ObjectInputStream.GetField;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Logger logger = LoggerFactory.getLogger(App.class);
        
        
        for(int i=0 ; i<2000 ; i++){
        	logger.info(""+ new Date() + i);
        }
        
    }
}
