import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class HW2 {
    private static final String filePath = "jsonString.json";

    public static void main(String[] args) {

//Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

//Используйте StringBuilder для подготовки ответа
//Создать метод, который запишет результат работы в файл
//Обработайте исключения и запишите ошибки в лог фай


        StringBuilder family = ex1();
        StringBuilder grade = new StringBuilder();
        StringBuilder subject = new StringBuilder();
        System.out.println("Студент " + family + "получил" + grade + " по предмету " + subject);
    }

        public static StringBuilder ex1() {
            StringBuilder family1 = null;
            try {
                FileReader reader;
                reader = new FileReader(filePath);

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

                family1 = (StringBuilder) jsonObject.get("фамилия");
                System.out.println("The first name is: " + family1);

//                String grade1 = (String) jsonObject.get("оценка");
//                System.out.println("Оценка: " + grade1);
//
//                String subject1 = (String) jsonObject.get("предмет");
//                System.out.println("Предмет: " + subject1);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
//            finally {
//                try {
//                    reader.close();
//                } catch (IOException ex){
//                    ex.printStackTrace();
//                }
            return family1;
        }
}