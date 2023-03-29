import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * FileCSV
 */
public class FileCSV {

    private Map<Integer, LinkedHashMap<String, String>> bd_tree = new LinkedHashMap<>();

    private Boolean fileExist(String file_name) {
        File file = new File(file_name);
        return file.exists();
    }

    private String[] convertLineToArray(String line) {
        line = line.replaceAll("\"", "");
        return line.split(",");
    }

    private LinkedHashMap<String, String> arraysToMap(String[] fields, String[] values) {
        LinkedHashMap<String, String> temp_map = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            if (values.length > i) {
                temp_map.put(fields[i], values[i]);
            } else {
                temp_map.put(fields[i], "");
            }
        }
        return temp_map;
    }

    public Map<Integer, LinkedHashMap<String, String>> readFile(String file_name) {
        String bd_file = new File(file_name).getAbsolutePath();
        if (fileExist(bd_file) == false) {
            return this.bd_tree;
        }
        int i = 0;
        String line;
        String[] values;
        try {
            FileReader fr = new FileReader(bd_file);
            Scanner fscan = new Scanner(fr);
            // Читаем название cтолбцов из csv файла
            line = fscan.nextLine().trim().replaceAll("\n", "");
            String[] fields = convertLineToArray(line);

            // Производим чтение данных и заполняем массив нашей базы, данными типа HashMap
            while (fscan.hasNextLine()) {
                line = fscan.nextLine().trim().replaceAll("\n", "");
                // Создаем массив HashMap со значениями из датасета
                // где ключи - имена столбцов
                LinkedHashMap<String, String> temp_map = new LinkedHashMap<>();
                values = convertLineToArray(line);
                temp_map = arraysToMap(fields, values);
                // Наполняем базу данных
                i = Integer.parseInt(temp_map.get("person_id"));
                this.bd_tree.put(i, temp_map);
            }
            // System.out.println(bd_laptop);
            fr.close();
            fscan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.bd_tree;

    }

    public Boolean saveFile(String file_name) {
        String bd_file = new File(file_name).getAbsolutePath();
        System.out.println("Сохраняем изменения в файл");

        String text = convertMapToTxt();

        try {
            FileWriter writer = new FileWriter(bd_file, false);
            writer.write(text);
            writer.flush();
            writer.close();
            System.out.println("file saved!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private String convertMapToTxt() {
        StringBuilder csv_text = new StringBuilder();
        StringBuilder csv_fields = new StringBuilder();
        LinkedHashSet<String> csv_fields_set = new LinkedHashSet<>();

        for (Map.Entry<Integer, LinkedHashMap<String, String>> bd_item : this.bd_tree.entrySet()) {

            for (Map.Entry<String, String> pers_inf : bd_item.getValue().entrySet()) {
                csv_fields_set.add(pers_inf.getKey());
                csv_text.append(pers_inf.getValue() + ",");
            }
            csv_text.replace(csv_text.length() - 1, csv_text.length(), "");
            csv_text.append("\n");
        }

        for (String fields : csv_fields_set) {
            csv_fields.append(fields + ",");
        }
        csv_fields.replace(csv_fields.length() - 1, csv_fields.length(), "");

        return csv_fields.append("\n" + csv_text).toString();
    }

    public void convertPersonslistToMap(Map<Integer,Person> persons_list){
        this.bd_tree.clear();
        for (Map.Entry<Integer,Person> items : persons_list.entrySet()) {
            LinkedHashMap<String, String> temp_map = new LinkedHashMap<>();
            temp_map.put("person_id", Integer.toString(items.getValue().getPerson_id()));
            temp_map.put("person_name", items.getValue().getPerson_name());

            temp_map.put("person_sex", items.getValue().getPerson_sex());

            String dob = "";
            if (items.getValue().getPerson_birthday()!=null)
                dob =  items.getValue().getPersonBirthdayString();
            temp_map.put("person_birthday",dob);
            
            String dod = "";
            if (items.getValue().getPerson_death()!=null)
                dod = items.getValue().getPersonDeathString();
            temp_map.put("person_death", dod);
            
            String m_id = "";
            if (items.getValue().getMother()!=null)
                m_id = Integer.toString( items.getValue().getMother().getPerson_id());
            temp_map.put("mother_id", m_id);

            String d_id = "";
            if (items.getValue().getFather()!=null)
                d_id = Integer.toString( items.getValue().getFather().getPerson_id());
            temp_map.put("father_id", d_id);

            int i = 0;
            for (Person child : items.getValue().getPerson_childs()) {
                i++;
                temp_map.put("child"+i,Integer.toString(child.getPerson_id()));
            }
            
            this.bd_tree.put(items.getKey(), temp_map);
        }
    }

}