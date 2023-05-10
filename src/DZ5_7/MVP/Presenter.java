package DZ5_7.MVP;

import DZ5_7.Models.Human;
import DZ5_7.Models.TypeGender;
import DZ5_7.Structure.FamilyTree;
import DZ5_7.Models.TypeCommunication;

public class Presenter<T> {
    private Model model;
    private View view;

    public Presenter(View view) {
        this.view = view;
        model = new Model<T>();
    }

    public void loadFromFile() {
        model.load();
    }

    public void saveToFile() {
        model.save();
    }

    public Human create() {
        System.out.println("Введите имя: ");
        String name = view.createData();
        System.out.println("Выберите пол: ");
        TypeGender gender = view.createGender();
        return new Human(name, gender);
    }

    public void addCommunication() {
        System.out.println("Выберите человека для которого хотите добавить человека с род. связью: ");
        Human human1 = getHuman();
        if(human1 == null) {
            return;
        }
        System.out.println("Выберите человека которого хотите добавить: ");
        Human human2 = getHuman();
        if(human2 == null) {
            return;
        }
        TypeCommunication typeCommunication = view.createTypeCommunication();
        human1.addCommunication(human2, typeCommunication);
    }

    public void add(T t) {
        model.familyTree.add(t);
    }

    public void del(T t) {
        if (t == null){
            return;
        }
        model.familyTree.del(t);
    }

    public Human getHuman() {
        Integer max = Integer.valueOf(model.familyTree.getList().size());
        System.out.println("Введите номер человека: ");
        Integer num = Integer.valueOf(view.createData());
        if (num > max || num < 0 || max < 1) {
            System.out.println("Ошибка. Операция прервана.");
            return null;
        }
        return ((Human) model.familyTree.getList().get(num - 1));
    }

    public void find(T t) {
        model.familyTree().find(t);
    }

    public void find() {
        System.out.println("Введите имя искомого человека: ");
        String name = view.createData();
        model.familyTree.find(name);
    }

    public void viewFamilyTree() {
        view.print(model.familyTree);
    }

}