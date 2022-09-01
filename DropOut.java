import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DropOut {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            List<String> players = new ArrayList<>();
            List<Integer> cheap = new ArrayList<>();
            List<Integer> cardCurrent = new ArrayList<>();

            int numberOfPlayers = input.nextInt(); // Get number of players

            if(numberOfPlayers == 0) break;

            // Get playes
            for(int i = 0; i < numberOfPlayers; i++){
                players.add(input.next());
            }
            // Get cheap
            for(int i = 0; i < 52; i++){
                cheap.add(input.nextInt());
            }

            // Game
            boolean keep = true;
            while(keep){
                try{
                    boolean allIquals  = true;
                    int smallerCard = cheap.get(0);
                

                    for (int i = 0; i < players.size(); i++ ) {
                        if(cheap.get(0) < smallerCard){
                            smallerCard = cheap.get(0);
                        }
                        cardCurrent.add(cheap.get(0));
                        cheap.remove(0);

                        if(cardCurrent.get(i) != cardCurrent.get(0)){
                            allIquals = false;
                        }
                    }

                    for(int i = 0; i < players.size();i++){
                        if(cardCurrent.get(i) == smallerCard && !allIquals){
                            players.remove(players.get(i));
                        }
                    }

                    cardCurrent.clear();

                    if(players.size() == 1 || allIquals){
                        keep = false;
                    }
                }catch(IndexOutOfBoundsException ex){
                    keep = false;
                } 
            }

            for (String player : players) {
                System.out.print(player + " ");
            }
            System.out.println();
        }
    }
}

