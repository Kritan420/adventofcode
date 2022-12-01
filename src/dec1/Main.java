package dec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<>();

        Scanner s = new Scanner(new File("./src/dec1/input.txt"), "UTF-8");

        s.useDelimiter("\n");

        int boba = 0;
        

        while (s.hasNextLine())  {
            String bob = s.nextLine();   
            
            if (!bob.trim().isEmpty()) {
                boba += Integer.parseInt(bob);
            }else {
                list.add(boba);
                boba = 0;
            }
          
        }

        int bigg = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (bigg < list.get(i)) {
                bigg = list.get(i);
                index = i;
            }
        }

        System.out.println("List size: " + list.size());
        System.out.println("Index of biggest: " + index);
        System.out.println("Amount of biggest: " + bigg);
    }
}
