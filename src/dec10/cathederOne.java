package dec10;

import java.io.*;
import java.util.*;

public class cathederOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec10/input2.txt"));
        String line = null;
        int cyc = 1;
        int currC = 0;
        int x = 1;
        int save = 20;
        ArrayList<Integer> saved = new ArrayList<>();

        while (sc.hasNextLine()) {

            line = sc.nextLine();

            if (currC >= save) {
                save += 40;
                saved.add(cyc*x);
            }  


            if (line.startsWith("noop")) {
                cyc++;
            }
            if (line.startsWith("addx")) {
                x += Integer.parseInt(line.substring(5));
                cyc += 2;
            }



            currC = cyc;            
        }



        int tot = 0;
        for (int c : saved) {
            tot += c;
        }
        System.out.println(saved.get(4));
        System.out.println(tot);
    }
}