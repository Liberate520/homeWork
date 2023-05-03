package model;

import model.family.FamilyTree;

import model.person.Person;
import model.person.comparators.PersonComparatorByIdASC;
import model.person.comparators.PersonComparatorByIdDESC;
import model.person.comparators.PersonComparatorByNameASC;
import model.person.comparators.PersonComparatorByNameDESC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Service<E extends Person> {
    private FamilyTree<E> family;
    private final String pathToFile = System.getProperty("user.dir").concat(System.getProperty("file.separator"));
    private final String extensionFiles = ".fml";
    private String fileName;

    public void setFamily(FamilyTree<E> family) {
        this.family = family;
    }

    public Service(FamilyTree<E> family) {
        this.family = family;
    }

    public void addPerson(E person, String personName, String personeSurname, Date dateOfBirth, Date dateOfDeath,
                          Integer motherID, Integer fatherID, Integer partnerID) {
        if (person.getID() == -1) {
            int id = family.getId();
            person.setID(id);
        }
        person.setPersonName(personName);
        person.setPersonSurname(personeSurname);
        person.setDateOfBirth(dateOfBirth);
        person.setDateOfDeath(dateOfDeath);
        person.setMotherID(motherID);
        person.setFatherID(fatherID);
        person.setPartnerID(partnerID);
        family.add(person);
    }

    public void deletePerson(Integer id) {
        family.delete(id);
        for (E person : family) {
            if (Objects.equals(person.getMotherID(), id)) person.setMotherID(null);
            else if (Objects.equals(person.getFatherID(), id)) person.setFatherID(null);
            else if (Objects.equals(person.getPartnerID(), id)) person.setPartnerID(null);
        }
    }

    public List<E> getSortedListByIdDESC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByIdDESC<>());
        return result;
    }

    public List<E> getSortedListByIdASC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByIdASC<>());
        return result;
    }

    public List<E> getSortedListByNameASC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByNameASC<>());
        return result;
    }

    public List<E> getSortedListByNameDESC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByNameDESC<>());
        return result;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> listFiles() {
        File folder = new File(pathToFile);
        ArrayList<String> result = new ArrayList<>();

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile() && file.getName().substring(file.getName().length() - 4).equals(extensionFiles)) {
                result.add(file.getName());
            }
        }
        return result;
    }

    public void saveTree() throws IOException {
        SaveRestoreSerializable<E> objSave = new SaveRestoreSerializable<>();
        objSave.save(pathToFile.concat(fileName).concat(extensionFiles), family);
    }

    public FamilyTree<E> loadTree() throws IOException, ClassNotFoundException {
        SaveRestoreSerializable<E> objLoad = new SaveRestoreSerializable<>();
        FamilyTree<E> result = objLoad.load(pathToFile.concat(fileName));
        setFamily(result);
        return result;
    }

    public Integer getLastID() {
        return family.getId() - 1;
    }

    public String getNamePerson(Integer id) {
        return family.getNameByID(id);
    }

    public String showTree(Integer id) {
        return family.showTree(id);
    }

    public boolean checkID(Integer id) {
        return family.checkID(id);
    }

    public Integer sizeTree() {
        return family.sizeTree();
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getExtensionFiles() {
        return extensionFiles;
    }
}
