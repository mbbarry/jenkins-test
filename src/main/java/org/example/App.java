package org.example;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        cal.setTimeInMillis(System.currentTimeMillis());

        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }
}
