import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FamilyTree {
    private HashMap<Integer, Human> humans;
    private ArrayList<Relation> relations;
    private int id_counter;

    public FamilyTree() {
        humans = new HashMap<>();
        relations = new ArrayList<>();
        id_counter = 0;
    }

    //Сохранение дерева в файл
    public void save(String file_path) {
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(file_path))) {
            ds.writeInt(humans.size());
            for (Human it : humans.values()) {
                it.save(ds);
            }
            ds.writeInt(relations.size());
            for (Relation it : relations) {
                it.save(ds);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Загрузка дерева из файла
    public void load(String file_path) {
        try (DataInputStream ds = new DataInputStream(new FileInputStream(file_path))) {
            humans.clear();
            relations.clear();
            int count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Human human = new Human(0);
                human.load(ds);
                humans.put(human.getId(), human);
            }

            count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Relation relation = new Relation(0, 0, Relation.Node.CHILD);
                relation.load(ds);
                relations.add(relation);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Добавление человека
    public Human addHuman(String name, String surname) {
        //Получение уникального id
        while (humans.containsKey(id_counter))
            id_counter++;
        Human human = new Human(id_counter, name, surname);
        humans.put(id_counter, human);
        return human;
    }

    public Human getHuman(int id) {
        if (humans.containsKey(id) == false)
            return null;
        return humans.get(id);
    }

    //Cписок людей
    public Collection<Human> getHumans() {
        return humans.values();
    }

    //Добавление связи
    public boolean addRelation(Relation relation) {
        for (Relation it : relations) {
            if (it.equals(relation))
                return true;
            if (it.getId1() == relation.getId1() && it.getId2() == relation.getId2())
                return false; // уже есть связь
            if (it.getId1() == relation.getId2() && it.getId2() == relation.getId1())
                return false; // уже есть связь
        }
        relations.add(relation);
        return true;
    }

    //Список связей людей
    public ArrayList<Relation> getRelations() {
        return (ArrayList<Relation>) relations.clone();
    }
}
