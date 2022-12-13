package dec10;

import java.io.*;
import java.util.*;

public class cathederOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec10/input2.txt"));

        String line = null;
        int cyc = 1;
        int x = 1;
        int save = 20;
        ArrayList<Integer> saved = new ArrayList<>();

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.startsWith("noop")) {
                cyc += 1;
                if (cyc >= save) {
                    save += 40;
                    saved.add(x*(cyc-1));
                }
            } else if (line.startsWith("addx")) {
                cyc += 2;
                
                if (cyc >= save) {
                    save += 40;
                    saved.add(x*(cyc-2));
                }
                x += Integer.parseInt(line.substring(5));
            }
            System.out.println(cyc + " " + x );
        }
        int tot = 0;
        for (int c : saved) {
            tot += c;
        }
        System.out.println(saved.get(0));
        System.out.println(tot);
    }
}