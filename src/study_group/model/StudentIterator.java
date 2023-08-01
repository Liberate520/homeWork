package study_group.model;

import java.util.Iterator;
import java.util.List;

class StudentIterator <T> implements Iterator<T> {
    private int index;
    private List<T> studentList;

    public StudentIterator(List<T> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return studentList.size() > index;
    }
    @Override
    public T next() {
        return studentList.get(index++);
    }
}
