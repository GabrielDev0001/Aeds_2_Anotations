public class Tree {
    Node root = null;

    void insert(int info, Node place){
        if(place == null){
            root = new Node(info);
            System.out.print(" " + info);
        } else if (info < place.info) {
            if(place.left == null){
                place.left = new Node(info);
                System.out.print(" " + info);
            } else {
                insert(info, place.left);
            }
        } else if (info > place.info) {
            if(place.right == null){
                place.right = new Node(info);
                System.out.print(" " + info);
            } else{
                insert(info, place.right);
            }
        }
    }
    void preOrder(Node place){
        System.out.print(" " + place.info);
        if(place.left != null){
            preOrder(place.left);
        }
        if(place.right != null){
            preOrder(place.right);
        }
    }

    void inOrder(Node place){
        if(place.left != null){
            inOrder(place.left);
        }
        System.out.print(" " + place.info);
        if(place.right != null){
            inOrder(place.right);
        }
    }

    void postOrder(Node place){
        if(place.left != null){
            postOrder(place.left);
        }
        if(place.right != null){
            postOrder(place.right);
        }
        System.out.print(" " + place.info);
    }
}
