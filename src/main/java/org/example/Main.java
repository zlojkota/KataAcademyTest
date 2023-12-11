package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws calcExceptions {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String input = in.next();
        System.out.println( "Hello World!"+calc(input) );
    }

    public static String calc(String input) throws calcExceptions{
        Pattern p = Pattern.compile("^((10|[0-9])([ \\t]*+)[-+*/]([ \\t]*+)(10|[0-9]))|((X|IX|IV|V?I{0,3})([ \\t]*+)[-+*/]([ \\t]*+)(X|IX|IV|V?I{0,3}))$");
        Matcher m = p.matcher(input);
        boolean b = m.matches();
        if (!b) {
            throw new calcExceptions(1,input);
        }

        return "OK!";
    }
}
