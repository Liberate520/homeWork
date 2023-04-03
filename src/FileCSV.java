import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * FileCSV
 */
public class FileCSV implements Files {
    private String file_name;

    FileCSV(String file_name) {
        this.file_name = file_name;
    }

    FileCSV() {
        this("bd.csv");
    }

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

    @Override
    public Map<Integer, Person> readFile() {
        Map<Integer, Person> p_list = new HashMap<>();

        String bd_file = new File(file_name).getAbsolutePath();
        if (fileExist(bd_file) == false) {
            return p_list;
        }

        try {
            FileReader fr = new FileReader(bd_file);
            Scanner fscan = new Scanner(fr);
            // Читаем название cтолбцов из csv файла
            String line = fscan.nextLine().trim().replaceAll("\n", "");
            String[] fields = convertLineToArray(line);

            // Производим чтение данных и заполняем массив нашей базы, данными типа HashMap
            while (fscan.hasNextLine()) {
                line = fscan.nextLine().trim().replaceAll("\n", "");
                // Создаем массив HashMap со значениями из датасета
                // где ключи - имена столбцов
                LinkedHashMap<String, String> temp_map = new LinkedHashMap<>();
                String[] values = convertLineToArray(line);
                temp_map = arraysToMap(fields, values);

                int i = Integer.parseInt(temp_map.get("person_id"));
                Person pers = new Person(temp_map);
                p_list.put(i, pers);
            }
            fr.close();
            fscan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return p_list;
    }

    @Override
    public Boolean saveFile(String file_name, Tree family) {
        String bd_file = new File(file_name).getAbsolutePath();
        System.out.println("Сохраняем изменения в файл");

        String text = convertPersonslistToCSV(family);
        try {
            FileWriter writer = new FileWriter(bd_file, false);
            writer.write(text);
            writer.flush();
            writer.close();
            System.out.println("file "+ file_name + " saved!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private String convertPersonslistToCSV(Tree family) {
        LinkedHashSet<String> csv_fields_set = new LinkedHashSet<>();
        StringBuilder csv_fields = new StringBuilder();
        StringBuilder csv_text = new StringBuilder();

        for (Person pers : family) {
            String[] temp = pers.getFullInfoInText().split(",");
            for (String inf : temp) {
                String[] inf_arr = inf.split(":", 2);
                csv_fields_set.add(inf_arr[0]);
                csv_text.append(inf_arr[1] + ",");
            }
            csv_text.replace(csv_text.length() - 1, csv_text.length(), "\n");
        }

        for (String str : csv_fields_set) {
            csv_fields.append(str + ",");
        }
        csv_fields.replace(csv_fields.length() - 1, csv_fields.length(), "\n");

        return csv_fields.append(csv_text).toString();
    }

}