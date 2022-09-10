import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handebol {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int n = input.nextInt();
        int m = input.nextInt();
        int numgberOfPlayer = 0;
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = input.nextInt();
                if(num > 0){
                    count++;
                }
            }

            if(count == m){
                numgberOfPlayer ++;
            }
            count = 0;   
        }
        System.out.println(numgberOfPlayer);
    }
}
