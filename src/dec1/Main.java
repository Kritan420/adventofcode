package dec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<>();

        Scanner s = new Scanner(new File("./src/dec1/input.txt"), "UTF-8");

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

        list.sort((a,b) -> b.compareTo(a));

        System.out.println("\nAmount of biggest: " + list.get(0)); 


        boba = list.get(0) + list.get(1) + list.get(2);

        System.out.println("\nSum of top 3: " + boba);
    }
}
