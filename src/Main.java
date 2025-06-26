import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int trieSizeN = scanner.nextInt();
        int trieSizeK = scanner.nextInt();
        scanner.nextLine();
        Trie root = new Trie();
        root.children = new Trie[trieSizeN];

        for (int i = 0; i < testCases; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            if (!command.equals("P")) {
                int key = Integer.parseInt(commands[1]);
                if (command.equals("I")) {
                    root.insertKey(key, root, trieSizeN, trieSizeK);
                }
                else if (command.equals("L")) {
                    root.printKeyStatus(key, root, trieSizeN, trieSizeK);
                }
                else if (command.equals("D")) {
                }
            }
            else {
                root.print(root, root, trieSizeN, trieSizeK);
            }
        }

        scanner.close();
    }


}