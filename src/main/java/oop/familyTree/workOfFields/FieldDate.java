package oop.familyTree.workOfFields;

import oop.familyTree.human.Human;

import java.lang.reflect.Field;
import java.util.List;

public class FieldDate extends HumanField{

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
                    newField.set(human, human.setDate(newValue));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return human;
    }
}
