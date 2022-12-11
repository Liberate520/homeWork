package model;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
 * класс для записи семейного древо в файл json
 */
public class ImportJsonFamilyTree implements ImportJson<Person>{
    private Family fam;
    private  JSONArray ar = new JSONArray();

    public ImportJsonFamilyTree(Family fam) throws JSONException {
        this.fam = fam;
    }

    public JSONArray getAr() {
        return ar;
    }

    @Override
    public void writeTextJson(Person fam, JSONArray ar) throws JSONException {
        if (fam.getMyparent() == null) {
            JSONObject obgJson = new JSONObject();
            obgJson.put("parent-name", "вершина древа");
            obgJson.put("children - name", fam.getMyname());
            ar.add(obgJson);
        }
        if (fam.getMyChildren() != null) {
            for (Person p : fam.getMyChildren()) {
                JSONObject obgJson = new JSONObject();
                obgJson.put("parent-name", p.getMyparent().getMyname());
                obgJson.put("children - name", p.getMyname());
                ar.add(obgJson);
                writeTextJson(p, ar);
            }
        }
    }
    @Override
    public void writeFileJson(String path, JSONArray ar) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(ar.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

