package ru.lvv;

public class ErrorMyCalc {
    public String errorMyCalc(String error) {
        int intError = Integer.parseInt(error);
        if (intError == 0) {
            return "Странная ошибка!!!";
        } else if (intError == 1) {
            return "Ошибка в арифметических действиях. Нужно использоваться только одно арифметичаское действие: либо '+', либо '-', либо '+', либо '*', либо '/'.";
        } else if (intError == 2) {
            return "Некорректно введено 1-ое число и(или) 2-ое число (арабские от 1 до 10, римские от I до X).";
        } else if (intError == 3) {
            return "Арифметическое выражение должно состоять только из арабских чисел или из римских чисел.";
        } else if (intError == 4) {
            return "Римские числа не могут быть отрицательными или равные 0.";
        } else {
            return "Новая ошибка";
        }
    }
}