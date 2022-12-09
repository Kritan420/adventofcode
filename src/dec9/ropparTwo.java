package dec9;

import java.io.*;
import java.util.*;

public class ropparTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec9/input2.txt"));

        String line = null;
        String[] hMove = new String[2];
        ArrayList<String[]> hMoves = new ArrayList<>();
        Map<String, Integer> tVis = new LinkedHashMap<String, Integer>();

        ArrayList<int[]> rope = new ArrayList<>();

        // rope.get(0) == hPos
        // rope.get(9) == tPos
    
        
        for (int i = 0; i < 10; i++) {
            rope.add(new int[2]);
        }

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            hMove = line.split(" ");
            hMoves.add(hMove);
        }

        for (int i = 0; i < hMoves.size(); i++) {

            int[] hPos = new int[2]; // x y
            int[] tPos = new int[2]; // x y

            String direction = hMoves.get(i)[0];
            int steps = Integer.parseInt(hMoves.get(i)[1]);

            if (direction.equals("L") || direction.equals("U")) { // minska om L (x) eller U (y) som i row col

                for (int s = steps; s > 0; s--) {

                    if (direction.equals("L")) {

                        rope.get(0)[0]--;

                        for (int r = 0; r < rope.size() - 1; r++) {

                            hPos = rope.get(r); // x y
                            tPos = rope.get(r+1); // x y

                            if (Math.absExact(hPos[0] - tPos[0]) > 1) {
                                if (Math.absExact(hPos[1] - tPos[1]) >= 1) {
                                    tPos[1] = hPos[1];
                                    tPos[0]--;
                                } else {
                                    tPos[0]--;
                                }
                            }
                        }

                    }

                    if (direction.equals("U")) {

                        rope.get(0)[1]--;

                        for (int r = 0; r < rope.size() - 1; r++) {

                            hPos = rope.get(r); // x y
                            tPos = rope.get(r+1); // x y

                        if (Math.absExact(hPos[1] - tPos[1]) > 1) {
                            if (Math.absExact(hPos[0] - tPos[0]) >= 1) {
                                tPos[0] = hPos[0];
                                tPos[1]--;
                            } else {
                                tPos[1]--;
                            }
                        }
                        tPos = rope.get(9);
                        String xy = "x:" + tPos[0] + "|" + "y:" + tPos[1];
                        tVis.put(xy, i);
                        }

                    }

                }

            }

            if (direction.equals("R") || direction.equals("D")) { // öka om R (x) eller D (y) som i row col

                for (int s = 0; s < steps; s++) {

                    if (direction.equals("R")) {

                        rope.get(0)[0]++;

                        for (int r = 0; r < rope.size() - 1; r++) {

                            hPos = rope.get(r); // x y
                            tPos = rope.get(r+1); // x y

                         if (Math.absExact(hPos[0] - tPos[0]) > 1) {
                            if (Math.absExact(hPos[1] - tPos[1]) >= 1) {
                                tPos[1] = hPos[1];
                                tPos[0]++;
                            } else {
                                tPos[0]++;
                            }
                        }
                        tPos = rope.get(9);
                        String xy = "x:" + tPos[0] + "|" + "y:" + tPos[1];
                        tVis.put(xy, i);
                        }

                    }

                    if (direction.equals("D")) {

                        rope.get(0)[1]++;

                        for (int r = 1; r < rope.size() - 1; r++) {
                            hPos = rope.get(r); // x y
                            tPos = rope.get(r+1); // x y
                            if (Math.absExact(hPos[1] - tPos[1]) > 1) {

                                if (Math.absExact(hPos[0] - tPos[0]) >= 1) {
                                    tPos[0] = hPos[0];
                                    tPos[1]++;
                                } else {
                                    tPos[1]++;
                                }
    
                            }
                        }
                    }

                }


            }

        }

        for (String key : tVis.keySet()) {
            System.out.println(tVis.get(key) + " " + key);
        }

        System.out.println("\n " + "Visited:" + tVis.size() + "\n");
    }

}
