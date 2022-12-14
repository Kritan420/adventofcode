package dec10;

import java.io.*;
import java.util.*;

public class cathederOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec10/input.txt"));
        String line = null;
        int cyc = 1;
        int x = 1;
        int save = 20;
        ArrayList<Integer> saved = new ArrayList<>();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (cyc == save) {
                saved.add(save*x);
                save += 40;   
            } 
            if (line.startsWith("noop")) {
                cyc++;
            }
            if (line.startsWith("addx")) {
                cyc++;
                if (cyc == save) {
                    saved.add(save*x);
                    save += 40;
                }
                cyc++;  
                x += Integer.parseInt(line.substring(5));
            }
        }
        int tot = 0;
        for (int c : saved) {
            tot += c;
        }
        System.out.println(saved.size());
        System.out.println(tot);
    }
}