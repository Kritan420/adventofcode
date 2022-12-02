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
                 char opponent =  line.charAt(0);
                 char you = line.charAt(2);
                 opponent = opponent == 'A' ? 'R' : opponent == 'B' ? 'P' : opponent == 'C' ? 'S' : 0;

                 // Part one
                 //you = you == 'X' ? 'R' : you == 'Y' ? 'P' : you == 'Z' ? 'S' : 0;
     
                 // Part two
                 you = you == 'X' ? beats.get(opponent) : you == 'Y' ? opponent : you == 'Z' ? opponent == 'R' ? 'P' : opponent == 'P' ? 'S' : opponent == 'S' ? 'R' : 0 : 0;
                 
                 sum += points.get(you);
                 sum += beats.get(you) == opponent ? 6 : you == opponent ? 3 : 0;
             }
        } catch (NoSuchElementException e) {
            System.out.println("Sum of points: " + sum);
        }
    }
}