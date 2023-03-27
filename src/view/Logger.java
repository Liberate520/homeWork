package view;

import java.io.FileWriter;

public class Logger {
    // ПОЛЕ КЛАССА
    StringBuilder log_string = new StringBuilder();

    // МЕТОД КЛАССА - СОЗДАНИЕ ФАЙЛА С ДОБАВЛЕНИЕ СВЕДЕНИЙ О ДАТЕ И ВРЕМЕНИ УДАЛЕНИЯ ЗАПИСИ ИЗ ЗАПИСНОЙ КНИЖКИ
    public void log_file(StringBuilder log_string) {   // Математические действия запишем в файл Task_4.
        try (FileWriter our_writer = new FileWriter("TaskController.txt")) {
            our_writer.write(String.valueOf(log_string));
        } catch (Exception error) {
            System.out.println("Ошибка!");
        } finally {
            System.out.println("\nДанные об удалении записи добавлены в файл контроля.");
        }
    }
}