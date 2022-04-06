package ru.lvv;

public class LineText {
    String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] rims = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] sign = new String[]{"+", "-", "*", "/"};
    int numSign = 1;

    private String lineTextNoSpace(String str) {
        String textNoSpase;
        textNoSpase = str.replaceAll(" ", "");
        return textNoSpase;
    }

     private int checkNumber(String str) {
        for (String s : arab) {
            if (str.equals(s)) {
                return 1; //Арабское число
            }
        }
        for (String s : rims) {
            if (str.equals(s)) {
                return 2; //Римское число
            }
        }
        return 3; //Некорректное число
     }

     private int intCalc(int intNum1, int intNum2, char chSing) {
         int result = 0;
         switch (chSing) {
             case '+' -> result = intNum1 + intNum2;
             case '-' -> result = intNum1 - intNum2;
             case '*' -> result = intNum1 * intNum2;
             case '/' -> result = intNum1 / intNum2;
             default -> System.out.println("Ошибка в распознавании выражения");
         }
         return result;
     }


     private String strArabCalc(String strNum1, String strNum2, char chSign) {
         int intNum1 = Integer.parseInt(strNum1);
         int intNum2 = Integer.parseInt(strNum2);
         int intResult = intCalc(intNum1, intNum2, chSign);
         return Integer.toString(intResult);
     }


    private String strRimsCalc(String strNum1, String strNum2, char chSign) {
        int intNum1 = ConverterNumber.rimsToArab(strNum1);
        int intNum2 = ConverterNumber.rimsToArab(strNum2);
        int intResult = intCalc(intNum1, intNum2, chSign);
        if (intResult < 1) {
            return "false";
        }
        return ConverterNumber.arabToRims(intResult);
    }

     public String[] mathLine (String str) {
        String strNumber1;
        String strNumber2;
        char chSign;
        int sumSign = 0;
        int operatorZ = 0;
        int checkNum1;
        int checkNum2;
        str = lineTextNoSpace(str);
        for (int j = 0; j < str.length(); j++) {
            for (String s : sign) {
                if (str.charAt(j) == s.charAt(0)) {
                    sumSign++;
                    operatorZ = j;
                }
            }
        }
        if (sumSign!=numSign) {
            return new String[]{"0", "1"};//Ошибка в арифметических действиях. Можно использоваться только одно арифметичаское действие: либо "+", либо "-", либо "*", либо "/".
        }else {
            strNumber1 = str.substring(0, operatorZ);
            strNumber2 = str.substring(operatorZ+1);
            chSign = str.charAt(operatorZ);
            checkNum1 = checkNumber(strNumber1);
            checkNum2 = checkNumber(strNumber2);
            if ((checkNum1==3)&&(checkNum2==3)||(checkNum1==1)&&(checkNum2==3)|| (checkNum1==3)&&(checkNum2==1)||(checkNum1==2)&&(checkNum2==3)||(checkNum1==3)&&(checkNum2==2)) {
                return new String[]{"0", "2"};//Некорректно введено 1-ое число и(или) 2-ое число (арабские от 1 до 10, римские от I до X).
            }
            if((checkNum1==1)&&(checkNum2==2)||(checkNum1==2)&&(checkNum2==1)){
                return new String[]{"0", "3"};//Арифметическое выражение должно состоять только из арабских чисел или из римских чисел.
            }
            if ((checkNum1==1)&&(checkNum2==1)) {
                return new String[]{"1", strArabCalc(strNumber1, strNumber2, chSign)};
            }
            if ((checkNum1==2)&&(checkNum2==2)) {
                if(strRimsCalc(strNumber1, strNumber2, chSign).equals("false")) {
                    return new String[]{"0", "4"};//Римские числа не могут быть отрицательными или равные 0.
                }else {
                    return new String[]{"1", strRimsCalc(strNumber1, strNumber2, chSign)};
                }
            }

        }
        return new String[]{"0", "0"};
    }
}
