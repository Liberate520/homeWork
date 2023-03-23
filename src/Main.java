import cmdui.FamilyTreeCmd;
import cmdui.commands.CommandFactory;
import familytree.serializer.FamilyTreeSerializer;
import familytree.service.FamilyTreeService;
import presenter.Presenter;

/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        try {
            var serializer = new FamilyTreeSerializer();
            var familyTreeService = new FamilyTreeService(serializer);
            var familyTree = familyTreeService.createFamilyTree();
            System.out.printf("Генеалогическое древо состоит из %d человек\n", familyTree.total());
            var view = new FamilyTreeCmd(new CommandFactory());
            var presenter = new Presenter(view, familyTreeService);
            view.run();
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }
}