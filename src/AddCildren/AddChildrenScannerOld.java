package AddCildren;

import Homework_6.Designer_Human;
import Print.IPrintList;
import Print.PrintList;

public class AddChildrenScannerOld implements IAddCildren{
    Designer_Human designer_human;
    @Override
    public void addCildren() {
        IPrintList printList = new PrintList();
        System.out.println("Кто твои родители ?");
        printList.printList(designer_human.getDesigner_human());

        StringBuilder Child = new StringBuilder();
        if (designer_human.getChildren() != null) {

            Child.append(designer_human.getName());
            for (Designer_Human c : designer_human.getChildren()) {
                Child.append(c.getName());
            }
        } else {
            Child.append("null");
        }
    }
}
