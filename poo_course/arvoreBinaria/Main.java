import java.util.Random;
class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Tree tree = new Tree();

        for (int i = 0; i < 10; i++) {
            tree.insert(rand.nextInt(100), tree.root);
        }

        System.out.println("\nPre Order:");
        tree.preOrder(tree.root);

        System.out.println("\nIn Order:");
        tree.inOrder(tree.root);

        System.out.println("\nPost Order:");
        tree.postOrder(tree.root);
    }
}
