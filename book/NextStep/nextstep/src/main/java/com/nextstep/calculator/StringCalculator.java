package com.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    // 하나에 메서드에 모든 기능을 중첩
//    static int add(String text) {
//        if(text.isEmpty() || text == null) {
//            return 0;
//        }
//        int result = 0;
//
//        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
//        if(m.find()) {
//            String customDelimeter = m.group(1);
//            String[] tokens = m.group(2).split(customDelimeter);
//            for (String token : tokens) {
//                Integer toke = Integer.valueOf(token);
//                if(toke < 0) {
//                    throw new RuntimeException();
//                }
//                result += toke;
//            }
//            return result;
//        }
//
//        String[] split = text.split(":|,");
//        for (String s : split) {
//            Integer in = Integer.valueOf(s);
//            if(in < 0) {
//                throw new RuntimeException();
//            }
//            result += in;
//        }
//        return result;
//    }

    // 메서드 분리
    public static int add(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }
        String[] strArr = commonRegExp(text);
        return sum(toInts(strArr));
    }

    // 리팩토링 메소드가 한가지 책임만 가지도록 구현
    // 인덴트는 깊이가 1단계만 허용 else 사용 금지
    public static String[] commonRegExp (String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return text.split(",|:");
    }

    public static void exception(int num) {
        if(num < 0){
            throw new RuntimeException();
        }
    }

    public static int sum (int[] intArr) {
        int result = 0;

        for (int num : intArr) {
            exception(num);
            result += num;
        }
        return result;
    }

    public static int[] toInts (String[] strArr) {
        int sum[] = new int[strArr.length];
        for(int i=0; i< strArr.length; i++) {
            sum[i] = Integer.valueOf(strArr[i]);
        }
        return sum;
    }

    public static boolean isNullOrEmpty(String text) {
        boolean isEmptyOrNull = false;
        if(text.isEmpty() || text == null){
            isEmptyOrNull = true;
        }
        return isEmptyOrNull;
    }
}
