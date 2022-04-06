package ru.lvv;

import java.util.TreeMap;

public class ConverterNumber {
    private final static TreeMap<Integer, String> mapToRoman = new TreeMap<>();
    static {
        mapToRoman.put(100, "C");
        mapToRoman.put(90, "XC");
        mapToRoman.put(50, "L");
        mapToRoman.put(40, "XL");
        mapToRoman.put(10, "X");
        mapToRoman.put(9, "IX");
        mapToRoman.put(5, "V");
        mapToRoman.put(4, "IV");
        mapToRoman.put(1, "I");
    }
    public static String arabToRims(int intNumber) {
        int keyBigObjSmall =  mapToRoman.floorKey(intNumber);
        if ( intNumber == keyBigObjSmall ) {
            return mapToRoman.get(intNumber);
        }
        return mapToRoman.get(keyBigObjSmall) + arabToRims(intNumber-keyBigObjSmall);
    }


    private final static TreeMap<String, Integer> mapToArab = new TreeMap<>();
    static {
        mapToArab.put("X", 10);
        mapToArab.put("IX", 9);
        mapToArab.put("V", 5);
        mapToArab.put("IV", 4);
        mapToArab.put("I", 1);
    }
    public static int rimsToArab(String strNumber) {
        String [] arrayKey = mapToArab.descendingKeySet().toArray(new String[0]);
        if (mapToArab.containsKey(strNumber)) {
            return mapToArab.get(strNumber);
        }
        int strNumLen = strNumber.length();
        int sumArab = 0;
        for (int j = 0; j < strNumLen; j++ )
            for (String s : arrayKey) {
                if (strNumber.contains(s)) {
                    sumArab = sumArab + mapToArab.get(s);
                    strNumber = strNumber.replaceFirst(s, "");
                }
            }
        return sumArab;
    }

}
