package faminly_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree implements Serializable {
   private List<Human> tree = new ArrayList<>();
   private int newID = 0;

    public void addToTree(Human human){
        tree.add(human);
        human.setId(newID);
        this.newID++;
    }

    //TODO
    /**
     * Показать всех родственников выбранного человека и степень родства
     * @param human
     */
    //public void allRelatives(Human human){
    //}

    /**
     * Показать ближайших родственников человека и степень родства
     * @param human
     */
    public String nextOfKin(Human human){
        StringBuilder sb = new StringBuilder();
        sb.append("Отец:\n");
        if (human.getFather() != null) sb.append(getHumanInfo(human.getFather()));
        else sb.append("неизвестен");
        sb.append("\n");
        sb.append("Мать:\n");
        if (human.getMother() != null) sb.append(getHumanInfo(human.getMother()));
        else sb.append("неизвестна");
        sb.append("\n");
        sb.append("Дети:\n");
        List<Human> commonChildren = human.getChildren();
        if (commonChildren == null) sb.append("отсутствуют или не указаны");
        else {
            for(Human el : commonChildren){
                sb.append(getHumanInfo(el));
                sb.append("\n");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
        if ((human.getMother() == null) && (human.getFather() != null)){
            List<Human> fatherChildren = human.getFather().getChildren();
            sb.append("Cестры (степень родства определить невозможно):\n");
            getFemale(sb, fatherChildren, human);
            sb.append("Братья (степень родства определить невозможно):\n");
            getMale(sb, fatherChildren, human);
        }
        else if ((human.getMother() != null) && (human.getFather() == null)){
            List<Human> motherChildren = human.getFather().getChildren();
            sb.append("Cестры (степень родства определить невозможно):\n");
            getFemale(sb, motherChildren, human);
            sb.append("Братья (степень родства определить невозможно):\n");
            getMale(sb, motherChildren, human);
        }
        else if ((human.getMother() != null) && (human.getFather() != null)) {
            List<Human> motherChildren = human.getMother().getChildren();
            List<Human> fatherChildren = human.getFather().getChildren();
            if ((motherChildren.size() == 1) || (fatherChildren.size() == 1)) {
                sb.append("Родные сестры: нет \n");
                sb.append("Родные братья: нет \n");
                if((motherChildren.size() > 1)){
                    sb.append("Кровные сестры по матери:\n");
                    getFemale(sb, motherChildren, human);
                    sb.append("Кровные братья по матери:\n");
                    getMale(sb, motherChildren, human);
                }
                if((fatherChildren.size() > 1)){
                    sb.append("Кровные сестры по отцу:\n");
                    getFemale(sb, fatherChildren, human);
                    sb.append("Кровные братья по отцу:\n");
                    getMale(sb, fatherChildren, human);
                }
            } else {
                if (motherChildren.toString().equals(fatherChildren.toString())) {
                    sb.append("Родные сестры:\n");
                    getFemale(sb, motherChildren, human);
                    sb.append("Родные братья:\n");
                    getMale(sb, motherChildren, human);
                } else {
                    List<Human> common = commonChildren(motherChildren, fatherChildren);
                    sb.append("Родные сестры:\n");
                    getFemale(sb, common, human);
                    sb.append("Родные братья:\n");
                    getMale(sb, common, human);
                    sb.append("Кровные сестры по отцу:\n");
                    getFemale(sb, differentChildren(common, fatherChildren), human);
                    sb.append("Кровные братья по отцу:\n");
                    getMale(sb, differentChildren(common, fatherChildren), human);
                    sb.append("Кровные сестры по матери:\n");
                    getFemale(sb, differentChildren(common, motherChildren), human);
                    sb.append("Кровные братья по матери:\n");
                    getMale(sb, differentChildren(common, motherChildren), human);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Поиск кровных братьев и сестер
     * @param commonList список общих детей у родителей персоны
     * @param parentList список детей родителя (отца или матери)
     * @return
     */
    private List<Human> differentChildren(List<Human> commonList, List<Human> parentList){
        List<Human> list = new ArrayList<>();
        for(Human i: commonList){
            for(Human j : parentList){
                if (!i.equals(j)){
                    list.add(i);
                }
            }
        }
        return list;
    }

    /**
     * Поиск родных братьев и сестер
     * @param motherChildren список детей матери
     * @param fatherChildren список детей отца
     * @return
     */
    private List<Human> commonChildren(List<Human> motherChildren, List<Human> fatherChildren){
        List<Human> list = new ArrayList<>();
        for(Human i: motherChildren){
            for(Human j : fatherChildren){
                if (i.equals(j)){
                    list.add(i);
                }
            }
        }
        return list;
    }

     /**
     * Поиск сестер
     * @param sb
     * @param list список по которому ищем (по родным или кровным)
     * @param human человек, для которого ищем сестер
     */
    private void getFemale(StringBuilder sb, List<Human> list, Human human){
        boolean flag = false;
        for(Human el : list){
            if ((el.getGender() == Gender.Female) && (el != human)){
                sb.append(getHumanInfo(el));
                sb.append("\n");
                flag = true;
            }
        }
        if (flag == false) sb.append("Отсутствуют");
    }

    /**
     * Поиск братьев
     * @param sb
     * @param list список по которому ищем (по родным или кровным)
     * @param human человек, для которого ищем братьев
     */
    private void getMale(StringBuilder sb, List<Human> list, Human human) {
        boolean flag = false;
        for (Human el : list) {
            if ((el.getGender() == Gender.Male) && (el != human)) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
                flag = true;
            }
        }
        if (flag == false) sb.append("Отсутствуют");
    }

    /**
     * Поиск родителей человека
     * @param human
     * @return
     */
    public String findParents(Human human) {
        StringBuilder parents = new StringBuilder();
        if (human.getFather() != null) parents.append("Father:\n" + human.getFather().getName() + "\n");
        else parents.append("Father not found\n");
        if (human.getMother() != null) parents.append("Mother:\n" + human.getMother().getName() + "\n");
        else parents.append("Mother not found\n");
        return parents.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }
    public String getHumanInfo(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(human.getId());
        if (human.getName() != null) {
            sb.append(", имя: ");
            sb.append(human.getName());
        }
        if (human.getSurname() != null) {
            sb.append(", фамилия: ");
            sb.append(human.getSurname());
        }
        if (human.getPatronymic() != null) {
            sb.append(", отчество: ");
            sb.append(human.getPatronymic());
        }
        if (human.getAge() != null) {
            sb.append(", возраст: ");
            sb.append(human.getAge());
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        if (tree.size() > 0){
            for (int i = 0; i < tree.size(); i++) {
                sb.append(tree.get(i));
                sb.append("\n");
            }
        }
        else sb.append("Дерево не заполнено");
        return sb.toString();
    }
}