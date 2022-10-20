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
        TreeMap<Integer, String> sort = new TreeMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                int counter = map.get(key);
                sort.put(counter, key);
                System.out.printf("%s: %d\n", key, map.get(key));
            }
        }
        //

    }
}
