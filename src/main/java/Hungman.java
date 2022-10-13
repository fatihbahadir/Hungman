
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Hungman {

    public static final String[] WORDS = {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
            "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
    };

    public static char getChar(){
        Scanner myObj=new Scanner(System.in);
        System.out.print("Enter the character :");
        char guessChar=myObj.next().charAt(0);
        return Character.toUpperCase(guessChar);
    };

    public static String getRandomWord(){
        Random r=new Random();
        int randomNumber=r.nextInt(WORDS.length);
        return WORDS[randomNumber];
    }

    public static void addToArrayList(char ch,ArrayList<Character> guessList ){
        if(guessList.contains(ch)){
            System.out.println("You entered a forbidden word !!");

        }
        else{
            guessList.add(ch);
        }
    }

    public static String match(String word,ArrayList<Character> guesslist){
        String result="";

        for(int i=0;i<word.length();i++){
            Character trueChar=word.charAt(i);

            if(guesslist.contains(trueChar)) {
                result += trueChar;
            }
            else{
                result+="_";
            }
        }
        return result;

    }

    public static void printResult(boolean result,String word){
        System.out.println("┏┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┓");

        for(int i=0;i<4;i++){
            if(i==2){
                if(result){
                    System.out.println(centeredStr("YOU WIN!!"));

                    System.out.println(centeredStr(word));


                }
                else {
                    System.out.println(centeredStr("YOU LOST!!"));
                    System.out.println(centeredStr(word));

                }
            }
            System.out.println("│                │");

        }
        System.out.println("┗┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┛");
    }

    public static String centeredStr(String word){
        String finalStr;
        int length=18;
        int wordLength=word.length();
        int space=(length-wordLength-2)/2;
        String spaceRes="";
        for(int i=0;i<space;i++){
            spaceRes+=" ";
        }
        if(wordLength%2==0){
           finalStr="│"+ spaceRes  + word + spaceRes + "│";
        }
        else{
           finalStr="│"+ spaceRes  + word + spaceRes + " " + "│";
        }
        return finalStr;
    }

}
