package Qnum2;

// Define a class to represent nodes in the binary tree
class TreeNode {
    int val;         // Value of the node
    TreeNode left;   // Left child of the node
    TreeNode right;  // Right child of the node

    TreeNode(int val) {
        this.val = val;
    }
}

// Define the main class
public class Anum2b {
    // Define a method to compute the minimum number of service centers required
    public int minServiceCenters(TreeNode root) {
        // If the root is null, then no service centers are required
        if (root == null) {
            return 0;
        }

        // Initialize the number of service centers to 0
        int numCenters = 0;

        // If the left child is not null, then recursively compute the minimum number
        // of service centers required for its grandchildren and add that to the total
        if (root.left != null) {
            numCenters += minServiceCenters(root.left.left) + minServiceCenters(root.left.right) + 1;
        }

        // If the right child is not null, then recursively compute the minimum number
        // of service centers required for its grandchildren and add that to the total
        if (root.right != null) {
            numCenters += minServiceCenters(root.right.left) + minServiceCenters(root.right.right) + 1;
        }


        // Return the minimum of the total number of service centers required for the
        // left and right subtrees plus 1, and the total number of service centers
        // required for the current node and its immediate children
        return Math.min(numCenters, 1 + minServiceCenters(root.left) + minServiceCenters(root.right));
    }

    // Define the main method to create a binary tree and compute the minimum number of service centers required
    public static <Que2b> void main(String[] args) {
        // Create the binary tree based on the input given in the question
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = null;
        root.left.right = new TreeNode(0);
        root.right.left = null;
        root.right.right = null;
        root.left.right.left = new TreeNode(0);

        // Create an instance of the Solution class
        Anum2b num2b = new Anum2b();

        // Call the minServiceCenters method to compute the minimum number of service centers required
        int minCenters = num2b.minServiceCenters(root);

        // Print the result to the console
        System.out.println("Minimum number of service centers required: " + minCenters);
    }
}