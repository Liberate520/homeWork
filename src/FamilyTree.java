import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree<T extends Human> {
    private Map<String, T> humanMap;
    private Writable<T>  writable;

    public FamilyTree(Map<String, T> humanMap) {
        this.humanMap = humanMap;
    }

    public FamilyTree() {
        this(new HashMap<>());
    }

    public void addHuman(T human) {
        humanMap.put(human.getUuid(), human);
    }

    public T getHumanByUuid(String uuid) {
        return humanMap.get(uuid);
    }

    public List<T> serchHumanByFio(String fio) {
        List<T> res = new ArrayList<>();

        String[] fioList = fio.split(" ");

        humanMap.forEach((k, v) -> {
            String[] fioHuman = v.getFIOtoString().split(" ");
            int count = 0;
            for (String f : fioHuman) {
                for (String n : fioList) {
                    if (f.toUpperCase().equals(n.toUpperCase())) {
                        count++;
                    }
                }
            }

            if (count == fioList.length) {
                res.add(v);
            }
        });

        return res;
    }

    public T removeHumanByUuid(String uuid) {
        return humanMap.remove(uuid);
    }

    public void setHumanList(Map<String, T> humanMap) {
        this.humanMap = humanMap;
    }

    public List<T> getHumanList() {
        List<T> objList = new ArrayList<>();
            this.humanMap.forEach((id, x) -> objList.add(x));
        return objList;
    }

    public void save() {
        if (writable != null && this.humanMap != null){
            writable.save(this.getHumanList());
        }
    }

    public void read() {
        if (writable != null) {
            List<T> objList = writable.read();
            for (T obj : objList) {
                humanMap.put(((T) obj).getUuid(),(T) obj);
            }
        }
    }

    public void setWritable(Writable<T> writable) {
        this.writable = writable;
    }

    public Map<String, T> getHumanMap() {
        return humanMap;
    }
}
