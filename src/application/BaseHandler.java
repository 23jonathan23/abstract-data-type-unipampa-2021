package application;

import java.util.ArrayList;
import java.util.List;

import core.Command;
import core.Estudante;

public abstract class BaseHandler {
    protected int registrationToBeDeleted = 202060000;

    public abstract long execute(Command command);

    protected abstract void insertManyStudentsInBynaryTree(List<Estudante> students);

    protected abstract void printStudentsInOrder();

    protected abstract void countStudentsWithEsCourse();

    protected abstract void removeStudents();

    protected static List<Estudante> generateManyStudents(int qtd) {
        var students = new ArrayList<Estudante>();
    
        for(var i = 0; i < qtd; i++)
            students.add(new Estudante());
    
        return students;
    }
}
