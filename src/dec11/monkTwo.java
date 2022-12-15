package dec11;

import java.io.*;
import java.util.*;


public class monkTwo {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("./src/dec11/input2.txt"));

        ArrayList<Monkey> monkeys = new ArrayList<>();

        String line = null;
        int m = 0;

        while (sc.hasNextLine()) {
            line = sc.nextLine().stripIndent();
            if (line.startsWith("Monkey")) {
                monkeys.add(new Monkey(m));
                m++;
            }
            if (line.startsWith("Starting items:")) {
                String items = line.substring(16);
                items = items.replaceAll(",", "");
                String[] itemArr = items.split(" ");
                for (String i : itemArr) {
                    monkeys.get(m - 1).addItem(Integer.parseInt(i));
                }
            }
            if (line.startsWith("Operation:")) {
                String operation = line.substring(11);
                monkeys.get(m - 1).setOperation(operation);
            }
            if (line.startsWith("Test:")) {
                String test = line.substring(6);
                monkeys.get(m - 1).setTest(test);
            }
            if (line.startsWith("If true:")) {
                String ifTrue = line.substring(9);
                monkeys.get(m - 1).setTrue(ifTrue);
            }
            if (line.startsWith("If false:")) {
                String ifFalse = line.substring(10);
                monkeys.get(m - 1).setFalse(ifFalse);
            }
        }

        for (int round = 0; round < 10000; round++) {

       
        for (int i = 0; i < monkeys.size(); i++) {
            
            ArrayList<Integer> remove = new ArrayList<>();

            for (int j = 0; j < monkeys.get(i).getItems().size(); j++) {
                monkeys.get(i).inspect++;
                int o = monkeys.get(i).getItems().get(j);
                
                String operation = monkeys.get(i).operation;

                o = performOp(operation, o);
                String test = monkeys.get(i).test;

                boolean tested = performTest(test, o);
                
                int newM = 0;

                if (tested) {
                    remove.add(monkeys.get(i).getItems().get(j));
                    newM = Integer.parseInt(monkeys.get(i).ifTrue.substring(16));
                    monkeys.get(newM).addItem(o);
                } else {
                    remove.add(monkeys.get(i).getItems().get(j));
                    newM = Integer.parseInt(monkeys.get(i).ifFalse.substring(16));
                    monkeys.get(newM).addItem(o);
                }
            }
            monkeys.get(i).items.removeAll(remove);
        }
    }

    for (int i = 0; i < monkeys.size(); i++) {
        System.out.println(monkeys.get(i).name + " inspected items " + monkeys.get(i).inspect + " times.");
    }

    }

    public static int performOp(String operation, int o) {

        int n = 0;
        char arit = operation.charAt(10);

        if (operation.endsWith("old * old")) {
            n = o;
        } else {
            n = Integer.parseInt(operation.replaceAll("[^0-9]", ""));
        }

        if (arit == '*') {
            return o * n;
        }
        if (arit == '+') {
            return o + n;
        }

        return n;
    }

    public static boolean performTest(String test, int worry) {

        int denom = Integer.parseInt(test.substring(13));

        if (worry % denom == 0) {
            return true;
        } else {
            return false;
        }

    }
}
