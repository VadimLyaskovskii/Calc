package ru.lvv;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyCalc {

    public static void main(String[] arg) throws FileNotFoundException{
        boolean exitWhile = true;
        String yesNoHelp = "yes";
        String answer;
        LineText lT = new LineText();
        OpenFileHelp oFH = new OpenFileHelp();
        Scanner in = new Scanner(System.in);
        Scanner inTextLine = new Scanner(System.in);

        do{
            if (yesNoHelp.equals("yes")){
                System.out.println("Введте арифметическое выражение, состоящее из одного арифметического действия и двух чисел (либо арабские, либо римские): ");
                String textLine = inTextLine.nextLine();
                try {
                    answer = lT.mathLine(textLine);
                    System.out.println("Ответ: "+answer);
                } catch (CalcException e) {
                    System.err.println(e.getCalc());
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
