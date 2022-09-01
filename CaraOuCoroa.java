import java.util.Scanner;

public class CaraOuCoroa {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            int mary = 0;
            int john = 0;
            int coin ;
            
            int matches = input.nextInt();
            if(matches == 0){
                break;
            }

            for(int i = 0; i < matches;i++){
                coin = input.nextInt();
                if(coin == 0){
                    mary++;
                }else{
                    john++;;
                }
            }

            String result =
                String.format("Mary won %d times and John won %d times", mary,john);

            System.out.println(result);
        }
    }
}

