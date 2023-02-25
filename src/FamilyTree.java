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
import java.util.stream.LongStream;

public class FamilyTree<T extends It> implements Serializable, Iterable<T> {

    private Writable fileHandlerWritable;
    private Readable fileHandlerReadable;

    private List<T> family;

    public FamilyTree(List<T> family) {

        this.family = family;
    }

    public FamilyTree() {
        this(null);
    }

    public List<T> getFamily() {
        return family;
    }


    public void save() throws IOException {
        if (fileHandlerWritable == null) {
            fileHandlerWritable = new FileRW();
        }
        fileHandlerWritable.saveFile(family, "treeOut");
    }

    public void load() throws IOException, ClassNotFoundException {
        if (fileHandlerReadable == null) {
            fileHandlerReadable = new FileRW();
        }
        Object familyCheck = fileHandlerReadable.loadFile("treeOut");
        List<T> familyList = (List<T>) familyCheck;
//        System.out.println(familyCheck);
        family = familyList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------\n");
        for (T h :
                family) {
            result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
        }

        return result.toString();
    }

    public void addToFamily(T human) {
        if (family == null) {
            family = new ArrayList<>();
        }
        if (!family.contains(human)) {
            family.add(human);
        }
        for (It it :
                human.getChildren()) {
            addToFamily((T) it);
        }

    }


    private List<T> findFamilyList(String lastName) {
        List<T> result = new ArrayList<>();
        for (T human :
                family) {
            if (Objects.equals(human.getLastName(), lastName)) {
                result.add(human);
            }
        }
        return result;
    }

    public String findFamily(String name) {
        StringBuilder result = new StringBuilder();
        List<T> lst = findFamilyList(name);
        if (!lst.isEmpty()) {
            for (T h :
                    lst) {
                result.append("ID: ").append(h.getId()).append(" ").append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
            }
        } else {
            result.append("Нет результатов удовлетворящих критериям поиска");
        }
        return result.toString();
    }

    public void getStatistics(T human) {
        if (family.contains(human)) {
            StringBuilder result = new StringBuilder();
            List<T> children = getClildrenAndGrandsonsList(human);
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


    public List<T> getClildrenAndGrandsonsList(T human) {
        List<T> hlist = new ArrayList<>();
        hlist.add(human);
        List<T> result = createClildrenAndGrandsonsList(hlist);
        result.remove(0);
        return result;
    }

    private List<T> createClildrenAndGrandsonsList(List<T> lst) {
        List<T> result = new ArrayList<>(lst);
        int st = lst.size();
        for (T h :
                lst) {
            if (!h.getChildren().isEmpty()) {
                for (It it :
                        h.getChildren()) {
                    if (!result.contains(it)) {
                        result.add((T) it);
                    }
                }
            }
        }
        if (result.size() == lst.size()) {
            return result;
        } else {
            result = createClildrenAndGrandsonsList(result);
        }
        return result;
    }


    public List<T> unPackArgsFindHumans(String[] args) {
        if (args.length != 9) {
            throw new IllegalArgumentException("Expected an array of length 9");
        }
        return findHumans(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
    }

    public List<T> findHumans(
            String gender,
            String firstName,
            String patronymic,
            String lastName,
            String dateOfBornFrom,
            String dateOfBornTo,
            String dateOfDeathFrom,
            String dateOfDeathTo,
            String placeOfBirth
    ) {
        List<T> result = new ArrayList<>();
        TreeFilter<T> tr = new TreeFilter<>();

        List<Function<T, String>> filters = Arrays.asList(
                T::getGender,
                T::getFirstName,
                T::getPatronymic,
                T::getLastName,
                T::getPlaceOfBirth,
                T::getDateOfBorn,
                T::getDateOfDeath,
                T::getDateOfBorn,
                T::getDateOfDeath
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
            if (i == 0) {
                result.addAll(family);
            }
            result.retainAll(tr.filter(result, values.get(i), filters.get(i), types.get(i)));
        }
        return result;
    }

    public void setFamily(List<T> family) {
        this.family = family;
    }

    public void setFileHandlerWritable(Writable fileHandlerWritable) {
        this.fileHandlerWritable = fileHandlerWritable;
    }

    public void setFileHandlerReadable(Readable fileHandlerReadable) {
        this.fileHandlerReadable = fileHandlerReadable;
    }

    public void sortByAge() {
        Collections.sort(family, new HumanComparatorByAge<T>());
    }

    public void sortByLastName() {
        Collections.sort(family, new HumanComparatorByLastName<T>());
    }

    public void sort(SortBy sortBy) {
        Collections.sort(family, new HumanComparator<T>(sortBy));
    }

    public int size() {
        return family.size();
    }

    public int maxId() {
        int maxId = 0;
        for (T u :
                family) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        return maxId;
    }

    public boolean delUnit(int id) {
        boolean flag = false;
        for (int i = 0; i < family.size(); i++) {
            if (family.get(i).getId() == id) {
                family.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public T getUnitById(int id){
        for (T h :
                family) {
            if(h.getId()==id) {
                return h;
            }
        }
        return null;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(family);
    }
}
