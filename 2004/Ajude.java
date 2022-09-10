import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ajude {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            int timeTotal = 0;
            int numberOfQuestions = input.nextInt();
            List<Questoes> questõesCorrect = new ArrayList<Questoes>();
            List<Questoes> questõesIncorrect = new ArrayList<Questoes>();
            
            if(numberOfQuestions == 0) break;

            for(int i = 0; i < numberOfQuestions; i++){
                Questoes newQuestion = new Questoes(
                    input.next(),
                    input.nextInt(),
                    input.next()
                    
                    );

                if(newQuestion.jugde){
                    questõesCorrect.add(newQuestion);
                }else{
                    questõesIncorrect.add(newQuestion);
                }
            }

            for(int c = 0; c < questõesCorrect.size();c++){
                for(int i = 0; i < questõesIncorrect.size();i++){
                    if(questõesCorrect.get(c).identifier.equals(questõesIncorrect.get(i).identifier)){
                        questõesCorrect.get(c).jugdeIncorrect();
                    } 
                }
                timeTotal += questõesCorrect.get(c).getTime();
            }


            System.out.println(questõesCorrect.size() + " " + timeTotal);

        }
    }
}

class Questoes{
    String identifier;
    Boolean jugde;
    int time;

    Questoes(String identifier, int time, String jugde){
        this.identifier = identifier;
        this.jugde = jugde.equals("correct") ? true : false;
        this.time = time; 
    }

    public void jugdeIncorrect(){
        this.time +=20;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean getJugde() {
        return this.jugde;
    }


    public int getTime() {
        return time;
    }
} 
