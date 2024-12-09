import java.util.*;

public class Trees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;

        }
    }

    public static Node root;

    public static void levelOrderTraversalInSeq(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.println(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.isEmpty())
                    break;
                else {
                    System.out.println();
                    q.add(null);
                }
            } else {
                System.out.println(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data);
    }

    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static int depthOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int numberOfNodes1(Node root) {
        if (root == null)
            return 0;
        return numberOfNodes1(root.left) + numberOfNodes1(root.right) + 1;
    }

    public static void numberOfNodes2(Node root) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            count++;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        System.out.println(count);
    }

    public static void inOrderDFS(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || st.size() > 0) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data);
            curr = curr.right;
        }
    }

    public static void preOrderDFS(Node root) {
        Stack<Node> st = new Stack<>();
        if (root == null)
            return;
        st.push(root);
        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.data);
            if (temp.left != null)
                st.push(temp.right);
            if (temp.right != null)
                st.push(temp.left);
        }
    }

    public static void postOrderDFS(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node temp = st1.pop();
            st2.push(temp);
            if (temp.left != null)
                st1.push(temp.left);
            if (temp.right != null)
                st1.push(temp.right);
        }
        while (!st2.isEmpty()) {
            Node ans = st2.pop();
            System.out.print(ans.data);
        }
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null || root.data != subRoot.data)
            return false;
        if (!isIdentical(root.left, subRoot.left))
            return false;
        if (!isIdentical(root.right, subRoot.right))
            return false;
        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null)
            return false;
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot))
                return true;
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static int distBtRootToNode(Node root, int p) {
        if (root == null)
            return -1;
        if (root.data == p)
            return 0;
        int ld = distBtRootToNode(root.left, p);
        int rd = distBtRootToNode(root.right, p);
        if (ld == -1 && rd == -1) {
            return -1;
        } else if (ld == -1) {
            return rd + 1;
        } else {
            return ld + 1;
        }
    }

    public static int distanceBtTwoNodes(Node root, int p, int q) {
        Node lca1 = lowestCommonAncestor(root, p, q);
        int ld = distBtRootToNode(lca1, p);
        int rd = distBtRootToNode(lca1, q);
        return ld + rd;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node subroot = new Node(3);
        subroot.left = new Node(6);
        subroot.left = new Node(7);
        // inOrderTraversal(root);
        // levelOrderTraversalInSeq(root);
        // postOrderTraversal(root);
        // preOrderTraversal(root);
        // levelOrderTraversal(root);
        // depthOfTree(root);
        // numberOfNodes1(root);
        //numberOfNodes2(root);
        //System.out.print(count);
        inOrderDFS(root);
        preOrderDFS(root);
        postOrderDFS(root);
        isIdentical(root,subroot);
        isSubTree(root,subroot);
        lowestCommonAncestor(root,6,7);
        disBtRootToNode(root,2);
        disBtTwoNodes(root,2,3);

    }
}
