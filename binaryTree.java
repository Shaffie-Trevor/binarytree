class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null; 
    }
}

class LinkedBinaryTree {
    Node root;

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data); 
        }

        if (data < root.data) {
            root.left = insert(root.left, data); 
        } else {
            root.right = insert(root.right, data); 
        }

        return root;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    
    public boolean search(Node root, int key) {
        if (root == null) {
            return false; 
        }

        if (root.data == key) {
            return true; 
        }

        return key < root.data ? search(root.left, key) : search(root.right, key);
    }

    public Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            
            if (root.left == null && root.right == null) {
                return null;
            }
            
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            Node temp = findMin(root.right); 
            root.data = temp.data;
            root.right = delete(root.right, temp.data); 
        }

        return root;
    }
}


public class binaryTree {
    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();

      
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

      
        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);

        System.out.println("\nSearching for 40: " + tree.search(tree.root, 40));
        System.out.println("Searching for 100: " + tree.search(tree.root, 100));

        System.out.println("Deleting 20...");
        tree.root = tree.delete(tree.root, 20);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(tree.root);

        System.out.println("\nDeleting 50...");
        tree.root = tree.delete(tree.root, 50);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(tree.root);
    }
}
