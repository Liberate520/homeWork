package lesson5;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

    public class Names {
        private Map<String, Integer> map;
    
        public Names() {
            map = new HashMap<String, Integer>();
        }
    
        public void add(String key) {
            String name = key.split(" ")[0];
            if (map.containsKey(name)) {
                Integer counter = map.get(name) + 1;
                map.put(name, counter);
            } else {
                map.put(name, 1);
            }
        }

        private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap){
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> entry : list)
            {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            return sortedMap;
        }
        public void printPersons() {
            for (String key: sortByValue(map).keySet()){  
                System.out.println(map.get(key) + " = " + key);
            }
        }
}
