package test_08;

import java.lang.reflect.Array;
import java.util.*;

public class Seliger {

    private Map<Character, List<Character>> map;

    public static void main(String[] args) {

        Seliger seliger = new Seliger();


//        System.out.println(seliger.checkValidString(")******"));        // false
//        System.out.println(seliger.checkValidString(")("));             // false
//        System.out.println(seliger.checkValidString(")***"));           // false
//        System.out.println(seliger.checkValidString("(()))"));          // false
//        System.out.println(seliger.checkValidString(")"));              // false
//        System.out.println(seliger.checkValidString("("));              // false
//        System.out.println(seliger.checkValidString("(((((***"));       // false
//        System.out.println(seliger.checkValidString("*******()("));     // false
//        System.out.println(seliger.checkValidString("*(()"));           // false
//        System.out.println(seliger.checkValidString("(()))"));          // false
//        System.out.println(seliger.checkValidString("((())"));          // false
//        System.out.println(seliger.checkValidString("((*))"));          // true
//        System.out.println(seliger.checkValidString("*"));              // true
//        System.out.println(seliger.checkValidString("*"));              // true
//        System.out.println(seliger.checkValidString("(*)"));            // true
//        System.out.println(seliger.checkValidString("(*))"));           // true

//        System.out.println(seliger.checkValidString("(*)))"));          // false
//        System.out.println(seliger.checkValidString(")*"));          // false
//        System.out.println(seliger.checkValidString("*("));          // false
//        System.out.println(seliger.checkValidString("))*"));          // false
//        System.out.println(seliger.checkValidString("*))"));          // false

//        System.out.println(seliger.checkValidString("*(*))"));          // true
//        System.out.println(seliger.checkValidString("************(*))"));          // true
        System.out.println(seliger.checkValidString("**()"));

    }

    public boolean checkValidString(String s) {

        int cMax = 0, cMin = 0;
        for (char c: s.toCharArray()) {
            cMin += c == '(' ? 1 : -1; // take * as ')'
            cMax += c != ')' ? 1 : -1; // take * as '('
            if (cMax < 0) return false; // not enough ')'
            cMin = Math.max(cMin, 0); // revert the decision to take * as '('
        }
        return cMin == 0;
    }
}
