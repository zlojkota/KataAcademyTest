package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MainTest {

    private static Map<String,String> positive = new HashMap<>();
    private static Map<String,String> negative = new HashMap<>();
    @BeforeAll
    static void setUp() {
        positive.put("1 + 2",    "3");
        positive.put("2 - 1",    "1");
        positive.put("I + II",   "III");
        positive.put("IV + I",   "V");
        positive.put("V + I",    "VI");
        positive.put("VIII + I", "IX");
        positive.put("IX + I",   "X");
        positive.put("X + I",    "XI");
        positive.put("1 * 2",    "2");
        positive.put("IV * II",  "VIII");
        positive.put("4 / 2",    "2");
        positive.put("5 / 2",    "2");
        positive.put("V / II",   "II");

        negative.put("I-II",     "\n\nInvalid Roman result in arabic numerals: -1\nResult are both only positive.\n\n");
        negative.put("I+1",      "\n\nInvalid input: I+1\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("3-II",     "\n\nInvalid input: 3-II\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("I",        "\n\nInvalid input: I\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("1",        "\n\nInvalid input: 1\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("abyrvalg", "\n\nInvalid input: abyrvalg\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("1+2+3",    "\n\nInvalid input: 1+2+3\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("11+1",     "\n\nInvalid input: 11+1\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
        negative.put("XI+I",     "\n\nInvalid input: XI+I\nUsage: a + b, a - b, a * b, a / b;\nWhere: a,b are both Arabic or Roman numerals from 0 to 10 inclusive.\n\n");
    }

    @Test
    void calcPositive() {
        positive.forEach((k,v)-> {
            try {

                Assertions.assertEquals(v,Main.calc(k),"Testing "+k+" = "+v);

            } catch (calcExceptions e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void calcNegative() {
        negative.forEach((k,v)-> {

	calcExceptions thrown = Assertions.assertThrows(calcExceptions.class, () -> {
		Main.calc(k);
	}, "Exception for "+k+" was expected");

	Assertions.assertEquals(v, thrown.getMessage());

        });
    }
}