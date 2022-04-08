package ru.lvv;

public class CalcException extends Exception{
    ErrorMyCalc eMC = new ErrorMyCalc();
    String calcError;
    public CalcException (String calcError){
       this.calcError = calcError;
    }
     public String getCalc(){
        return eMC.errorMyCalc(calcError);
     }

}
