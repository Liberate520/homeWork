package Tree.homeWork.src;

import Tree.homeWork.src.FamilyTreeGroup.FamilyTree;
import Tree.homeWork.src.HumanGroup.Human;
import Tree.homeWork.src.Presenter.Presenter;
import Tree.homeWork.src.model.Service;
import Tree.homeWork.src.ui.Console;
import Tree.homeWork.src.ui.View;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
//        ------------------------------------------------для работы с файлом:
        // String filePath = "Tree.homeWork/src/tree.txt";
        // WriteTo writeTo = new ToFile();
        // FamilyTree familyTree = new FamilyTree();
        // следующая строка с преобразованием для вывода инфо из файла (комментировать или предыдующую строку,
        // с добавлением людей и writeTo/ или следующую)
        //FamilyTree familyTree = (FamilyTree) writeTo.read(filePath);  // для чтения
        // writeTo.write(familyTree, filePath);    // для записи
        //---------------------------------------------------------
        //часть для работы с пользователем
        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);
        view.start();
        //---------------------------------------------------------
        System.out.println(familyTree.getHumanList());
        service.sortByName();
        System.out.println(familyTree.getHumanList());
        service.sortByAge();
        System.out.println(familyTree.getHumanList());
    }
}
