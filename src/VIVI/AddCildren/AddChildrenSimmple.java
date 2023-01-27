package VIVI.AddCildren;

import Homework_6.Designer_Human;

public class AddChildrenSimmple implements IAddCildren{
    Designer_Human designer_human;
    @Override
    public void addCildren() {
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
