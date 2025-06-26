import java.util.ArrayList;
import java.util.List;

public class Trie {
    public static final int NOT_ASSIGNED = -1;
    int key = NOT_ASSIGNED;
    public Trie[] children;

    public Trie() {
        this.key = NOT_ASSIGNED;
        this.children = null;
    }

    public Trie[] getChildren() {
        return this.children;
    }

    private int getChildCount(Trie node, Trie root, int nChildren, int kChildren) {
        return (node == root) ? nChildren : kChildren;
    }

    public void insertKey(int key, Trie root, int nChildren, int kChildren) {
        if (root.key == -1) {
            root.key = key;
            return;
        }

        if (root.key == key) {
            System.out.println(key + " exist");
            return;
        }

        Trie toAdd = root;
        int howManyChildren = getChildCount(toAdd, root, nChildren, kChildren);
        int indexToCheck = key % howManyChildren;
        int division = key / howManyChildren;

        while (true) {
            if (toAdd.children == null) {
                toAdd.children = new Trie[kChildren];
                for (int i = 0; i < kChildren; i++) {
                    toAdd.children[i] = null;
                }
            }

            if (toAdd.children[indexToCheck] == null) {
                toAdd.children[indexToCheck] = new Trie();
            }

            toAdd = toAdd.children[indexToCheck];

            if (toAdd.key == NOT_ASSIGNED) {
                toAdd.key = key;
                return;
            } else if (toAdd.key == key) {
                System.out.println(key + " exist");
                return;
            }

            howManyChildren = getChildCount(toAdd, root, nChildren, kChildren);
            indexToCheck = division % howManyChildren;
            division /= howManyChildren;
        }
    }

    public void printKeyStatus(int key, Trie root, int nChildren, int kChildren) {
        if (root.key == key) {
            System.out.println(key + " exists");
            return;
        }
        Trie toCheck = root;
        int division = key;
        int indexToCheck = 0;

        while (toCheck != null) {
            if (toCheck.key == key) {
                System.out.println(key + " exists");
                return;
            }

            if (toCheck.children == null) {
                System.out.println(key + " doesn't exist");
                return;
            }
            int howManyChildren = getChildCount(toCheck, root, nChildren, kChildren);
            indexToCheck = division % howManyChildren;
            division /= howManyChildren;

            toCheck = toCheck.children[indexToCheck];
        }
        System.out.println(key + " doesn't exist");
    }

    public void deleteKey(int key, Trie root, int nChildren, int kChildren) {

    }

    public void print(Trie node, Trie root, int nChildren, int kChildren) {
        if (node == null) return;
        if (node.key != NOT_ASSIGNED) {
            System.out.print(node.key + " ");
        }

        int childCount = getChildCount(node, root, nChildren, kChildren);
        for (int i = 0; i < childCount; i++) {
            if ((node.children != null) && node.children[i] != null) {
                print(node.children[i], root, nChildren, kChildren);
            }
        }
    }
}


