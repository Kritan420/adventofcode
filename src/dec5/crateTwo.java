package dec5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class crateTwo {

    

public static void main(String[] args) throws FileNotFoundException {

    Scanner s = new Scanner(new File("./src/dec5/input.txt"), "UTF-8");

    ArrayList<LinkedList<Character>> stacks = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        stacks.add(new LinkedList<>());
    }

    int row = 0;
    String line = null;

    while (row != 8)  {
        line = s.nextLine();
        int index = 0;
        for (int i = 1; i < 34; i += 4) {
            if ((int)line.charAt(i) <= 90 && (int)line.charAt(i) >= 65) {
                stacks.get(index).addLast(line.charAt(i));
            }  
            index++;
        }
        row++;
    }

    s.nextLine();
    s.nextLine();


    String[] mission = new String[3];

    while (s.hasNextLine()) {
        line = s.nextLine();

        line = line.replaceAll("[^0-9]", " ");
        line = line.trim();
        line = line.replaceAll(" +", ",");

        mission = line.split(",");

        int amount = Integer.parseInt(mission[0]);
        int from = Integer.parseInt(mission[1]);
        int to = Integer.parseInt(mission[2]);

        if (amount > stacks.get(from-1).size()) {
            amount = stacks.get(from-1).size();
        } 

        if (amount == 1) {
            for (int i = 0; i < amount; i++) {
                char temp = stacks.get(from-1).poll();
                stacks.get(to-1).addFirst(temp);
            }
        } else if (amount > 1) {

            ArrayList<Character> inOrder = new ArrayList<>();

            for (int i = 0; i < amount; i++) {
                inOrder.add(stacks.get(from-1).poll());
            }

            for (int i = amount-1; i >= 0; i--) {
                stacks.get(to-1).addFirst(inOrder.get(i));
            }

        }



    }

    for (int i = 0; i < stacks.size(); i++) {
        System.out.print(stacks.get(i).getFirst());
    }

}


}