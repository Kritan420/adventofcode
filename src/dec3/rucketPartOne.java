package dec3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class rucketPartOne {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("./src/dec3/input.txt"), "UTF-8");

        String ruck = null;
        int mid = 0;
        String[] sack;

        ArrayList<String[]> list = new ArrayList<>();
        Map<Integer, Character> duplos = new HashMap<>();

        Map<Character, Integer> prio = new HashMap<>();
        for (int i = 1; i < 27 ; i++ ) {
            prio.put(Character.valueOf((char) (i+96)), i);
            prio.put(Character.valueOf((char) (i+64)), i+26);
        }

        try {
            while ((ruck = s.nextLine()) != null) {
                
                sack = new String[2];
                mid = ruck.length()/2;
                sack[0] = ruck.substring(0, mid);
                sack[1] = ruck.substring(mid, ruck.length());
                list.add(sack);
            }
        } catch (NoSuchElementException e) {


        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i)[0].length(); j++) {
                for (int k = 0; k < list.get(i)[1].length(); k++) {
              
                    if (list.get(i)[0].charAt(j) == list.get(i)[1].charAt(k)) {
                        duplos.put(i, list.get(i)[0].charAt(j));
                    }
                
                }
            }
        }
        
        int sum = 0;
     
        for (Integer key : duplos.keySet()) {
            sum += prio.get(duplos.get(key));
        }

        System.out.println("Sum: " + sum);

    }

}
