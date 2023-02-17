package src;

import org.jetbrains.annotations.NotNull;
import src.comparator.HumanComparator;
import src.comparator.HumanComparatorByAge;
import src.comparator.HumanComparatorByLastName;
import src.comparator.SortBy;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

public class FamilyTree implements Serializable, Iterable<Human> {

    private Writable fileHandlerWritable;
    private Readable fileHandlerReadable;

    private List<Human> family = new ArrayList<>();
    public FamilyTree(List<Human> family) {
        this.family = family;
    }
    public FamilyTree() {
        this(null);
    }

    public List<Human> getFamily() {
        return family;
    }






    public void save() throws IOException {
        if(fileHandlerWritable == null) {
            fileHandlerWritable = new FileRW();
        }
        fileHandlerWritable.saveFile(family, "treeOut");
    }

    public void load() throws IOException, ClassNotFoundException {
        if(fileHandlerReadable == null) {
            fileHandlerReadable = new FileRW();
        }
        Object familyCheck = fileHandlerReadable.loadFile("treeOut");
        if(familyCheck instanceof List res) {
            family = new ArrayList<>();
            //Ненадежно, как-то... но работает
            family.addAll(res);
        }

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------\n");
        for (Human h:
             family) {
            result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
        }

        return result.toString();
    }

    public void addToFamily(Human human){
        if(family == null) {
            family = new ArrayList<>();
        }
        if(!family.contains(human)){
            family.add(human);
        }
        for (Human h :
                human.getChildren()) {
            addToFamily(h);
        }

    }



    private List<Human> findFamilyList(String lastName){
        List<Human> result = new ArrayList<>();
        for (Human human:
             family) {
            if(Objects.equals(human.getLastName(), lastName)){
                result.add(human);
            }
        }
        return result;
    }

    public String findFamily(String name){
        StringBuilder result = new StringBuilder();
        List<Human> lst = findFamilyList(name);
        if(!lst.isEmpty()){
            for (Human h:
                    lst) {
                result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
            }
        } else {
            result.append("Нет результатов удовлетворящих критериям поиска");
        }
        return result.toString();
    }

    public void getStatistics(Human human){
        if(family.contains(human)) {
            StringBuilder result = new StringBuilder();
            List<Human> children = getClildrenAndGrandsonsList(human);
            result.append("---------------------------\n");
            result.append("ФИО: ").append(human.getLastName()).append(" ").append(human.getFirstName()).append(" ").append(human.getPatronymic());
            result.append("\n");
            result.append("Родился ").append(human.getDateOfBorn()).append(" г. в ").append(human.getPlaceOfBirth()).append("\n");
            if (!human.isAlive()) {
                result.append("Умер ").append(human.getDateOfDeath()).append(" г\n");
                result.append("Прожил ").append(human.getAge()).append(" полных лет\n");
            }
            result.append("Имеет ").append(human.getChildren().size()).append(" детей и ").append(children.size() - human.getChildren().size()).append(" внуков с правнуками");
            System.out.println(result);
        }
    }
    // описание ранее не соответствововало названию, получаем список детей их детей и так по низходящей
    public List<Human> getClildrenAndGrandsonsList(Human human){
        List<Human> hlist = new ArrayList<>();
        hlist.add(human);
        List<Human> result = createClildrenAndGrandsonsList(hlist);
        result.remove(0);
        return result;
    }
    private List<Human> createClildrenAndGrandsonsList(List<Human> lst) {
        List<Human> result = new ArrayList<>(lst);
        int st = lst.size();
        for (Human h :
                lst) {
                if(!h.getChildren().isEmpty()){
                    for (Human hh :
                            h.getChildren()) {
                        if(!result.contains(hh)){
                            result.add(hh);
                        }
                    }
                }
        }
        if(result.size()==lst.size()){
            return result;
        } else {
            result = createClildrenAndGrandsonsList(result);
        }
        return result;
    }



    public List<Human> findHumans(
            String gender,
            String firstName,
            String patronymic,
            String lastName,
            String dateOfBornFrom,
            String dateOfBornTo,
            String dateOfDeathFrom,
            String dateOfDeathTo,
            String placeOfBirth
    ){
        List<Human> result = new ArrayList<>();
        TreeFilter tr = new TreeFilter();

        List<Function<Human, String>> filters = Arrays.asList(
                Human::getGender,
                Human::getFirstName,
                Human::getPatronymic,
                Human::getLastName,
                Human::getPlaceOfBirth,
                Human::getDateOfBorn,
                Human::getDateOfDeath,
                Human::getDateOfBorn,
                Human::getDateOfDeath
        );
        List<String> values = Arrays.asList(
                gender,
                firstName,
                patronymic,
                lastName,
                placeOfBirth,
                dateOfBornFrom,
                dateOfDeathFrom,
                dateOfBornTo,
                dateOfDeathTo
        );
        List<FilterType> types = Arrays.asList(
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.DATE_FROM,
                FilterType.DATE_FROM,
                FilterType.DATE_TO,
                FilterType.DATE_TO
        );

        for (int i = 0; i < filters.size(); i++) {
            if(i == 0) {
                result.addAll(family);
            }
            result.retainAll(tr.filter(result, values.get(i), filters.get(i), types.get(i)));
        }
        return result;
    }

    public void setFamily(List<Human> family) {
        this.family = family;
    }

    public void setFileHandlerWritable(Writable fileHandlerWritable) {
        this.fileHandlerWritable = fileHandlerWritable;
    }

    public void setFileHandlerReadable(Readable fileHandlerReadable) {
        this.fileHandlerReadable = fileHandlerReadable;
    }

    public void sortByAge(){
        Collections.sort(family, new HumanComparatorByAge());
    }

    public void sortByLastName(){
        Collections.sort(family, new HumanComparatorByLastName());
    }

    public void sort(SortBy sortBy){
        Collections.sort(family, new HumanComparator(sortBy));
    }

    @NotNull
    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(family);
    }
}
