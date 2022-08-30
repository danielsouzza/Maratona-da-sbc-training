import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaixasMuitoEspeciais {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            Box bestBox = null;
            List<Box> inventoryBox;
            int numberBox = input.nextInt(); // Number of boxes the customer wants to buy
            int numberInventory = input.nextInt(); // Number of boxes in the stock list

            if (numberBox == 0) {
                break;
            }

            inventoryBox = new ArrayList<>(numberInventory);

            Box clientBox = new Box(
                    input.nextInt(),
                    input.nextInt(),
                    input.nextInt());

            // Create and configure boxes
            for (int i = 0; i < numberInventory; i++) {
                int isEqual = -1;
                Box box = new Box(
                        input.nextInt(),
                        input.nextInt(),
                        input.nextInt());

                for (int k = 0; k < inventoryBox.size(); k++) {
                    if(inventoryBox.get(k).isEqual(box)){
                        isEqual = i;
                    }
                }

                if(isEqual < 0){
                    inventoryBox.add(box);
                }else{
                    inventoryBox.get(isEqual).oneMore();
                    
                } 
            }

            
            for(int i = 0; i < inventoryBox.size(); i++){
                Box current = inventoryBox.get(i);
                if(bestBox == null || (current.checkIfItFits(clientBox) && current.compareTo(clientBox) < bestBox.compareTo(clientBox)) ){
                    bestBox = current;
                }
            }

            if(bestBox == null || bestBox.numberOfBox < numberBox){
                System.out.println("impossible");
            }else{
                System.out.println(bestBox.compareTo(clientBox));
            }
        }
    }
}

// Box with all her elements
class Box implements Comparable<Box> {
    int numberOfBox = 0;
    int[] coordinates;

    public Box(int x, int y, int z) {
        coordinates = new int[3];
        List<Integer> temp = new ArrayList<Integer>(3);
        temp.add(x);
        temp.add(y);
        temp.add(z);
        temp.sort(null);
        coordinates[0] = temp.get(2);
        coordinates[1] = temp.get(1);
        coordinates[2] = temp.get(0);
        oneMore();
    }

    public int getVolume() {
        return coordinates[0] * coordinates[1] * coordinates[2];
    }

    public int getCoordinates(int index) {
        return this.coordinates[index];
    }

    @Override
    public int compareTo(Box box) {
        return this.getVolume() - box.getVolume();
    }

    public void oneMore() {
        this.numberOfBox++;
    }

    public Boolean isEqual(Box box) {
        return this.getCoordinates(0) == box.getCoordinates(0)
                && this.getCoordinates(1) == box.getCoordinates(1)
                && this.getCoordinates(2) == box.getCoordinates(2);
    }

    public Boolean checkIfItFits(Box box) {
        return this.getCoordinates(0) >= box.getCoordinates(0)
                && this.getCoordinates(1) >= box.getCoordinates(1)
                && this.getCoordinates(2) >= box.getCoordinates(2);
    }
}
