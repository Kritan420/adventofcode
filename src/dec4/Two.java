package dec4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Two {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("./src/dec4/input.txt"), "UTF-8");

        String line;
        String[] sect;
        String[] first;
        String[] last;
        int count = 0;
        
        try {
            while ((line=s.nextLine()) != null) {
                sect = line.split(",");
                first = sect[0].split("-");
                last = sect[1].split("-");

                if (Integer.parseInt(last[0]) <= Integer.parseInt(first[1]) && Integer.parseInt(last[0]) >= Integer.parseInt(first[0]) ||
                Integer.parseInt(first[0]) <= Integer.parseInt(last[1]) && Integer.parseInt(first[0]) >= Integer.parseInt(last[0])) {
                    count++;
                }

            }
        } catch (NoSuchElementException e) {
            System.out.println(count);
        }       
    }

}   
