package application;

import java.util.List;

import core.Estudante;
import core.abstractType.DoublyLinkedList;
import core.abstractType.Node;

public class DoublyLinkedListHandler extends BaseHandler {

    private DoublyLinkedList linkedList;

    public DoublyLinkedListHandler() {
        super();
        this.linkedList = new DoublyLinkedList();
    }

    @Override
    protected void insertManyStudentsInBynaryTree(List<Estudante> students) {

        for (var student : students) {
            linkedList.add(student);
        }
    }

    @Override
    protected void printStudentsInOrder() {
        
        linkedList.orderByRegistration();

        Node current = linkedList.initial;

        while (current != null) {

            System.out.println(current.value.toString());

            current = current.right;
        }
    }

    @Override
    protected void countStudentsWithEsCourse() {

        int counter = 0;

        Node current = linkedList.initial;

        while (current != null) {

            if (current.value.getCurso().equals("Engenharia de Software")) {

                counter++;
            }

            current = current.right;
        }

        System.out.printf("\nTem um total de %d estudantes no curso de ES\n", counter);
    }

    @Override
    protected void removeStudents() {
        
        Node current = linkedList.initial;

        while (current != null) {

            if (current.value.getMatricula() <= registrationToBeDeleted) {

                linkedList.remove(current.value);
            }

            current = current.right;
        }
    }
    
}
