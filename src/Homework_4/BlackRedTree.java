package Homework_4;

public class BlackRedTree<T extends Comparable<T>> {
    public Node<T> root;

    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(value);
            root.color = Color.BLACK;
            return true;
        } else {
            return add(value, root);
        }
    }

    private boolean add(T value, Node<T> startNode) {
        if (startNode.value.equals(value)) {
            return false;
        }
        if (startNode.value.compareTo(value) > 0) {
            if (startNode.left == null) {
                startNode.left = new Node<>(value);
                startNode.left.parent = startNode;
                balancing(startNode.left);
                return true;
            }
            return add(value, startNode.left);
        } else {
            if (startNode.right == null) {
                startNode.right = new Node<>(value);
                startNode.right.parent = startNode;
                balancing(startNode.right);
                return true;
            } else {
                return add(value, startNode.right);
            }
        }
    }

    private void balancing(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.parent != null) {
            if (node.parent.left != null && node.parent.right != null &&
                    node.parent.right.color == Color.RED && node.parent.left.color == Color.RED) {
                colorSwap(node.parent);
            }

            if (node.parent.right == node && node.color == Color.RED) {
                rotateLeft(node.parent);
                if (node.parent != null) {
                    if (node.parent.left != null) {
                        balancing(node.parent.left);
                    }
                    if (node.parent.right != null) {
                        balancing(node.parent.right);
                    }
                }
            } else {
                if (node.parent.left == node && (node.color == Color.RED && node.parent.color == Color.RED)) {
                    rotateRight(node.parent.parent);
                    colorSwap(node.parent);
                    balancing(node.parent.right.left);
                }
            }
        }
    }

    public void rotateLeft(Node<T> node) {
        Node<T> parentNode = node.parent;
        Node<T> childNode = node.right;
        node.right = childNode.left;
        childNode.left = node;
        node.parent = childNode;
        childNode.parent = parentNode;
        if (parentNode != null) {
            if (parentNode.left == node) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        } else {
            root = childNode;
        }
        node.color = Color.RED;
        childNode.color = Color.BLACK;
    }

    public void rotateRight(Node<T> node) {
        Node<T> parentNode = node.parent;
        Node<T> childNode = node.left;
        node.left = childNode.right;
        childNode.right = node;
        node.parent = childNode;
        childNode.parent = parentNode;
        if (parentNode != null) {
            if (parentNode.left == node) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

        } else {
            root = childNode;
        }
        node.color = Color.RED;
        childNode.color = Color.BLACK;
    }

    public void colorSwap(Node<T> node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        if (node == root) {
            node.color = Color.BLACK;
        }
        balancing(node);
    }

    public void print(Node<T> head) {
        if (head != null) {
            System.out.println(head);
            print(head.left);
            print(head.right);
        }
    }
}