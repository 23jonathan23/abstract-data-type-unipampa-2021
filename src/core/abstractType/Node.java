package core.abstractType;

import core.Estudante;

public class Node {
    public Estudante value;
    public Node left;
    public Node right;

    public Node(Estudante value) {
        this.value = value;
        right = null;
        left = null;
    }
}
