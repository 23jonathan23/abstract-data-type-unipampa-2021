package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import core.Command;
import core.Estudante;
import core.abstractType.BinaryTree;
import core.abstractType.Node;

public class BinaryTreeHandler {
  private static BinaryTree _binaryTree;

  public static long execute(Command command) {
    long startTime;

    switch (command) {
      case InsertStudents:
        var students = generateManyStudents(100000);

        startTime = System.nanoTime();

        insertManyStudentsInBynaryTree(students);
        break;
      case PrintStudents:
        startTime = System.nanoTime();

        printStudentsInOrder(_binaryTree.root);
        break;

      case CountStudentsWithESCourse:
        startTime = System.nanoTime();

        countStudentsWithEsCourse();
        break;
      case RemoveStudents:
        startTime = System.nanoTime();

        removeStudents(_binaryTree.root);
        break;
      default:
        return 0;
    }

    var endTime = System.nanoTime();

    return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
  }

  //requirement 1
  private static void insertManyStudentsInBynaryTree(List<Estudante> students) {
    var rootNode = new Node(students.get(0));

    students.remove(0);

    _binaryTree = new BinaryTree(rootNode);
   
    _binaryTree.addManyElements(students);
  }

  //requirement 2
  private static void printStudentsInOrder(Node node) {
    if (node == null) return;
    
    printStudentsInOrder(node.left);

    System.out.println(node.value.toString());
    
    printStudentsInOrder(node.right);
  }

  //requirement 3
  private static void countStudentsWithEsCourse() {
    var qtdStudents = countStudentsWithEsCourse(_binaryTree.root);

    System.out.printf("\nTem um total de %d estudantes no curso de ES\n", qtdStudents);
  }

  //requirement 4
  private static void removeStudents(Node node) {
    var registration = 202060000;

    removeStudentsIfRegistrationIsEqualsOrMinorThen(registration, node);
  }

  private static int countStudentsWithEsCourse(Node node) {
    if (node == null) return 0;

    var count = node.value.isCursoES() ? 1 : 0;

    return count + countStudentsWithEsCourse(node.left) + countStudentsWithEsCourse(node.right);
  }

  private static void removeStudentsIfRegistrationIsEqualsOrMinorThen(int registration, Node node) {
    if (node == null) return;

    if(node.value.getMatricula() <= registration) 
      _binaryTree.delete(node.value);
    
    removeStudentsIfRegistrationIsEqualsOrMinorThen(registration, node.left);
    
    removeStudentsIfRegistrationIsEqualsOrMinorThen(registration, node.right);
  }

  private static List<Estudante> generateManyStudents(int qtd) {
    var students = new ArrayList<Estudante>();

    for(var i = 0; i < qtd; i++)
        students.add(new Estudante());

    return students;
  }
}
