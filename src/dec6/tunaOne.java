package dec6;

import java.io.*;
import java.util.*;

public class tunaOne {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("./src/dec6/input.txt"));
        String stream = s.next();

        Map<Character, Integer> marker = new HashMap<>();
        int size = 0;
       
        int mark = 3;
        int pos = 0;

        while (size < 4) {

            marker.clear();

            for (int i = 0; i < 4; i++) {
                marker.put(stream.charAt(pos+i), mark);
            }

            size = marker.size();

            mark++;
            pos++;
            
        }

        System.out.println(mark);
        
        }

    }