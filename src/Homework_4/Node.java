package Homework_4;

public class Node<T> {
    public Node<T> parent;
    public Node<T> left;
    public Node<T> right;
    public T value;
    public Color color;

    public Node() {
    }

    public Node(T value) {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.value = value;
        this.color = Color.RED;
    }


    @Override
    public String toString() {
        return "Node{this=" + this.hashCode() +
                ", parent=" + (parent != null ? parent.hashCode() : "null") +
                ", left=" + (left != null ? left.hashCode() : "null") +
                ", right=" + (right != null ? right.hashCode() : "null") +
                ", value=" + value +
                ", color=" + color +
                '}';
    }
}