package dec8;

import java.io.*;
import java.util.*;

public class treeTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec8/input.txt"));

        String line = null;

        int[][] map = new int[99][99];

        int row = 0;
        int col = 0;

        while (sc.hasNext()) {
            line = sc.nextLine();
            for (col = 0; col < line.length(); col++) {
                map[row][col] = Character.getNumericValue(line.charAt(col));
            }
            row++;
        }

        Map<String, Integer[]> scores = new HashMap<>();
        Map<String, Integer> sm = new HashMap<>();

        for (row = 1; row < map.length; row++) {
            for (col = 1; col < map.length; col++) {

                Integer[] scene = new Integer[4]; // W E N S
                scene[0] = 0;
                scene[1] = 0;
                scene[2] = 0;
                scene[3] = 0;

                String pos = "r" + row + "c" + col;
                int scenicScore = 0;

                int t = map[row][col]; // int i rutan

                if (col == 1) { // kolla vänster edge
                    scene[0] = 1;
                } else {
                    for (int xW = col - 1; xW >= 0; xW--) { // kolla vänster om
                        if (t > map[row][xW]) {
                            scene[0]++;
                        } else {
                            scene[0]++;
                            xW = -1;
                        }
                    }
                }

                if (col == 97) { // kolla höger edge
                    scene[1] = 1;
                } else {
                    for (int xE = col + 1; xE < map.length; xE++) { // kolla höger om
                        if (t > map[row][xE]) {
                            scene[1]++;
                        } else {
                            scene[1]++;
                            xE = 100;
                        }
                    }
                }

                if (row == 1) { // kolla upp edge
                    scene[2] = 1;
                } else {
                    for (int yN = row - 1; yN >= 0; yN--) { // kolla upp
                        if (t > map[yN][col]) {
                            scene[2]++;
                        } else {
                            scene[2]++;
                            yN = -1;
                        }
                    }
                }

                if (row == 97) { // kolla ner edge
                    scene[3] = 1;
                } else {
                    for (int yS = row + 1; yS < map.length; yS++) { // kolla ner
                        if (t > map[yS][col]) {
                            scene[3]++;
                        } else {
                            scene[3]++;
                            yS = 100;
                        }
                    }
                }
                scenicScore = (scene[0] * scene[1] * scene[2] * scene[3]);

                scores.put(pos, scene);
                sm.put(pos, scenicScore);
            }
        }
        
        int mostScenic = Integer.MIN_VALUE;
        String scenicPos = "";
        for (String key : sm.keySet()) {
            if (sm.get(key) > mostScenic) {
                mostScenic = sm.get(key);
                scenicPos = key;
            }
        }
        System.out.println("\nPos: " + scenicPos + "\n" + "Score = " + mostScenic + "\n" + "W = "
                + scores.get(scenicPos)[0] + " E = " + scores.get(scenicPos)[1] + " N = " + scores.get(scenicPos)[2] + " S = "
                + scores.get(scenicPos)[3]);

                Integer[] highest = new Integer[4];
                String kh0 = "";
                String kh1 = "";
                String kh2 = "";
                String kh3 = "";
                highest[0] = 0;
                highest[1] = 0;
                highest[2] = 0;
                highest[3] = 0;

                for (String key : scores.keySet()) {
                    if (scores.get(key)[0] > highest[0]) {
                        kh0 = key;
                        highest[0] = scores.get(key)[0];
                    }
                    if (scores.get(key)[1] > highest[1]) {
                        kh1 = key;
                        highest[1] = scores.get(key)[1];
                    }
                    if (scores.get(key)[2] > highest[2]) {
                        kh2 = key;
                        highest[2] = scores.get(key)[2];
                    }
                    if (scores.get(key)[3] > highest[3]) {
                        kh3 = key;
                        highest[3] = scores.get(key)[3];
                    }
                }

                System.out.println(
                "\nBest W: " + kh0 + " = " + highest[0] + 
                "\nBest E: " + kh1 + " = " + highest[1] + 
                "\nBest N: " + kh2 + " = " + highest[2] +
                "\nBest S: " +kh3 + " = " + highest[3] + "\n");


    }

}