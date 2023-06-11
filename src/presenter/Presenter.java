package presenter;

import model.HumanService;
import model.family.Family;
import model.human.Human;
import model.member.Connection;
import model.member.Gender;
import ui.UI;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Presenter {
    private UI view;
    private HumanService model;

    public Presenter(UI view) {
        this.view = view;
        model = new HumanService();
    }

    public void showFamilyTrees() {
        StringBuilder result = new StringBuilder();
        List<Family<Human>> allFamilies = model.getRecords();
        for (Family<Human> family:allFamilies) {
            result.append(String.format("Семья '%s':\n", family.getName()));
            int lastLen = result.length();
            for (Human human : family) {
                result.append(String.format("\t%s\n", human));
            }
            if (result.length() == lastLen) result.append(String.format("\t%s\n", view.noData()));
        }
        if (result.length() == 0) view.print(view.noData());
        else view.print(result.toString());
    }
    public void listFamilies() {
        StringBuilder result = new StringBuilder();
        List<Family<Human>> allFamilies = model.getRecords();
        for (Family<Human> family:allFamilies) {
            result.append(String.format("%s\n", family.getName()));
        }
        if (result.length() == 0) view.print(view.noData());
        else view.print(result.toString());
    }
    public void addFamily(String name) {
        if (model.searchFamily(name) != null) view.print("Семья с таким именем уже существует");
        else {
            model.addFamily(name);
            view.print(String.format("Семья '%s' создана\n", name));
        }
    }
    public Family<Human> getFamily(String name) {
        return model.searchFamily(name);
    }

    /**
     * https://stackoverflow.com/questions/468789/is-there-a-way-in-java-to-determine-if-a-path-is-valid-without-attempting-to-cre
     */
    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }
    public void saveToFile(String path) {
        if (!isValidPath(path)) view.print("Путь до файла задан неправильно");
        else {
            if (model.save(path)) view.print("Успешное сохранение файла");
            else view.print("Ошибка при сохранении файла");
        }
    }
    public void loadFromFile(String path) {
        if (!isValidPath(path)) view.print("Путь до файла задан неправильно");
        else {
            if (model.load(path)) view.print("Успешная загрузка файла");
            else view.print("Ошибка при загрузке файла");
        }
    }
    public void listPeopleFromFamily(Family<Human> family) {
        model.getFamilyMembers(family);
        StringBuilder result = new StringBuilder();
        List<Human> familyMembers = model.getFamilyMembers(family);
        for (Human member:familyMembers) {
            result.append(String.format("%s\n", member));
        }
        if (result.length() == 0) view.print(view.noData());
        else view.print(result.toString());
    }
    public List<String> getGenderNames() {
        List<String> result = new ArrayList<>();
        for (Gender gender : model.getGenders()) {
            result.add(gender.toString());
        }
        return result;
    }
    private Calendar parseDate(String dateString) {
        if (dateString.isEmpty()) return null;
        String[] dateStrings = dateString.split("-");
        return new GregorianCalendar(Integer.parseInt(dateStrings[0]),
                Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[2]));
    }
    public void addHuman(Family<Human> family, String name, String genderName, String birthDateString, String deathDateString) {
        Human globalHuman = model.globalSearchHuman(name);
        Human human;
        if (globalHuman != null) {
            human = model.searchHumanInFamily(family, name);
            if (human != null) view.print("Человек с таким именем уже существует в этой семье");
            else {
                model.addToFamily(globalHuman, family);
                view.print("Человек с таким именем найден вне этой семьи и добавлен в состав семьи");
            }
        }
        else {
            Calendar birthDate = parseDate(birthDateString);
            Calendar deathDate = parseDate(deathDateString);
            human = new Human(name, Gender.fromString(genderName), birthDate, deathDate);
            model.addToFamily(human, family);
            view.print(String.format("Человек '%s' создан\n", name));
        }
    }
    public List<String> getConnectionNames() {
        List<String> result = new ArrayList<>();
        for (Connection connection : model.getConnections()) {
            result.add(connection.toString());
        }
        return result;
    }
    public Human searchHumanByNameInFamily(String name, Family<Human> family) {
        return model.searchHumanInFamily(family, name);
    }
    public void addConnection(Human h1, String connectionName, Human h2) {
        model.addConnection(h1, Connection.fromString(connectionName), h2);
        view.print("Связь создана");
    }
}
