import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection implements Iterable<Teachers> {
    private List<Teachers> teachersList;

    public Collection() {
        teachersList = new ArrayList<>();
    }

    public void addTeacher(String surname, String name, String subject){
        Teachers teacher = new Teachers(surname, name, subject);
        teachersList.add(teacher);

    }

    public List<Teachers> getTeachersList() {
        return teachersList;
    }


    public Iterator<Teachers> iterator(){
        return new CollectionIterator();

    }



    class CollectionIterator implements Iterator <Teachers>{
        int index = 0;

        public boolean hasNext(){
            return index < teachersList.size();
        }

        public Teachers next(){
            return teachersList.get(index++);
        }
    }


}
