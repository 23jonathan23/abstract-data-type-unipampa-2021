package application;

import java.util.Arrays;
import java.util.List;

import core.Estudante;
import core.abstractType.Vector;

public class VectorHandler extends BaseHandler {
    private Vector _vector;

    public VectorHandler() {
        _vector = new Vector();
    }

    //requirement 1
    @Override
    protected void insertManyStudentsInBynaryTree(List<Estudante> students) {
        _vector.addManyElements(students);
    }

     //requirement 2
    @Override
    protected void printStudentsInOrder() {
        var source = _vector.getSource();

        Arrays.sort(source);

        for(var i = 0; i < source.length; i++) {
            if(source[i] != null)
                System.out.println(source[i].toString());
        }
    }

     //requirement 3
    @Override
    protected void countStudentsWithEsCourse() {
        var source = _vector.getSource();

        var qtdStudents = 0;

        for(var i = 0; i < source.length; i++) {
            if(source[i] != null && source[i].isCursoES())
                qtdStudents++;
        }

        System.out.printf("\nTem um total de %d estudantes no curso de ES\n", qtdStudents);   
    }

     //requirement 4
    @Override
    protected void removeStudents() {
        var source = _vector.getSource();

        for(var i = 0; i < source.length; i++) {
            if(source[i] != null && source[i].getMatricula() <= registrationToBeDeleted)
                _vector.delete(source[i]);
        }
    }
}
