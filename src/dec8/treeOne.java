package dec8;

import java.io.*;
import java.util.*;

public class treeOne {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec8/input.txt"));

        String line = null;

        int[][] map = new int[99][99];

        int row = 0;
        int col = 0;

        int visibleCount = 0;

        while (sc.hasNext()) {
            line = sc.nextLine();
            for (col = 0; col < line.length(); col++) {
                map[row][col] = Character.getNumericValue(line.charAt(col));
            }
            row++;
        }

        Map<String, Integer> edge = new HashMap<String, Integer>();

        for (int i = 0; i < map.length; i++) {
            edge.put("r" + "0" + "c" + +i, map[0][i]);
            edge.put("r" + "98" + "c" + +i, map[98][i]);
            edge.put("r" + i + "c" + "0", map[i][0]);
            edge.put("r" + i + "c" + "98", map[i][98]);
        }

        visibleCount = edge.size();

        int L = map.length - 1;

        for (row = 1; row < L; row++) {
            for (col = 1; col < L; col++) {

                // visible true , sätt false om fail 
                boolean vis = true;
                boolean[] visB = new boolean[4]; //W E N S
                visB[0] = true;
                visB[1] = true;
                visB[2] = true;
                visB[3] = true;

                int t = map[row][col]; // int i rutan

                // edgekeys
                String eW = "r" + row + "c" + 0;
                String eE = "r" + row + "c" + 98;
                String eN = "r" + 0 + "c" + col;
                String eS = "r" + 98 + "c" + col;

                if (t <= edge.get(eW)) { // kolla vänster edge
                    visB[0] = false;
                } else {
                    for (int xW = 1; xW < col; xW++) { // kolla vänster om
                        if (t <= map[row][xW]) {
                            visB[0] = false;
                        }
                    }
                }

                if (t <= edge.get(eE)) { // kolla höger edge
                    visB[1] = false;
                } else {
                    for (int xE = col + 1; xE < L; xE++) { // kolla höger om
                        if (t <= map[row][xE]) {
                            visB[1] = false;
                        }
                    }
                }

                if (t <= edge.get(eN)) { // kolla upp edge
                    visB[2] = false;
                } else {
                    for (int yN = 1; yN < row; yN++) { // kolla upp
                        if (t <= map[yN][col]) {
                            visB[2] = false;
                        }
                    }
                }

                if (t <= edge.get(eS)) { // kolla ner edge
                    visB[3] = false;
                } else {
                    for (int yS = row + 1; yS < L; yS++) { // kolla ner
                        if (t <= map[yS][col]) {
                            visB[3] = false;
                        }
                    }
                }

                if (!visB[0] && !visB[1] && !visB[2] && !visB[3]) { // if still visible in any W E N S
                    vis = false;
                } else if (vis) {
                    // System.out.println("r"+(row)+"c"+(col) + "("+map[row][col]+")" + " är " + vis
                    // +" |" + " W:"+visB[0] + " E:"+visB[1] + " N:"+visB[2] + " S:"+visB[3]);
                    visibleCount++;
                }
            }
        }
        System.out.println("\nvisibleCount = " + visibleCount + "\n");

    }

}