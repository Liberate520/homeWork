package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import fileProcessing.FileHandler;
import fileProcessing.Readable;
import fileProcessing.Writeable;

// В проекте с гениалогическим древом подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла. 
// Для этого создать отдельный класс и реализовать в нем нужные методы. 
// Для данного класса сделайте интерфейс, который и используйте в своей программе. 
// Например в классе дерева в качестве аргумента метода save передавайте не конкретный класс, 
// а объект интерфейса, с помощью которого и будет происходить запись. 
// Пример работы с интерфейсом Serialazable можно найти в материалах к уроку

public class FamilyTree {
    private Integer generation;
    private HashMap<Integer, String> humans_index_by_generation;
    private ArrayList<Human> humans_list;

    public FamilyTree(Integer generation, HashMap<Integer, String> humans_index_by_generation, ArrayList<Human> humans_list) {
        this.generation = generation;
        this.humans_index_by_generation = humans_index_by_generation;
        this.humans_list = humans_list;
    }

    public FamilyTree() {
        this.generation = 1;
        this.humans_index_by_generation = new HashMap<>();
        this.humans_list = new ArrayList<>();
    }

    public Integer getGeneration() {
        return generation;
    }

    private void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public HashMap<Integer, String> getHumansIndexByGeneration() {
        return humans_index_by_generation;
    }
    
    public ArrayList<Human> getHumansList() {
        return humans_list;
    }
    private Integer getGen(Integer index) {
        for (int i = humans_index_by_generation.size(); i > 0; i--) {
            if (humans_index_by_generation.get(i).contains(Integer.toString(index))) return i;
        }
        return index;
    }

    public Human getHuman(String human_name) {
        for (int i = 0; i < humans_list.size(); i++) {
            if (humans_list.get(i).getName().equalsIgnoreCase(human_name)) return humans_list.get(i);
        }
        return null;
    }

    public void add(Human human) {
        this.humans_list.add(human);
        if (human.getFather() != null | human.getMother() != null) {
            Integer stop = 0;
            for (int i = humans_list.size() - 2; i >= 0; i--) {
                if (humans_list.get(i).equals(human.getFather())) {
                    humans_list.get(i).addChild(human);
                    setGeneration(getGen(i) + 1);
                    stop += 1;
                }
                if (humans_list.get(i).equals(human.getMother())) {
                    humans_list.get(i).addChild(human);
                    setGeneration(getGen(i) + 1);
                    stop += 1;
                }
                if (stop == 2) break;
            }
        }
        String humans_index_in_generation = humans_index_by_generation.get(getGeneration());
        if (humans_index_in_generation == null) humans_index_in_generation = "";
        this.humans_index_by_generation.put(getGeneration(), humans_index_in_generation + Integer.toString(humans_list.size() - 1));
    }

    public String getTree() {
        String result = "";
        for (int i = 0; i < humans_list.size(); i++) {
            result += getInfoHuman(humans_list.get(i).getName()) + "\n";
        }
        return result;
    }

    public String getInfoHuman(String name_human) {
        for (int i = 0; i < humans_list.size(); i++) {
            if (humans_list.get(i).getName().equalsIgnoreCase(name_human)) {
                return Integer.toString(getGen(i)) + " поколение - " + humans_list.get(i).toString();
            }
        }
        return "Неизвестное имя";
    }

    public String getInfoChildren(String name_human) {
        String result = "";
        for (int i = 0; i < getHuman(name_human).getChildren().size(); i++) {
            result += getInfoHuman(getHuman(name_human).getChildren().get(i).getName()) + "\n";
        }
        return result;
    }

    public String getInfoMother(String name_human) {
        return getInfoHuman(getHuman(name_human).getMother().getName());
    }

    public String getInfoFather(String name_human) {
        return getInfoHuman(getHuman(name_human).getFather().getName());
    }

    public void save(String file_name, Writeable format_write) throws IOException {
        FileHandler file_handler = new FileHandler();
        file_handler.write(format_write, file_name, getHumansIndexByGeneration(), getHumansList());
    }

    public FamilyTree open(String file_name, Readable format_read) throws IOException {
        FileHandler file_handler = new FileHandler();
        return file_handler.read(format_read, file_name);
    }
}