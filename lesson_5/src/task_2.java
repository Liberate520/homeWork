import java.util.Arrays;
import java.util.List;

import java.util.Iterator;

// Пусть дан список сотрудников:Иван Иванов, Светлана Петрова, Кристина Белова, 
// Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, 
// Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, 
// Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности. 
// Для сортировки можно использовать TreeMap
public class task_2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Иван Иванов", "Светлана Петрова",
                "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
                "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
                "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов");
        printNumOfRepeat(list);
    }

    public static void printNumOfRepeat(List<String> list) {
        Iterator<String> it = list.iterator();
        Integer length = list.size();
        Names names = new Names();
        for (int i = 0; i < length; i++) {
            names.add(it.next());
        }
        System.out.println(names.toString());
    }
}
