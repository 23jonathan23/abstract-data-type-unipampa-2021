package core.abstractType;

import java.util.List;

import core.Estudante;

public class Vector {
    private Estudante[] _source;

    public Vector() {
        this._source = new Estudante[] {};
    }

    public void addManyElements(List<Estudante> elements) {
        for (Estudante element : elements)
            add(element);
    }

    public void add(Estudante value) {
        var sourceTemp = new Estudante[_source.length + 1];

        System.arraycopy(_source, 0, sourceTemp, 0, _source.length);

        sourceTemp[sourceTemp.length - 1] = value;

        _source = sourceTemp;
    }

    public void delete(Estudante value) {
        var sourceTemp = new Estudante[_source.length - 1];

        var adjustment = 0;

        for(var i = 0; i < _source.length; i++) {
            if(_source[i] != null && _source[i].compareTo(value) == 0) {
                _source[i] = null;
                adjustment++;
            }
            else if(_source[i] != null) {
                sourceTemp[i - adjustment] = _source[i];
            }
        }

        _source = sourceTemp;
    }

    public Estudante[] getSource() {
        return _source;
    }
}
