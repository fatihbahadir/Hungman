import java.util.ArrayList;

public class Game {

    public int flag=0;
    Hungman hungman=new Hungman();
    public  String word=this.hungman.getRandomWord();
    public int maxTry=7;
    public ArrayList<Character> guessList=new ArrayList<>();
    public ArrayList<Character> forbiddenList=new ArrayList<>();

    public void initializeGame(){
        while(this.maxTry>0){
            this.addChar();
            this.printInfo();
            this.checkResult();
            System.out.println("╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍");
            System.out.println("                               ");
            if(flag==-1){
                break;
            }

            this.maxTry--;
        }
    }

    public void addChar(){this.hungman.addToArrayList(this.hungman.getChar(),guessList);
    }
    public void printInfo(){
        System.out.println("Entered List : "+this.guessList);
        System.out.println("You have "+(this.maxTry-1)+" left");
        System.out.println("Word : " + this.hungman.match(this.word,this.guessList));
        System.out.println("                               ");
    }
    public void checkResult(){
        if(this.hungman.match(this.word,this.guessList).equals(this.word)){
            this.hungman.printResult(true,this.word);
            System.out.println("╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍");
            this.flag=-1;
        }
        else if(this.maxTry==1){
            this.hungman.printResult(false,this.word);
            System.out.println("╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍");
            this.flag=-1;
        }
    }
}
