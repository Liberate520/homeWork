import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
 
// Program to count the frequency of the elements in a list
class Main
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");
 
        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
 
        for (Map.Entry<String, Long> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}