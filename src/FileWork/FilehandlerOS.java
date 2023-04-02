package FileWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Group.Group;
import Person.Person;

public class FilehandlerOS extends Filehahdler{
 
    public static void SaveToFile(Group group, String filename) {
        // familyTree= new FamilyTree();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(group);
            System.out.printf("File " + filename + " has been written.\n");
            oos.flush();
            oos.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static Group LoadFromFile(String filename) {
        Group group = new Group() {

            @Override
            public void addPerson(Person person) {
                throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
            }

            @Override
            public Person getPersonByName(String name) {
                throw new UnsupportedOperationException("Unimplemented method 'getPersonByName'");
            }

            @Override
            public void findPerson() {
                throw new UnsupportedOperationException("Unimplemented method 'findPerson'");
            }
        };
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            group=((Group) ois.readObject());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return group;
    }


}
