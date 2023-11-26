package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.service.Service;
import family_tree.view.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
        view.setPresenter(this);
    }

    public void addHuman(String name,Gender gender, LocalDate birth, LocalDate death, Object parentM, Object parentF){
        service.addHuman(name,gender, birth, death,parentM,parentF);
        System.out.println("\nНовый член семейного дерева успешно добавлен.\n");
        printFamilyTree();
    }

    public void sortByName(){
        service.sortByName();
        System.out.println("Выполнена сортировка по имени.\n");
        printFamilyTree();
    }

    public void sortByAge(){
        service.sortByAge();
        System.out.println("Выполнена сортировка по возрасту.\n");
        printFamilyTree();
    }
    public void printFamilyTree() {
        String answer = service.printFamilyTree();
        view.answer(answer);
    }

    public void loadFamilyTree(){
        service.loadFamilyTree();
        printFamilyTree();
    }

    public void saveFamilyTree(){
        service.saveFamilyTree();
        System.out.println("Файл успешно записан.\n");
    }

    public void addParentGlobal(long human_id, long parent_id){
        service.addParentGlobal(human_id,parent_id);
        System.out.println("Родитель успешно добавлен.\n");
        printFamilyTree();
    }
}
