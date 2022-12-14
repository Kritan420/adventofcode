package dec10;

import java.io.*;
import java.util.*;

public class cathederTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec10/input.txt"));
        String line = null;

        int x = 1;
        int pixC = 0;
        int pixR = 0;

        char[][] pixels = new char[6][40];

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (pixC > 39) {
                pixR++;
                pixC = 0;
            }
            if (pixC >= x - 1 && pixC <= x + 1) {
                pixels[pixR][pixC] = '#';
                pixC++;
            } else {
                pixels[pixR][pixC] = '.';
                pixC++;
            }
            if (line.startsWith("addx")) {
                if (pixC > 39) {
                    pixR++;
                    pixC = 0;
                }
                if (pixC >= x - 1 && pixC <= x + 1) {
                    pixels[pixR][pixC] = '#';
                    pixC++;
                } else {
                    pixels[pixR][pixC] = '.';
                    pixC++;
                }
                x += Integer.parseInt(line.substring(5));
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 40; j++) {
                System.out.print(pixels[i][j] + " ");
            }
        }
    }
}