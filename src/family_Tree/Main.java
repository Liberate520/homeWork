package family_Tree;

import family_Tree.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.generateTree();
        service.toPrint();
        service.sortByAge();
        service.toPrint();
//        service.save();
//        service.load();
//        service.toPrint();
    }
}
