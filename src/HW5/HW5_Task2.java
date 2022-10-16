package HW5;

import java.util.*;

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



        private static Map<String, Integer> sortByValue(HashMap<String, Integer> unsortedMap){


                List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }///IDE сама предложина таким способом перегрузить метод
                });

                Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
                for (Map.Entry<String, Integer> entry : list)
                {
                    sortedMap.put(entry.getKey(), entry.getValue());
                }

                return sortedMap;
    }

    public static void main(String[] args) {
        String [] employes = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
                              "Иван Юрин","Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                              "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                              "Иван Мечников", "Петр Петин", "Иван Ежов"};
        String [] names = splitNames(employes);
        var namesCount = findDuplicates(names);
        System.out.println(namesCount);
        System.out.println();
        System.out.println(sortByValue(namesCount));


    }

}
