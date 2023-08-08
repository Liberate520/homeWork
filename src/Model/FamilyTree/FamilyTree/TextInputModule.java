package Model.FamilyTree.FamilyTree;

import java.util.HashMap;
import java.util.Map;

public class TextInputModule {
    private Map<String, String> map;

    public TextInputModule() {
        map = new HashMap<>();
        map.put("choice", "Выберите действие: ");
        map.put("input", "Введите значение: ");
        map.put("errorInput", "Неверный ввод.");
        map.put("farewell", "Досвидания!");
        map.put("setName", "Введите имя: ");
        map.put("setDate", "Укажите дату рождения: ");
        map.put("setGender", "Укажите пол человека: ");
        map.put("setStatus", "Укажите статус: ");
        map.put("errorSetAgain", "Неверно, укажите заново: ");
        map.put("setYear", "Укажите год: ");
        map.put("errorSetYear", "Неверный год, укажите заново: ");
        map.put("setMonth", "Укажите месяц: ");
        map.put("errorSetMonth", "Неверный месяц, укажите заново: ");
        map.put("setDay", "Укажите день: ");
        map.put("errorSetDay", "Неверный день, укажите заново: ");
        map.put("setId", "Введите id человека: ");
        map.put("errorSetId", "Такого человека нет: ");
        map.put("setParentsId", "Выберите id родителей: ");
        map.put("setChildId", "Укажите id ребёнка: ");
        map.put("setMotherId", "Укажите id матери: ");
        map.put("setFatherId", "Укажите id отца: ");
        map.put("setFirstSpouseId", "Укажите id первого партнёра: ");
        map.put("setSecondSpouseId", "Укажите id второго партнёра: ");
//        map.put("addSuccess", "Добавление прошло успешно.");
        map.put("noPeople", "Людей еще нет.");
//        map.put("noIdFound","Такого id нет.");
        map.put("errorSetChild", "Не удалось добавить ребёнка родителям.");
        map.put("errorSetParentsToChild", "Не удалось добавить родителей ребёнку.");
    }
    public String getAnswer(String choice) {
        return map.getOrDefault(choice, "default, change settings");
    }

    public void printInfo(String info) {
        System.out.println(info);
    }
}
