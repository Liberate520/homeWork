package AddParents;

import Homework_6.Designer_Human;

public class AddParentsOld implements IAddParents{
    @Override
    public void addParents() {
        Designer_Human designer_Human = new Designer_Human();
        if (designer_Human.getFather()!= null) {
            designer_Human.setFather(designer_Human.getFather());
        }
        if (designer_Human.getMother() != null) {
            designer_Human.setMother(designer_Human.getMother());
        }
    }
}
