import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> people = new ArrayList<>();
    private ReadWriteData rw2;
    public void addHuman(Human human){
        people.add(human);
    }
    public Human getHuman(String firstName, String lastName, String birthday){
        for (Human human: people
        ) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName) && human.getBirthday().equals(birthday)){
                return human;
            }
        }
        return null;
    }

    public Human getMother(Human human){
        return human.getMother();
    }

    public Human getFather(Human human){
        return human.getFather();
    }

    public List<Human> getBrothers(Human human){
        List<Human> brothers = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
             ) {
            if (item != human && item.getMother() == mother && item.getFather() == father && item.getGender() == Gender.Male){
                brothers.add(item);
            }
        }
        return brothers;
    }

    public List<Human> getSisters(Human human){
        List<Human> sisters = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
        ) {
            if (item != human && item.getMother() == mother && item.getFather() == father && item.getGender() == Gender.Female){
                sisters.add(item);
            }
        }
        return sisters;
    }
    public List<Human> getAllHuman(){
        return people;
    }

    public void saveToFile(){
        ReadWriteData rw = new ReadWriteObject();
        try {
            rw.writeData(people);
            System.out.println("Записанов в файл.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFromFile(){
        ReadWriteData rw = new ReadWriteObject();
        try {
            List<Human> restoredData = rw.readData();
            System.out.println("Прочтено из файла");
            System.out.println(restoredData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveToByte(){
        rw2 = new ReadWriteByteArray();
            try {
                rw2.writeData(people);
                System.out.println("Записано в ByteArrayOutputStream");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public void readFromByte(){
        try {
            List<Human> restoredData2 = rw2.readData();
            System.out.println("Прочтено из ByteArrayOutputStream");
            System.out.println(restoredData2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
