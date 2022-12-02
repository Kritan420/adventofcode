package dec2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class rockpeepee {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("./src/dec2/input.txt"), "UTF-8");

        Map<Character, Integer> points = new TreeMap<Character, Integer>();
        points.put('R', 1);
        points.put('P', 2);
        points.put('S', 3);

        Map<Character, Character> beats = new TreeMap<Character, Character>();
        beats.put('R', 'S');
        beats.put('P', 'R');
        beats.put('S', 'P');

        int sum = 0;
        String line;
        
        try {
            while (!(line = s.nextLine()).isEmpty()) {
                 char oppo = line.charAt(0) == 'A' ? 'R' : line.charAt(0) == 'B' ? 'P' : line.charAt(0) == 'C' ? 'S' : 0;
                 char you = line.charAt(2);

                 // Part one
                 //you = you == 'X' ? 'R' : you == 'Y' ? 'P' : you == 'Z' ? 'S' : 0;
     
                 // Part two
                 you = you == 'X' ? beats.get(oppo) : you == 'Y' ? oppo : you == 'Z' ? oppo == 'R' ? 'P' : oppo == 'P' ? 'S' : oppo == 'S' ? 'R' : 0 : 0;
    
                 sum += beats.get(you) == oppo ? points.get(you) + 6 : you == oppo ? points.get(you) + 3 : points.get(you);
             }
        } catch (NoSuchElementException e) {
            System.out.println("Sum of points: " + sum);
        }
    }
}