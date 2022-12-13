package presenter;
import model.*;
import org.json.JSONException;
import view.ConsoleTerminal;

/**
 * класс презентер, для взаимодействия view и model(family)
 */
public class Controller{
    private Family fam = null;
    private ConsoleTerminal view;

    public Controller(ConsoleTerminal view){
        this.view = view;
        view.setController(this);
        this.fam = newFamily();
    }
    public Family getFam(){
        return fam;
    }
    public void onClick() throws JSONException {
        while (true) {
            switch (view.printMenu("Меню: для печати нажмите - 1, для печати родителей нажмите - 2, для закрытия - 3, для добавленя потомка - 4, для сохранения дерева в формате json - 5")) {
                case 1: //печать древа
                    view.printTree(fam.nowPerson);
                    break;
                case 2: //печать детей родителяы
                    view.printChildren(view.scanOne("Введите имя родителя"),fam.nowPerson);
                    break;
                case 3:
                    return;
                case 4:
                    String p = view.scanOne("Введите имя родителя: ");
                    String c = view.scanOther("Введите имя ребенка: ");
                    fam.addChild(p, c);
                    break;
                case 5:
                    ImportJsonFamilyTree im = new ImportJsonFamilyTree(fam);
                    im.writeTextJson(fam.nowPerson, im.getAr() );
                    im.writeFileJson("test.json", im.getAr());
                    view.printStr("Файл создан");
                    break;
                default:
                    view.printStr("Такой команды нет");
                    break;
            }
        }
    }
    public Family newFamily(){
        view.printStr("Приветствует мастер генеологического дерева");
        view.printStr("Создайте фамильное древо");
        String familyName = view.scanOther("Введите имя родителя : ");
        Family fam = new Family(familyName);
        view.printStr("Древо создано с родителем " + familyName);
        return fam;
    }
}
