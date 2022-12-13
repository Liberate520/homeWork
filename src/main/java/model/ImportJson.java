package model;
import org.json.simple.JSONArray;
import org.json.JSONException;

/**
 * интерфейс для создания файла формата json
 */

public interface ImportJson <T> {
    void writeTextJson(T fam, JSONArray ar) throws JSONException;
    void writeFileJson(String path, JSONArray ar);
}
