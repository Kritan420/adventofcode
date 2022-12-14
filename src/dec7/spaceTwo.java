package dec7;

import java.io.*;
//import java.security.Key;
import java.util.*;
//import java.util.regex.Pattern;

//import javax.swing.event.SwingPropertyChangeSupport;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreeNode;

//import org.w3c.dom.Node;


public class spaceTwo {
    int test = 0;

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("./src/dec7/input.txt"));
        String line = null;
        Folders currDir = new Folders(null, "/");
        
        while (s.hasNextLine()) {
            line = s.nextLine();

            if (line.startsWith("$ cd ")) {
                line = line.substring(5);
                if (line.startsWith("..")) {
                    currDir = currDir.getParent();
                }else {
                    for (int i = 0; i < currDir.getChildren().size(); i++) {
                        if (currDir.getChildren().get(i).getName().equals(line)) {
                            currDir = currDir.getChildren().get(i);
                        }
                    }
                }
            } else if (line.startsWith("dir") || Character.isDigit(line.charAt(0))) {
                    String[] content = new String[2];
                    content = line.split(" ");
                    if (content[0].matches("[\\d]+")) {
                        currDir.addFile(Integer.parseInt(content[0]), content[1]);
                    } else if (content[0].startsWith("dir")) {
                        currDir.addChild(content[1]);
                    }
            }
        }

        
        


        while (!currDir.getName().equals("/")) {
            currDir = currDir.parent;
        }
    

        ArrayList<Folders> allFolds = getTotalFold(currDir);

        int totalspace = 70000000;
        int freespace = totalspace - getTotalSize(currDir);

        int needspace = 30000000;

        int fixspace = needspace - freespace;

        int diff = Integer.MAX_VALUE;
        int index = 0;
        int smallestIndex = 0;

        for (Folders f : allFolds) {
            if (getTotalSize(f) - fixspace > 0) {
                if (diff > getTotalSize(f) - fixspace) {
                    diff = getTotalSize(f) - fixspace;
                    smallestIndex = index;
                }
            }
            index++;
        }

        System.out.println("Best folder to delete: " + allFolds.get(smallestIndex).getName() + " | Size: " + getTotalSize(allFolds.get(smallestIndex)));
        /**int sum = 0;
 */


        


       

        
    }
  
    public static int getTotalSize(Folders dir) {
        int childSize = 0;
        if (dir.children.size() > 0) {
            for (int i = 0; i < dir.children.size(); i++) {
                childSize += getTotalSize(dir.children.get(i));
            }
        }
        return dir.size + childSize;
    }
    public static ArrayList<Folders> getTotalFold(Folders dir) {
        
        
        ArrayList<Folders> test = new ArrayList<>();
        test.add(dir);
        if (dir.children.size() > 0) {
            for (int i = 0; i < dir.children.size(); i++) {
                test.addAll(getTotalFold(dir.children.get(i)));
            }
        }
        
        return test;
    }
}


