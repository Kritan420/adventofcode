package dec11;

import java.util.ArrayList;

public class Monkey {
    public String name;
    public ArrayList<Integer> items;
    public String operation;
    public String test;
    public String ifTrue;
    public String ifFalse;
    public int inspect;

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

    public String getMonkey() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ":\n");
        sb.append("   Starting items: ");
        for (int i : items) {
            sb.append(i + ", ");
        }
        sb.append("\n");
        sb.append("   Operation: " + operation + "\n");
        sb.append("   Test: " + test + "\n");
        sb.append("     If true: " + ifTrue + "\n");
        sb.append("     If false: " + ifFalse + "\n\n");
        return sb.toString();
    }
}
