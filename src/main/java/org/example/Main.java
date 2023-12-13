package org.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.RomanArabicConverter.arabicToRoman;
import static org.example.RomanArabicConverter.romanToArabic;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws calcExceptions {
        System.out.print( "\n\n\nInput string action, where: a + b, a - b, a * b, a / b; a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\nInput: " );
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String input = in.next();
        System.out.println( "Result: "+input+"="+calc(input) );
    }

    public static String calc(String input) throws calcExceptions{
        Pattern pattern = Pattern.compile("^((?<aarabic>10|[0-9])([ \\t]*+)(?<actionarabic>[-+*/])([ \\t]*+)(?<barabic>10|[0-9]))|((?<aroman>X|IX|IV|V?I{0,3})([ \\t]*+)(?<actionroman>[-+*/])([ \\t]*+)(?<broman>X|IX|IV|V?I{0,3}))$");
        Matcher matcher = pattern.matcher(input);
        boolean isMatched = matcher.matches();
        if (!isMatched) {
            throw new calcExceptions(1,input);
        }
        if (matcher.group("aarabic")!=null){
            switch (actionToInt(matcher.group("actionarabic"))){
                //-
                case 0:
                    return Integer.toString(Integer.parseInt(matcher.group("aarabic"))-Integer.parseInt(matcher.group("barabic")));
                //+
                case 1:
                    return Integer.toString(Integer.parseInt(matcher.group("aarabic"))+Integer.parseInt(matcher.group("barabic")));
                //*
                case 2:
                    return Integer.toString(Integer.parseInt(matcher.group("aarabic"))*Integer.parseInt(matcher.group("barabic")));
                // /
                case 3:
                    return Integer.toString(Integer.parseInt(matcher.group("aarabic"))/Integer.parseInt(matcher.group("barabic")));
                default:
                    throw new calcExceptions(127,"Error in Matcher arabic. Magic!");
            }
        } else if (matcher.group("aroman")!=null) {
            int arabianResult;
            switch (actionToInt(matcher.group("actionroman"))){
                //-
                case 0:
                    arabianResult = romanToArabic(matcher.group("aroman"))-romanToArabic(matcher.group("broman"));
                    break;
                //+
                case 1:
                    arabianResult = romanToArabic(matcher.group("aroman"))+romanToArabic(matcher.group("broman"));
                    break;
                //*
                case 2:
                    arabianResult = romanToArabic(matcher.group("aroman"))*romanToArabic(matcher.group("broman"));
                    break;
                // /
                case 3:
                    arabianResult = romanToArabic(matcher.group("aroman"))/romanToArabic(matcher.group("broman"));
                    break;
                default:
                    throw new calcExceptions(127,"Error in Matcher roman. Magic!");
            }
            if (arabianResult <1 ){
                throw new calcExceptions(2,Integer.toString(arabianResult));
            }
            return arabicToRoman(arabianResult);
        }

    return "";
    }

    private static int actionToInt(String action){
        if (Objects.equals(action, "-")) return 0; else
        if (Objects.equals(action, "+")) return 1; else
        if (Objects.equals(action, "*")) return 2; else
        if (Objects.equals(action, "/")) return 3;
            else return 127;
    }
}
