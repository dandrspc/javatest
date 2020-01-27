package me.dapac.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("Negative times not allowed");
        }

        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str) {
        if(str == null){
            return true;
        }else if(str.equals("")){
            return true;
        }else if(str.trim().equals("")){
            return true;
        }
        return false;
    }
}
