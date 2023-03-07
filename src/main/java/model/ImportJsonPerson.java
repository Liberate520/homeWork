package model;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * класс для записи введенной строки в файл json
 */
public class ImportJsonPerson implements ImportJson<Person> {
    private Person person;


    public ImportJsonPerson(Person person) throws JSONException {
        this.person = person;
    }

    @Override
    public JSONObject writeTextJson(Person person) throws JSONException {
        JSONObject obgJson = new JSONObject();
        obgJson.put("Фамилия", person.getFirstname());
        obgJson.put("Имя", person.getName());
        obgJson.put("Отчество", person.getPatronymic());
        obgJson.put("Дата рождения", person.getBirthday());
        obgJson.put("Номер телефона", person.getPhoneNumber());
        obgJson.put("Пол", person.getFloor());
        return obgJson;
    }

    @Override
    public void writeFileJson(String namePath, JSONObject obgJson) throws IOException, ParseException {
        JSONArray ar = new JSONArray();
        if (findFiles(namePath)==true) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(namePath));
            JSONArray ar1 = (JSONArray) obj;
            for (int i = 0; i < ar1.size(); i++) {
                ar.add(ar1.get(i));
            }
        }
        ar.add(obgJson);
        try (FileWriter file = new FileWriter(namePath)) {
            file.write(ar.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean findFiles (String namePath) {
    File f = new File(".");
    String[] list = f.list();     //список файлов в текущей папке
    boolean b = false;
    for (String file : list) {      //проверка на совпадение
        if (namePath.equals(file)) {
            b = true;
            break;
        } else b = false;
     }
    return b;
    }
}


