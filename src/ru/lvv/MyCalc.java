package ru.lvv;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyCalc {

    public static void main(String[] arg) throws FileNotFoundException {
        boolean exitWhile = true;
        String yesNoHelp = "yes";
        LineText lT = new LineText();
        ErrorMyCalc eMC = new ErrorMyCalc();
        OpenFileHelp oFH = new OpenFileHelp();
        Scanner in = new Scanner(System.in);
        Scanner inTextLine = new Scanner(System.in);

        do{
            if (yesNoHelp.equals("yes")){
                System.out.println("Введте арифметическое выражение, состоящее из одного арифметического действия и двух чисел (либо арабские, либо римские): ");
                String textLine = inTextLine.nextLine();
                String[] text = lT.mathLine(textLine);
                if (text[0].equals("0")){
                    System.out.println(eMC.errorMyCalc(text[1]));
                }
                if (text[0].equals("1")){
                    System.out.println("Ответ: "+text[1]);
                }
            }else if (yesNoHelp.equals("help")){
                oFH.openFileHelp();
            }
            System.out.println("Вы хотите продолжить (yes/no/help)?");
            yesNoHelp=in.nextLine();
            if (yesNoHelp.equals("no")){
                exitWhile = false;
            }
        }while(exitWhile);
        inTextLine.close();
        in.close();
    }
}
