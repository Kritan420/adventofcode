package dec3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class rucketPartTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("./src/dec3/input.txt"), "UTF-8");

        String[] sack;

        ArrayList<String[]> list = new ArrayList<>();
        Map<Integer, Character> duplos = new HashMap<>();
        Map<Character, Integer> prio = new HashMap<>();

        for (int i = 1; i < 27 ; i++ ) {
            prio.put(Character.valueOf((char) (i+96)), i);
            prio.put(Character.valueOf((char) (i+64)), i+26);
        }

        while (list.size() < 100) {
            sack = new String[3];

            sack[0] = s.nextLine();
            sack[1] = s.nextLine();
            sack[2] = s.nextLine();

            list.add(sack);
        }


        int index = 0;
        for (String[] g : list) {
           
            for (int i = 0; i < g[0].length(); i++) {
                String dupp = g[0].substring(i, i+1);

                if (g[1].contains(dupp) && g[2].contains(dupp)) {
                    duplos.put(index, dupp.charAt(0));
                }
            }
            index++;
        }

        int sum = 0;
     
        for (Integer key : duplos.keySet()) {
            System.out.println("Key: " + key + " Value: " + duplos.get(key));
            sum += prio.get(duplos.get(key));
        }

        System.out.println("Sum: " + sum);

    }

}
