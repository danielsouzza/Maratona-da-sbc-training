import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DropOut {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while(true){
            List<String> players = new ArrayList<>();
            List<Integer> cheap = new ArrayList<>();
            

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
            while(true){
                    List<String> perdedor = new ArrayList<>();
                    int smallerCard = cheap.get(0);
                    boolean cheapFinished = false;
                
                    for (int i = 0; i < players.size(); i++ ) {
                        if(cheap.get(0)  <= smallerCard){
                            if(cheap.get(0) == smallerCard){
                                perdedor.add(players.get(i));
                            }else{
                                perdedor.clear();
                                smallerCard = cheap.get(0);
                                perdedor.add(players.get(i));
                            } 
                        }
                        cheap.remove(0);
                        if(cheap.isEmpty() && i < players.size()) {
                            cheapFinished = true;
                            break;
                        }
                    }

                    if(perdedor.size() == players.size() || cheapFinished) {
                        break;
                    }

                    for (String name : perdedor) {
                        players.remove(name);
                    }
                       
                    if(players.size() == 1){
                        break;
                    }
                    perdedor.clear();
            }

            for (String name : players) {
                System.out.print(name + " ");
            }

            System.out.println();
        }
    }
}

