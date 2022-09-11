
import java.util.Scanner;

public class Volta {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int timeFist = input.nextInt();
        int timeSecunde = input.nextInt();
        boolean ishetardado = false;
        int round1 = 0;
        int round2 = 0;
        int p1 = 0;
        int p2 = 0;
        while(true){
            p1++;
            p2++;

            if(p1 == timeFist){
                // p1 = 0;
                if(round1 > round2){
                    ishetardado = true;
                }
                round1++;
            }

            if(p2 == timeSecunde){
                p2 = 0;
                round2++;
            }

            if(ishetardado){
                System.out.println(round1);
                break;
            }
        }
    }
}
