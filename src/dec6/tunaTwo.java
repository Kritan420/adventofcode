package dec6;

import java.io.*;
import java.util.*;

public class tunaTwo {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("./src/dec6/input.txt"));
        String stream = s.next();

        Map<Character, Integer> marker = new HashMap<>();
        int size = 0;
       
        int mark = 13;
        int pos = 0;

        while (size < 14) {

            marker.clear();

            for (int i = 0; i < 14; i++) {
                marker.put(stream.charAt(pos+i), mark);
            }

            size = marker.size();

            mark++;
            pos++;
            
        }

        System.out.println(mark);
        
        }

    }