package com.escmobile.lab.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> asList(char[] array) {

        List<Integer> list = new ArrayList<Integer>();

        for (int c : array) {
            list.add(c);
        }

        return list;
    }


    /**
     *
     * @param lookIn
     * @param lookFor
     * @return
     */
    public static boolean includes(String lookIn, String lookFor) {

        if (lookIn.equalsIgnoreCase(lookFor)) return false;

        int lookForIndex = 0;
        char charLookFor;

        for (int i = 0; i < lookIn.length(); i++) {

            if (lookForIndex >= lookFor.length()) return true;

            char charNow = lookIn.charAt(i);
            charLookFor = lookFor.charAt(lookForIndex);

            if (charNow == charLookFor) {
                lookForIndex++;
            } else {
                charLookFor = 0;
            }
        }

        return false;
    }
}
