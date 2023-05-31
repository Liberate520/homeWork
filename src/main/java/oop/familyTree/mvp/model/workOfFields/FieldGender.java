package oop.familyTree.mvp.model.workOfFields;

import oop.familyTree.mvp.model.human.Human;

import java.lang.reflect.Field;
import java.util.List;

public class FieldGender extends HumanField{

    @Override
    public Human changeField(String treeName, String fullName, int numField, String newValue){
        List<String> list = this.getListFields(treeName, fullName);
        Human human = service.getFamilyTree(treeName).getHumanByFullName(fullName);
        Field newField;
        if (this.checkingNumField(numField)){
            if (numField <= list.size()){
                try {
                    newField = human.getClass().getDeclaredField(list.get(numField - 1));
                    newField.setAccessible(true);
                    newField.set(human, human.setGender(newValue));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return human;
    }
}
