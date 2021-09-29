package application;

import java.util.List;

import core.Estudante;
import core.abstractType.BinaryTree;
import core.abstractType.Node;

public class BinaryTreeHandler extends BaseHandler {
  private BinaryTree _binaryTree;

  //requirement 1
  @Override
  protected void insertManyStudents(List<Estudante> students) {
    var rootNode = new Node(students.get(0));

    students.remove(0);

    _binaryTree = new BinaryTree(rootNode);
   
    _binaryTree.addManyElements(students);
  }

  //requirement 2
  @Override
  protected void printStudentsInOrder() {
    printStudentsInOrder(_binaryTree.root);
  }

  //requirement 3
  @Override
  protected void countStudentsWithEsCourse() {
    var qtdStudents = countStudentsWithEsCourse(_binaryTree.root);

    System.out.printf("\nTem um total de %d estudantes no curso de ES\n", qtdStudents);
  }

  //requirement 4
  @Override
  protected void removeStudents() {
    removeStudentsIfRegistrationIsEqualsOrMinorThen(registrationToBeDeleted, _binaryTree.root);
  }

  private void printStudentsInOrder(Node node) {
    if (node == null) return;
    
    printStudentsInOrder(node.left);

    System.out.println(node.value.toString());
    
    printStudentsInOrder(node.right);
  }

  private int countStudentsWithEsCourse(Node node) {
    if (node == null) return 0;

    var count = node.value.isCursoES() ? 1 : 0;

    return count + countStudentsWithEsCourse(node.left) + countStudentsWithEsCourse(node.right);
  }

  private void removeStudentsIfRegistrationIsEqualsOrMinorThen(int registration, Node node) {
    if (node == null) return;

    if(node.value.getMatricula() <= registration) 
      _binaryTree.delete(node.value);
    
    removeStudentsIfRegistrationIsEqualsOrMinorThen(registration, node.left);
    
    removeStudentsIfRegistrationIsEqualsOrMinorThen(registration, node.right);
  }
}
