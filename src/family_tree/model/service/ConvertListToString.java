package family_tree.model.service;

import java.util.Formatter;
import java.util.List;

public class ConvertListToString<E> {
    public String convert(List<E> list) {
        Formatter formatter = new Formatter();
        formatter.format("%s  %-7s       %s             %s          %s   %s   %s   %s  %s",
                "id", "Фамилия", "Имя", "Отчество", "Пол", "Возраст", "Дата рождения", "Дата смерти", "Родители(id)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        for (E element : list) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }
}
