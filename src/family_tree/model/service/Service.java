package family_tree.model.service;

import family_tree.model.creatures.Human;
import family_tree.model.creatures.enums.Gender;
import family_tree.model.creatures.interfaces.Creatures;
import family_tree.model.file_handler.interfaces.ReadAndWrite;
import family_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Service {
    private FamilyTree<Human> tree;
    int lastId;
    public Service(){
        tree = new FamilyTree<>();
    }

    public void addHuman(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath){
        lastId = tree.getLastId();
        if (dateOfDeath == null){
            tree.addCreature(new Human(lastId+1,firstName,lastName,gender,dateOfBirth));
        }else{
            tree.addCreature(new Human(lastId+1,firstName,lastName,gender,dateOfBirth,dateOfDeath));
        }
    }
    public void addMother (int idChild, int idMother){
        tree.addMother(idChild, idMother);
    }
    public void addFather (int idChild, int idFather){
        tree.addFather(idChild, idFather);
    }
    public void loadFamilyTreeFromFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        tree = (FamilyTree) readAndWrite.read(path);
    }
    public void saveFamilyTreeInFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        readAndWrite.write(tree, path);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семейного древа:\n");
        for (Creatures creature: tree){
            stringBuilder.append(creature);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String viewAllFamily(int id){
       return tree.viewAllFamily(id);
    }

    public void sortById(){
        tree.sortById();
    }

    public void sortByDateOfBirth(){
        tree.sortByDateOfBirth();
    }

    public void sortByAge(){
        tree.sortByDateOfAge();
    }

    public LocalDate getDate(String date){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            return localDate;
        }
        catch (DateTimeParseException e){
            if (date.isEmpty() == false)
            {
                System.out.println("Вы ввели неверные данные!");
            }
            return null;
        }
    }

    public void listOfGenders(){
        int i = 1;
        for (Gender gender: Gender.values()){
            System.out.println(i + ") " + gender.toString());
            i++;
        }
    }

    public Gender getGender(int idGender){
        int i = 0;
        for (Gender gender : Gender.values()) {
            if (i+1 == idGender) {
                return gender;
            }
            i++;
        }
        System.out.println("Выберете правильный номер!");
        return null;
    }
}
