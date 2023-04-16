package model;

import model.TreeFamily.TreeFamily;
import model.human.Human;
import model.human.HumanComporatorByName;

import java.util.Collections;

public class Service implements Service1{
//    private int id;
    private final TreeFamily<Human> tree;

    public Service(TreeFamily<Human> tree) {
        this.tree = tree;
    }

    public TreeFamily<Human> getTree() {
        return tree;
    }

    @Override
    public void addHuman(String family, String name){
        tree.addHuman(new Human(family, name));

    }

//    public void sortByName(){
//        group.getStudentList().sort(new StudentComparatorByName());
//    }
//
//    public void sortById(){
//        group.getStudentList().sort(new StudentComparatorById());
//    }
    public void sortByFamily(){
        //tree.getList().sort();
        Collections.sort(tree.getList());


    }
    public void sortByName(){
        tree.getList().sort(new HumanComporatorByName());
        //Collections.sort(tree.getList(), new model.human.HumanComporatorByName());

    }
//    public void save(Writable writable) throws IOException {
//        writable.save(this);
//
//    }
  //  private static final String EMPTY_ERROR = "Вы не заполнили поле";

//    @Override
//    public String getName(String name) {
//        if (name.equals("")) {
//            return EMPTY_ERROR + " Имя!";
//        }
//        try {
//            String nameInput = connection.getInfo(name);
//            return nameInput;
//        } catch (NullPointerException e) {
//            return "Некорректный ввод!";
//        }
//    }

//    @Override
//    public String getFamily(String family) {
//        if (family.equals("")) {
//            return EMPTY_ERROR + " фамилия!";
//        }
//        try {
//            String nameInput = connection.getInfo(family);
//            return nameInput;
//        } catch (NullPointerException e) {
//            return "Некорректный ввод!";
//        }
//    }



}
