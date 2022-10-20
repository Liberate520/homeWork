import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Names {
    private Map<String, Integer> map;
    private TreeMap<Integer, String> sort;
    ArrayList<String> phones;
    Integer counter;
    String name;

    public Names() {
        map = new HashMap<String, Integer>();
    }

    public void add(String key) {
        name = key.split(" ")[0];
        if (map.containsKey(name)) {
            counter = map.get(name) + 1;

            map.put(name, counter);
        } else {
            map.put(name, 1);

        }
    }

    public void printPersons() {

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                // counter = map.get(key);
                // System.out.println(key);
                // sort.put(counter, key); //не получается переложить в TreeMap и там
                // отсортировать
                // я понимаю что это костыль, но как изначально создать TreeMap я не поняла
                System.out.printf("%s: %d\n", key, map.get(key));
            }
        }
        //

    }
}
