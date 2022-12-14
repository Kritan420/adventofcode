package dec11;
import java.io.*;
import java.util.*;

class Monkey {
    public String name;
    public ArrayList<Integer> items;
    public String operation;
    public String test;
    public String ifTrue;
    public String ifFalse;

    public Monkey(int i) {
        this.name = "Monkey " + i;
        this.items = new ArrayList<>();
    }
    public void addItem(int item) {
        items.add(item);
    }
    public ArrayList<Integer> getItems() {
        return items;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public void setTest(String test) {
        this.test = test;
    }
    public void setTrue(String ifTrue) {
        this.ifTrue = ifTrue;
    }
    public void setFalse(String ifFalse) {
        this.ifFalse = ifFalse;
    }
}


public class monkOne {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/dec11/input.txt"));

        ArrayList<Monkey> monkeys = new ArrayList<>();

        String line = null;
        int m= 0;

        while (sc.hasNextLine()) {
            line = sc.nextLine().stripIndent();

            if (line.startsWith("Monkey"))  {
                monkeys.add(new Monkey(m));
                m++;
            }
            if (line.startsWith("Starting items:"))  {
                String items = line.substring(16);
                items = items.replaceAll(",", "");

                System.out.println(items);
            }
            
        }

        for (Monkey mo : monkeys) {
            System.out.println(mo.name);
        }
    }

}
