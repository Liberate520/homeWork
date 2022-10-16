package HW5;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HW5_Task2 {


    private static String [] splitNames(String[] fullNamesArray){
        String [] names = new String[fullNamesArray.length];

        for (int i = 0; i < fullNamesArray.length; i++) {
            String [] nameArray = fullNamesArray[i].split(" ");
            names [i] = nameArray[0];
        }
        return names;
    }
    private static HashMap<String, Integer> findDuplicates(String[] namesArray){
        HashMap<String, Integer> map = new HashMap<>();
        for (String name: namesArray) {
            if (map.get(name)==null)
                map.put(name,1);
            else
                map.put(name, map.get(name)+1);
        }
        return map;
    }
    public static void main(String[] args) {
        String [] employes = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
                              "Иван Юрин","Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                              "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                              "Иван Мечников", "Петр Петин", "Иван Ежов"};
        String [] names = splitNames(employes);
        var namesCount = findDuplicates(names);
        System.out.println(namesCount);
    }
}
