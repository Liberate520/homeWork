package lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phones {
    private Map<String, List<String>> map;
    ArrayList<String> phones;

    public Phones() {
        map = new HashMap<String, List<String>>();
    }

    public void add(String key, String value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public void printPerson(String name) {
        for (String key : map.keySet()) {
            if (key.equals(name)) {
                System.out.println(name + " - " + map.get(key).toString().replaceAll("^\\[|\\]$", ""));
            }
        }
    }
    public void printAll() {
        for (String key: map.keySet()) {
            String keys = key.toString();
            String value = map.get(key).toString();
            System.out.println(keys + " - " + value.toString().replaceAll("^\\[|\\]$", ""));
        }
    }
}
