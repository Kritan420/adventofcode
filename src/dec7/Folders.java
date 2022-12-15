package dec7;

import java.util.ArrayList;

public class Folders {
    Folders parent;
    String name;
    ArrayList<Folders> children;
    ArrayList<String> files;
    int size;

    public Folders(Folders parent, String name) {
        this.parent = parent;
        this.name = name;
        children = new ArrayList<>();
        files = new ArrayList<>();
        size = 0;
    }

    public void addChild(String child) {
        children.add(new Folders(this.getFolder(), child));
    }

    public Folders getParent() {
        if (parent == null) {
            return null;
        }
        return parent;
    }

    public String getName() {
        return name;
    }

    public Folders getFolder() {
        return this;
    }

    public ArrayList<Folders> getChildren() {
        return children;
    }

    public void addFile(int size, String filename) {
        files.add(filename);
        this.size = this.size + size;
    }

    public int getSize() {
        return this.size;
    }


}