package dzseer2.tree;

import dzseer2.human.Gender_sex;
import dzseer2.human.Gender_type;
import dzseer2.human.Human;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class FamilyTree implements Serializable {
    private List<Human> humanFamilyList;
    public FamilyTree() throws IOException {this.humanFamilyList = new ArrayList<>();}
    public List<Human> getHumanFamilyList() {
        return humanFamilyList;
    }
    public List<Human> familyCollection(List<Human> humanList) {
        int tempman = 0;
        for (Human humanMan : humanList) {
            if ((humanMan.getMarriage_certificate())!= 0 && humanMan.getGender_sex().equals(Gender_sex.мужчина)) {
                tempman = humanMan.getMarriage_certificate();
                humanFamilyList.add(humanMan);
            }
        }
        for (Human humanwoman : humanList) {
            if ((humanwoman.getMarriage_certificate())!= 0 && humanwoman.getGender_sex().equals(Gender_sex.женщина) &&
                    humanwoman.getMarriage_certificate() == tempman) {
                humanFamilyList.add(humanwoman);
                for (Human humanchild : humanList) {
                    if (Gender_type.Мама.equals(humanchild.getGender_type()) &&
                            humanchild.getName_key().equals(humanwoman.getName())){
                        humanFamilyList.add(humanchild);
                    }
                }
            }
        }
        return humanFamilyList;
    }

    public List<Human> getSearchForChildren(List<Human> humanFamilyList){
        List<Human> searchForChild = new ArrayList<>();
        for (Human searchChild : humanFamilyList) {
            if(searchChild.getMarriage_certificate()== 0){
                searchForChild.add(searchChild);
            }
        }
        return searchForChild;
    }

    public List<Human> getSearchForParents(List<Human> humanFamilyList){
        List<Human> searchForParent = new ArrayList<>();
        for (Human searchParent : humanFamilyList) {
            if(searchParent.getMarriage_certificate()!= 0){
                searchForParent.add(searchParent);
            }
        }
        return searchForParent;
    }
}