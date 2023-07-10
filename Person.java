import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Person {
    private Map<String,String> data = new HashMap<>();
    
    public Person(Map<String,String> data) {
        this.data.putAll(data);
    }

    public Person (String key, String value) {
        this.data.put(key, value);
    }

    public void addData (String key,String value) {
        this.data.put(key, value);
    }

    public void removeData (String key) {
        this.data.remove(key);
    }

    public void removeEmptyData() {
        for (String item : this.getDataKeys())
            if (this.getData(item) == null || this.getData(item) == "") 
                this.removeData(item);
    }

    public Set<String> getDataKeys() {
        return this.data.keySet();
    }

    public String getData(String key) {
        return this.data.getOrDefault(key,null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String item : this.getDataKeys())
            sb.append(String.format("%s : %s\n", item, this.getData(item)));
        return sb.toString();
    }
}
