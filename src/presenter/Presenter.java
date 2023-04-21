package presenter;

import view.View;
import model.Service;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }


    public void addObject(String name, String family, String dateBirth, String father, String mother) {

        service.addNewHuman(name, family, dateBirth, father, mother);

        view.print("Объект добавлен");

    }


    /**
     * @treeView - метод получения всех объектов из файла(десериализация)
     */
    public void familyTreeViewAll() {

        view.print(service.printHumanList());
        //service.printListHuman();

    }

    public void searchHuman(String nameSearch) {

        view.print(service.searchHuman(nameSearch).getInfo());

    }

    public void sortHum(int num) {
        service.sortObjectHum(num);
    }


    public void readObjFromFile(int n) {

        if (n == 1) {
            view.print(service.readFile());
        } else {
            view.print("Отменено пользователем");
        }


    }

    public void saveObj(int h) {

        if (h == 1) {

            service.saveInFile();
            view.print("Объекы сохранены");

        } else {
            view.print("Объекы не сохранены");
        }

    }

}
