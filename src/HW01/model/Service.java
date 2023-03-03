package HW01.model;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Service implements FileData{

    private FamilyTree familyTree = new FamilyTree();
    private Scanner scanner = new Scanner(System.in);


    public String testTree() {
        String comment;
        familyTree.setPerson(new Person("Ivan1","male", 1000, 1030,"Unknown", "Unknown", List.of("Ivan2")));
        familyTree.setPerson(new Person("Ivan2","male", 1021, 1040, "Unknown", "Ivan1", List.of("Vasiliy1","Fedor1","Sofia1")));
        familyTree.setPerson(new Person("Vasiliy1","male", 1036, 1055, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Fedor1","male", 1031, 1060, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Sofia1","female", 1035, 1069, "Unknown", "Ivan2", List.of()));
        return comment = "Заполнение дерева выполнено";
    }

    public String loadData() throws IOException, ClassNotFoundException {
        String comment;
        familyTree = (FamilyTree) read("familyTree.out");
        return comment = "данные загружены";
    }

    public String saveData() throws IOException {
        String comment;
        save((Serializable) familyTree, "familyTree.out");
        return comment = "данные сохранены";
    }
    public boolean checkName(String name)   {
            //        если имя найдено в базе то true иначе false
        return (familyTree.getPerson(name) != null);
        }


    public String addPerson(String personName,String personSex, Integer birthData, Integer deathData) {
        String comment;
        familyTree.setPerson(new Person(personName, personSex, birthData, deathData));
        return comment = "Запись создана";
        }

    public String updatePerson(String personName,Integer birthDate, Integer deathDate) {
        String comment;
        if (birthDate > 0) {
            familyTree.getPerson(personName).setDateOfBirth(birthDate);
        }
        if (deathDate > 0) {
            familyTree.getPerson(personName).setDateOfDeath(deathDate);
        }
        return comment = "Запись обновлена";
    }


    public String personEnvironment(String personName, String fatherName, String motherName, String childName, String childSex) {
        String comment;
        if (!fatherName.equals("unknown")){
            if (!checkName(fatherName)) {
                familyTree.setPerson(new Person(fatherName,"male", 0, 0));}
            familyTree.getPerson(personName).setFather(fatherName);
            familyTree.getPerson(fatherName).addChild(personName);
        }

        if (!motherName.equals("unknown")){
            if (!checkName(motherName)) {
                familyTree.setPerson(new Person(motherName,"female", 0, 0));}
            familyTree.getPerson(personName).setMother(motherName);
            familyTree.getPerson(motherName).addChild(personName);
        }

        if (!childName.equals("unknown")){
            if (!checkName(childName)) {
                familyTree.setPerson(new Person(childName,childSex, 0, 0));
            }
            familyTree.getPerson(personName).addChild(childName);

            if (familyTree.getPerson(personName).getSex().equals("male")){
                familyTree.getPerson(childName).setFather(personName);
            }else{
                familyTree.getPerson(childName).setMother(personName);
            }
        }
        return comment = "Запись обновлена";
    }


    public String searchPerson(String nameForSearch) {
        return familyTree.getPerson(nameForSearch).toString();
    }

    public String printTree() {
        StringBuilder stringBuilder =new StringBuilder();
        for(Object pers:familyTree){
            stringBuilder.append(pers.toString());
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirth();
    }

    @Override
    public void save(Serializable serializable, String filename) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read(String filename) throws IOException, ClassNotFoundException {
        Object result = new Object();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
