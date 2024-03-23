public class PriorityQueue<E extends Comparable<E>> {
    private Node<E> root;

    public PriorityQueue() {
        this.root = null;
    }

    public void enqueue(E value) {
        Node<E> newNode = new Node<>(value);
        root = merge(root, newNode);
    }

    public E dequeue(){
        E placeHold = root.element;
        root = merge(root.left, root.right);
        return placeHold;
    }
    public boolean isEmpty() {
        if (root == null){
            return true;
        } else {
            return false;
        }

    }
    private Node<E> merge(Node<E> t1, Node<E> t2) {
        Node<E> small;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        if (t1.element.compareTo(t2.element) < 0) {
            t1.right = merge(t1.right, t2);
            small = t1;
        } else {
            t2.right = merge(t2.right, t1);
            small = t2;
        }
        if (getNpl(small.left) < getNpl(small.right)) {
            swapkids(small);
            setNullPathLength(small);
        }
        return small;

    }
    private void setNullPathLength(Node<E> node){
        if (node != null){
            node.npl = Math.min(getNpl(node.left), getNpl(node.right)) + 1;
        }
    }
    private void swapkids(Node<E> node) {
        Node<E> placeHold = node.left;
        node.left = node.right;
        node.right = placeHold;
    }

    private int getNpl(Node<E> t) {
        if (t == null) return -1;
        return t.npl;
    }

    private class Node<E> {
        Node(E value) {
            this(value, null, null);
        }

        Node(E value, Node<E> left, Node<E> right) {
            this.element = value;
            this.left = left;
            this.right = right;
            npl = 0;
        }

        public E element; // The data in the node
        public Node<E> left; // Left child
        public Node<E> right; // Right child
        public int npl; // null path length
    }

}