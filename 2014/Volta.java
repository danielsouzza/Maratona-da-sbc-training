
import java.util.Scanner;

public class Volta {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int timeFist = input.nextInt();
        int timeSecunde = input.nextInt();
        int time = 0;
        int round = 0;
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(true){
            round++;
            time += timeFist;
            p1++;
            if(time >= timeFist*round){
                p2++;
                count = 0;
            }else{
                count++;
            }

            if(count >= 2){
                System.out.println(round);
                break;
            }
        }
    }
}

5  1 0
10 2 1
15 3 2
20 4 2