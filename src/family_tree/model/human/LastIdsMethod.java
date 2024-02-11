package family_tree.model.human;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LastIdsMethod {
    public static int getLastId() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        int lineCount = 0;
        int lastId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount % 10 == 0) { // Читаем каждую 9 строку файла со значением id
                    String ids = line.substring(4); // Выделяем номер id после записи "id: "
//                    System.out.println(ids);
                    int id = Integer.parseInt(ids);
                    lastId = Math.max(lastId, id);
                }
            }
        } catch (IOException e) {
//            System.err.println("Ошибка чтения файла (" + filePath +") : " + e.getMessage());
            // Если файл не существует, id начинается с идентификатора 1
        }
        return lastId;
    }

//    public static void main(String[] args) {
//        getLastId();
//    }

}


