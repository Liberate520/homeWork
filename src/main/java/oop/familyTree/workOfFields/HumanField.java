package oop.familyTree.workOfFields;

import oop.familyTree.human.Human;
import oop.familyTree.mvp.model.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class HumanField  {
    Service service = new Service();
    public List<String> getListFields(String treeName, String fullName){
        List<String> list = new ArrayList<>();

        Human human = service.getFamilyTree(treeName).getHumanByFullName(fullName);
        Field[] fields = human.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("SerialVersionUID")
                    && !field.getName().equals("spouse")
                    && !field.getName().equals("children"))
            {
                list.add(field.getName());
            }
        }
        return list;
    }

    public boolean checkingNumField(Integer numField){
        String str = numField.toString();
        return str.matches("[0-9]+");
    }

    public Human changeField(String treeName, String fullName, int numField, String newValue){
        return service.getFamilyTree(treeName).getHumanByFullName(fullName);
    }
}
