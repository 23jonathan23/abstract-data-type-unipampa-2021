package core.abstractType;

import java.util.List;

import core.Estudante;

public class BinaryTree {
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void addManyElements(List<Estudante> elements) {
        for (Estudante element : elements)
            root = addRecursive(root, element);
    }

    public void add(Estudante value) {
        root = addRecursive(root, value);
    }

    public void delete(Estudante value) {
        root = deleteRecursive(root, value);
    }

    private Node addRecursive(Node current, Estudante value) {
        if (current == null) return new Node(value);
    
        if (value.compareTo(current.value) < 0)
            current.left = addRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0) 
            current.right = addRecursive(current.right, value);     
        else return current;
    
        return current;
    }

    private Node deleteRecursive(Node current, Estudante value) {
        if (current == null) return null;
    
        if (value.compareTo(current.value) == 0) {
            if (current.left == null && current.right == null)
                return null;

            if (current.right == null) 
                return current.left;

            if (current.left == null)
                return current.right;

            var smallestValue = findSmallestValue(current.right);
            
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            
            return current;
        }
        else if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        
        current.right = deleteRecursive(current.right, value);
        
        return current;
    }

    private Estudante findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }   
}