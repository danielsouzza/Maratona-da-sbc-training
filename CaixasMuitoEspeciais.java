import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

By: Daniel L.Souza
Challenge: 1290 - Caixas Muito Especiais - 2004
*/

public class CaixasMuitoEspeciais {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keep = true;
        while (keep) {

            try {
                Box suitableBox = null;
                List<Box> inventoryBox;
                int numberBox = getInt(); // Number of boxes the customer wants to buy
                int numberInventory = getInt(); // Number of boxes in the stock list

                inventoryBox = new ArrayList<>(numberInventory);

                Box clientBox = createbox(); // Customer's desired box

                // Create and configure boxes
                for (int i = 0; i < numberInventory; i++) {
                    Boolean isEqual = false;
                    Box box = createbox();

                    // Save the index of the box with the same dimensions
                    for (int k = 0; k < inventoryBox.size(); k++) {
                        if (inventoryBox.get(k).isEqual(box)) {
                            inventoryBox.get(k).oneMore();
                            isEqual = true;
                            break;
                        }
                    }

                    // Do not repeat the same box
                    if (!isEqual) {
                        inventoryBox.add(box);
                    }
                }

                // Box that fits the items as tightly as possible
                for (int i = 0; i < inventoryBox.size(); i++) {
                    Box temp = inventoryBox.get(i);
                    if (temp.checkIfItFits(clientBox)
                            && temp.numberOfBox >= numberBox
                            && (suitableBox == null
                            || (temp.volumeDifference(clientBox) < suitableBox.volumeDifference(clientBox)))) {
                        suitableBox = temp;
                    }

                }

                // Result
                if (suitableBox == null) {
                    System.out.println("impossible");
                } else {
                    System.out.println(suitableBox.volumeDifference(clientBox));
                }
            } catch (IllegalArgumentException ex) {
                keep = false;
            }
        }
    }

    private static Box createbox() throws IllegalArgumentException {
        return new Box(
                getInt(),
                getInt(),
                getInt());
    }

    private static int getInt() {
        int num = input.nextInt();
        if (num > 0 && num <= 50 || num > 0)
            return num;
        else if (num > 1 && num <= 1500)
            return num;
        else {
            throw new IllegalArgumentException();
        }
    }
}

// Box with all her elements
class Box {
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

    public int volumeDifference(Box box) {
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
