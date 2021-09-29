package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import core.Command;
import core.Estudante;

public abstract class BaseHandler {
    protected int registrationToBeDeleted = 202060000;

    private int generateStudentsNumber = 100000;

    public long execute(Command command) {
        long startTime;

        switch (command) {
            case InsertStudents:
                var students = generateManyStudents(generateStudentsNumber);

                startTime = System.nanoTime();

                insertManyStudents(students);
                break;
            case PrintStudents:
                startTime = System.nanoTime();

                printStudentsInOrder();
                break;

            case CountStudentsWithESCourse:
                startTime = System.nanoTime();

                countStudentsWithEsCourse();
                break;
            case RemoveStudents:
                startTime = System.nanoTime();

                removeStudents();
                break;
            default:
                return 0;
        }

        var endTime = System.nanoTime();

        return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
    }

    protected abstract void insertManyStudents(List<Estudante> students);

    protected abstract void printStudentsInOrder();

    protected abstract void countStudentsWithEsCourse();

    protected abstract void removeStudents();

    protected static List<Estudante> generateManyStudents(int qtd) {
        var students = new ArrayList<Estudante>();

        for (var i = 0; i < qtd; i++)
            students.add(new Estudante());

        return students;
    }
}
