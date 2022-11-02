import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public void printPersons() {
        TreeMap<Integer, ArrayList<String>> sort = new TreeMap<>();

        for (String key : map.keySet()) {
            int counter = map.get(key);
            if (sort.containsKey(counter)) {
                ArrayList<String> names = sort.get(counter);
                names.add(key);
            } else {
                ArrayList<String> names = new ArrayList<>();
                names.add(key);
                sort.put(counter, names);
            }
        }
        System.out.println(sort);
    }
}
