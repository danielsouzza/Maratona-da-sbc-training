import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TecleSome {
    static Scanner input = new Scanner(System.in);
    static List<String> somas;
    public static void main(String[] args) {
        //List<Tecla> teclas = creatorLinks();
        somas = new ArrayList<>();


    }

    public static String SearchSum(List<Tecla> teclas, int soma ){
        String  sum = "";
        for (Tecla tecla : teclas) {
            if(soma == tecla.num){
                somas.add(Integer.toString(tecla.num));
                tecla.clicked = true;
            }else{
                sum = sum+tecla.num;
                tecla.clicked = true;
            }
        }
        return sum;
    }

    public static List<Tecla> creatorLinks() {
        List<Tecla> teclas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            teclas.add(new Tecla(i));
        }
        List<Tecla> temp = new ArrayList<>();
        // tecla 0
        temp.add(teclas.get(7));
        temp.add(teclas.get(8));
        temp.add(teclas.get(9));
        teclas.get(0).setLinks(temp);
        temp.clear();

        // tecla 1
        temp.add(teclas.get(2));
        temp.add(teclas.get(4));
        temp.add(teclas.get(5));
        teclas.get(1).setLinks(temp);
        temp.clear();

        // tecla 2
        temp.add(teclas.get(1));
        temp.add(teclas.get(3));
        temp.add(teclas.get(4));
        temp.add(teclas.get(5));
        temp.add(teclas.get(6));
        temp.add(teclas.get(7));
        teclas.get(2).setLinks(temp);
        temp.clear();

        // tecla 3
        temp.add(teclas.get(2));
        temp.add(teclas.get(5));
        temp.add(teclas.get(6));
        teclas.get(3).setLinks(temp);
        temp.clear();

        // tecla 4
        temp.add(teclas.get(1));
        temp.add(teclas.get(2));
        temp.add(teclas.get(5));
        temp.add(teclas.get(8));
        temp.add(teclas.get(7));
        teclas.get(4).setLinks(temp);
        temp.clear();

         // tecla 5
         temp.add(teclas.get(1));
         temp.add(teclas.get(2));
         temp.add(teclas.get(3));
         temp.add(teclas.get(4));
         temp.add(teclas.get(6));
         temp.add(teclas.get(7));
         temp.add(teclas.get(8));
         temp.add(teclas.get(9));
         teclas.get(5).setLinks(temp);
         temp.clear();

        // tecla 6
        temp.add(teclas.get(2));
        temp.add(teclas.get(3));
        temp.add(teclas.get(5));
        temp.add(teclas.get(8));
        temp.add(teclas.get(9));
        teclas.get(6).setLinks(temp);
        temp.clear();

        // tecla 7
        temp.add(teclas.get(4));
        temp.add(teclas.get(5));
        temp.add(teclas.get(8));
        temp.add(teclas.get(0));
        teclas.get(7).setLinks(temp);
        temp.clear();

        // tecla 8
        temp.add(teclas.get(4));
        temp.add(teclas.get(5));
        temp.add(teclas.get(6));
        temp.add(teclas.get(7));
        temp.add(teclas.get(9));
        temp.add(teclas.get(0));
        teclas.get(8).setLinks(temp);
        temp.clear();

        // tecla 9
        temp.add(teclas.get(6));
        temp.add(teclas.get(5));
        temp.add(teclas.get(8));
        temp.add(teclas.get(0));
        teclas.get(9).setLinks(temp);
        temp.clear();

        return teclas;
    }
}

class Tecla {
    int num;
    boolean clicked;
    List<Tecla> links;

    Tecla(int num) {
        this.num = num;
    }

    public void setLinks(List<Tecla> links) {
        this.links = new ArrayList<>(links);
    }

}