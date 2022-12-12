package dec9;

import java.io.*;
import java.util.*;

public class ropparTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec9/input2.txt"));

        String line = null;
        String[] hMove = new String[2];
        ArrayList<String[]> hMoves = new ArrayList<>();
        int[][] knots = new int[10][2];
        Map<String, Integer> tVis = new LinkedHashMap<>();

        // int[] tail = new int[2];

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            hMove = line.split(" ");
            hMoves.add(hMove);
        }

        for (int i = 0; i < hMoves.size(); i++) {
            String direction = hMoves.get(i)[0];
            int steps = Integer.parseInt(hMoves.get(i)[1]);

            for (int s = 0; s < steps; s++) {
                if (direction.equals("L")) {
                    knots[0][0]--;
                }
                if (direction.equals("R")) {
                    knots[0][0]++;
                }
                if (direction.equals("U")) {
                    knots[0][1]--;
                }
                if (direction.equals("D")) {
                    knots[0][1]++;
                }

                for (int k = 1; k < knots.length; k++) {

                    int dx = Math.abs(knots[k][0] - knots[k - 1][0]);
                    int dy = Math.abs(knots[k][1] - knots[k - 1][1]);
                    int distance = (int) Math.sqrt(dy * dy + dx * dx);

                    if (direction.equals("L")) {
                        if (distance > 1) {
                            if (knots[k][1] != knots[k - 1][1]) {
                                if (knots[k - 1][1] > knots[k][1]) {
                                    knots[k][1] += 1;
                                } else {
                                    knots[k][1] -= 1;
                                }
                                if (knots[k][0] != knots[k - 1][0]) {
                                    if (knots[k - 1][0] > knots[k][0]) {
                                        knots[k][0] += 1;
                                    } else {
                                        knots[k][0] -= 1;
                                    }
                                }
                            } else {
                                knots[k][0] -= 1;
                            }
                        }
                        if (k == 9) {
                            tVis.put("x" + knots[k][0] +"|"+"y"+ knots[k][1], i);
                        }

                    }

                    if (direction.equals("R")) {
                        if (distance > 1) {
                            if (knots[k][1] != knots[k - 1][1]) {
                                if (knots[k - 1][1] > knots[k][1]) {
                                    knots[k][1] += 1;
                                } else {
                                    knots[k][1] -= 1;
                                }
                                if (knots[k][0] != knots[k - 1][0]) {
                                    if (knots[k - 1][0] > knots[k][0]) {
                                        knots[k][0] += 1;
                                    } else {
                                        knots[k][0] -= 1;
                                    }
                                }
                            } else {
                                knots[k][0] += 1;
                            }
                        }
                        if (k == 9) {
                            tVis.put("x" + knots[k][0] +"|"+"y"+ knots[k][1], i);
                        }

                    }


                    if (direction.equals("U")) {

                        if (distance > 1) {
                            if (knots[k][0] != knots[k - 1][0]) {
                                if (knots[k - 1][0] > knots[k][0]) {
                                    knots[k][0] += 1;
                                } else {
                                    knots[k][0] -= 1;
                                }
                                if (knots[k][1] != knots[k - 1][1]) {
                                    if (knots[k - 1][1] > knots[k][1]) {
                                        knots[k][0] += 1;
                                    } else {
                                        knots[k][0] -= 1;
                                    }
                                }
                            } else {
                                knots[k][1] -= 1;
                            }
                        }
                        if (k == 9) {
                            tVis.put("x" + knots[k][0] +"|"+"y"+ knots[k][1], i);
                        }

                    }
                    if (direction.equals("D")) {
                        
                        if (distance > 1) {
                            if (knots[k][0] != knots[k - 1][0]) {
                                if (knots[k - 1][0] > knots[k][0]) {
                                    knots[k][0] += 1;
                                } else {
                                    knots[k][0] -= 1;
                                }
                                if (knots[k][1] != knots[k - 1][1]) {
                                    if (knots[k - 1][1] > knots[k][1]) {
                                        knots[k][0] += 1;
                                    } else {
                                        knots[k][0] -= 1;
                                    }
                                }
                            } else {
                                knots[k][1] += 1;
                            }
                        }
                        if (k == 9) {
                            tVis.put("x" + knots[k][0] +"|"+"y"+ knots[k][1], i);
                        }


                    }

                }

            } // steps

        }
        System.out.println(tVis.size());
    } // all moves

}

/**
 * for(String key : tVis.keySet()) {
 * System.out.println(tVis.get(key) + " " + key);
 * }
 */
