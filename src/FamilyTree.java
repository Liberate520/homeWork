import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<String, Human> humanMap;

    public FamilyTree(Map<String, Human> humanMap) {
        this.humanMap = humanMap;
    }

    public FamilyTree() {
        this(new HashMap<>());
    }

    public void addHuman(Human human) {
        humanMap.put(human.getUuid(), human);
    }

    public Human getHumanByUuid(String uuid) {
        return humanMap.get(uuid);
    }

    public List<Human> serchHumanByFio(String fio) {
        List<Human> res = new ArrayList<>();

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

    public Human removeHumanByUuid(String uuid) {
        return humanMap.remove(uuid);
    }

    public void setHumanList(Map<String, Human> humanMap) {
        this.humanMap = humanMap;
    }
}
