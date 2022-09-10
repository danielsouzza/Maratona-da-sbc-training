import java.util.Scanner;

/**
 * JogodoBicho
 */
public class JogodoBicho {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            Double value = input.nextDouble();
            int bid = input.nextInt();
            int drawnNumber = input.nextInt();

            if(value == 0 && bid ==0  && drawnNumber == 0) break;

            String strBid = complet(Integer.toString(bid));
            String strDrawn = complet(Integer.toString(drawnNumber));
            int sB = strBid.length();
            int sD = strDrawn.length();

            if(strBid.substring(sB-4,sB).equals(strDrawn.substring(sD-4,sD))){
                value *= 3000;
            }else if(strBid.substring(sB-3,sB).equals(strDrawn.substring(sD-3,sD))){
                value *= 500;
            }else if(strBid.substring(sB-2,sB).equals(strDrawn.substring(sD-2,sD))){
                value *= 50;
            }else if(animalGruop(strBid.substring(sB-2,sB), strDrawn.substring(sD-2,sD))){
                value *= 16;
            }else{
                value = 0.0;
            }

            System.out.println(String.format("%.2f", value));
        }
    }

    public static String complet(String str){
        while(str.length() < 4){
            str = "0" + str;
        }
        return str;
    }

    public static Boolean animalGruop(String str1, String str2){

        int bid = Integer.parseInt(str1);
        int drawn = Integer.parseInt(str2);
        int count = 1;

        boolean booBid = false;
        boolean booDrawn = false;

        for(int i = 1; i <= 100; i++, count++){
            int aux = i;
            
            if(i==100){
                aux = 0;
            }
            
            if(bid == aux ){
                booBid = true;
            }
            if(drawn == aux){
                booDrawn = true;
            }
            
            if(booBid && booDrawn && count <= 4){
                return true;
            }
            
            if(count == 4){
                count = 0;
                booDrawn=false;
                booBid =false;
            }
        }
        return false;
    }
}