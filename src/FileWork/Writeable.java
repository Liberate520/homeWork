package FileWork;
import java.io.FileNotFoundException;
import Group.Group;
import Person.Person;

public interface Writeable{
    public static void SaveToFile(Group group, String filename) throws FileNotFoundException{};   
    public static Group LoadFromFile(String filename){
        Group group=new Group() {

            @Override
            public void addPerson(Person person) {
            }

            @Override
            public Person getPersonByName(String name) {
                throw new UnsupportedOperationException("Unimplemented method 'getPersonByName'");
            }

            @Override
            public void findPerson() {
            }
            
        };
        return group;
    }; 
      
}
