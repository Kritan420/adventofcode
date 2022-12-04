package dec4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class One {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("./src/dec4/input.txt"), "UTF-8");
        s.useDelimiter(",");

        String sect = null;
        String[] range = null;

        int count = 0;

        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<Integer> check2 = new ArrayList<>();

        
    try {
        while (s.hasNext() ) {
            sect = s.next();    
            range = sect.split("-");
            for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++ ) {
                check.add(i);
            }
            sect = s.next();    
            range = sect.split("-");
            for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++ ) {
                check2.add(i);
            }
            if (check.containsAll(check2) || check2.containsAll(check)) {
                count++;
            }

            check.clear();
            check2.clear();
        }
    } catch (NoSuchElementException e) {
        System.out.println(count);
    }


            
}

}
