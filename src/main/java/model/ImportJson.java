package model;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * интерфейс для создания файла формата json
 */

public interface ImportJson <T> {
    JSONObject writeTextJson(T person) throws JSONException; //создание объекта Json
    void writeFileJson(String namePath, JSONObject obgJson) throws IOException, ParseException; //запись в файл
    boolean findFiles(String namePath); //метод проверки наличия файла с таким именем
}
