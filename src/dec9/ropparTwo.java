package dec9;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class ropparTwo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec9/input.txt"));

        String line = null;
        String[] hMove = new String[2];
        ArrayList<String[]> hMoves = new ArrayList<>();
        Map<String, Integer> tVis = new LinkedHashMap<>();

        ArrayList<Point> ps = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ps.add(new Point());
            ps.get(i).setLocation(0, 0);
        }

        System.out.println(ps.get(0));

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
                    ps.get(0).x--;
                }
                if (direction.equals("R")) {
                    ps.get(0).x++;
                }
                if (direction.equals("U")) {
                    ps.get(0).y--;
                }
                if (direction.equals("D")) {
                    ps.get(0).y++;
                }

                for (int k = 1; k < ps.size(); k++) {

                    double distance = ps.get(k - 1).distance(ps.get(k));

                    if (distance > 1.42) {
                        moveT(ps.get(k - 1), ps.get(k));
                    }
                    if (k == 9) {
                        tVis.put("x" + ps.get(9).getX() +"|"+"y"+ ps.get(9).getY() , i);
                    }
                }

            }

        } // steps

        for (String key : tVis.keySet()) {
            System.out.println(tVis.get(key) + " " + key);
        }

        System.out.println(tVis.size());
    } // all moves

    public static void moveT(Point h, Point t) {

        if ((h.x == t.x) || (h.y == t.y)) {
            if (h.x < t.x) {
                t.x--;
            } else if (h.x > t.x) {
                t.x++;
            } else if (h.y < t.y) {
                t.y--;
            } else if (h.y > t.y) {
                t.y++;
            }
        } else {
            if (h.x > t.x && h.y > t.y) {
                t.x++;
                t.y++;
            } else if (h.x > t.x && h.y < t.y) {
                t.x++;
                t.y--;
            } else if (h.x < t.x && h.y > t.y) {
                t.x--;
                t.y++;
            } else if (h.x < t.x && h.y < t.y) {
                t.x--;
                t.y--;
            }
        }
    }
}

/**
 * for(String key : tVis.keySet()) {
 * System.out.println(tVis.get(key) + " " + key);
 * }
 */
