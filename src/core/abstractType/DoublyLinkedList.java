package core.abstractType;

import core.Estudante;

public class DoublyLinkedList {
    
    public Node initial = null;
    public Node end = null;
    public int size = 0;

    public void add(Estudante student) {
        
        Node node = new Node(student);

        node.left = end;
        node.right = null;

        if (end != null) {
            end.right = node;
        }

        end = node;

        if (size == 0) {
            initial = end;
        }

        size++;
    }

    public void remove(Estudante student) {

        Node current = initial;

        while(current != null) {

            if (student.compareTo(current.value) == 0) {
            
                if (current.left != null)
                    current.left.right = current.right;
                
                if (current.right != null)
                    current.right.left = current.left;
                
                size--;
                return;
            }

            current = current.right;
        }
    }

    public void orderByRegistration() {

        Node ordered = null;

        Node current = initial;

        while (current != null && current.right != ordered) {
            
            while (current != null && current.right != null && current.right != ordered) {

                swap(current, current.right);

                current = current.right;
            }

            ordered = current;

            current = initial;
        }
    }

    private void swap(Node first, Node second) {

        if (first.value.getMatricula() > second.value.getMatricula()) {
            
            Estudante student = first.value;
            first.value = second.value;
            second.value = student;
        }
    }
}
