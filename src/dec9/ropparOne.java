package dec9;

import java.io.*;
import java.util.*;

public class ropparOne {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec9/input.txt"));

        String line = null;
        String[] hMove = new String[2];
        ArrayList<String[]> hMoves = new ArrayList<>();
        Map<String, Integer> tVis = new LinkedHashMap<String, Integer>();
        int[] hPos = new int[2]; // x y
        ArrayList<int[]> tails = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            tails.add(new int[2]);
        }

        //tails.get(8)
        
        int[] tPos = new int[2]; // x y

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            hMove = line.split(" ");
            hMoves.add(hMove);
        }

        /**
        ..##..
        ...##.
        .####.
        ....#.
        s###..

        13
         */

        for (int i = 0; i < hMoves.size(); i++) {
            
            String direction = hMoves.get(i)[0];
            int steps = Integer.parseInt(hMoves.get(i)[1]);

            if (direction.equals("L") || direction.equals("U")) { // minska om L (x) eller U (y) som i row col

                for (int s = steps; s > 0; s--) {
                    
                    if (direction.equals("L")) {
                        hPos[0]--;
                        if (Math.absExact(hPos[0] - tPos[0]) > 1) {
                            if (Math.absExact(hPos[1] - tPos[1]) >= 1) {
                                tPos[1] = hPos[1];
                                tPos[0]--;
                            } else {
                                tPos[0]--;
                            }
                        }
                    }

                    if (direction.equals("U")) {
                        hPos[1]--;
                        if (Math.absExact(hPos[1] - tPos[1]) > 1) {
                            if (Math.absExact(hPos[0] - tPos[0]) >= 1) {
                                tPos[0] = hPos[0];
                                tPos[1]--;
                            } else {
                                tPos[1]--;
                            }
                        }
                    }

                    String xy = "x:" + tPos[0] + "|" + "y:" + tPos[1];
                    tVis.put(xy, i);


                }
            }

            if (direction.equals("R") || direction.equals("D")) { // öka om R (x) eller D (y) som i row col

                for (int s = 0; s < steps; s++) {

                    if (direction.equals("R")) {
                        hPos[0]++;

                        if (Math.absExact(hPos[0] - tPos[0]) > 1) {
                            if (Math.absExact(hPos[1] - tPos[1]) >= 1) {
                                tPos[1] = hPos[1];
                                tPos[0]++;
                            } else {
                                tPos[0]++;
                            }
                        }
                    }

                    if (direction.equals("D")) {
                        hPos[1]++;

                        if (Math.absExact(hPos[1] - tPos[1]) > 1) {

                            if (Math.absExact(hPos[0] - tPos[0]) >= 1) {
                                tPos[0] = hPos[0];
                                tPos[1]++;
                            } else {
                                tPos[1]++;
                            }

                        }
                    }
                    
                    String xy = "x:" + tPos[0] + "|" + "y:" + tPos[1];
                    tVis.put(xy, i);
                    
                }

            }
        }

        /**
        for (String key : tVis.keySet()) {
            System.out.println(tVis.get(key) + " " + key);
        } */

        System.out.println("\n " + "Visited:" + tVis.size() +"\n");

        // Startpos h [0, 0] t [0,0]
        // hMoves.size() = 2000 input1, 10 input2

    }// psvm }

} // pub class roppar }
