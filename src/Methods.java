import java.util.ArrayList;

public class Methods {
    ArrayList<Connect> tree;

    public Methods(TreeFamily geoTree) {
        tree = geoTree.getTree();
    }

    /***
     * Метод для поиска детей или мужа\жены
     */
    public void findKidsWifeOrHus(Human h1, Communication communication) {
        for (Connect i : tree) {
            if (i.first.getName().equals(h1.getName()) && i.communication == communication) {
                System.out.println(i.second.getName());
            }
        }
    }

    /***
     * Метод для поиска мамы или папы
     */
    public void findMomOrDad(Human h1, Communication communication) {
        for (Connect i : tree) {
            if (i.second.getName().equals(h1.getName()) && i.communication == communication) {
                System.out.println(i.first.getName());
            }
        }
    }

    /***
     * Метод для рассчета сколько было родителю, когда родился ребенок
     */
    public void ageDiff(Human h1, Communication communication) {
        for (Connect i : tree) {
            if (i.second.getName().equals(h1.getName()) && i.communication == communication) {
                System.out.println(i.first.getAge() - i.second.getAge());
            }
        }
    }

}