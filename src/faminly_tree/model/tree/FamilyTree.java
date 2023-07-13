package faminly_tree.model.tree;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;
import faminly_tree.model.human.comparators.HumanComparatorByAge;
import faminly_tree.model.human.comparators.HumanComparatorByBirth;
import faminly_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamiliItem<E>> implements Serializable, Iterable<E> {
   private List<E> tree;
   private int newID;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void addToTree(E human){
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

    private void getParent(StringBuilder sb, E human){
        if (human != null) sb.append(getHumanInfo(human));
        else sb.append("неизвестен(а)");
        sb.append("\n");
    }
    private void getChildren(StringBuilder sb, E human){
        List<E> Children = human.getChildren();
        if (Children == null) sb.append("нет");
        else {
            for(E el : Children){
                sb.append(getHumanInfo(el));
                sb.append("\n");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
    }

    /**
     * Добавить в StringBuilder всех детей по отцу или матери
     * @param sb
     * @param human human.getFather() or human.GetMother()
     */
    private void getFatherOrMotherChildren(StringBuilder sb, E human){
        List<E> children = human.getFather().getChildren();
        sb.append("Cестры (степень родства определить невозможно):\n");
        getFemale(sb, children, human);
        sb.append("Братья (степень родства определить невозможно):\n");
        getMale(sb, children, human);
    }
    private void maternalBrothersAndSisters(StringBuilder sb, List<E> motherChildren, E human){
        if((motherChildren.size() > 1)){
            sb.append("Кровные сестры по матери:\n");
            getFemale(sb, motherChildren, human);
            sb.append("Кровные братья по матери:\n");
            getMale(sb, motherChildren, human);
        }
    }
    private void paternalBrothersAndSisters(StringBuilder sb, List<E> fatherChildren, E human){
        if((fatherChildren.size() > 1)){
            sb.append("Кровные сестры по отцу:\n");
            getFemale(sb, fatherChildren, human);
            sb.append("Кровные братья по отцу:\n");
            getMale(sb, fatherChildren, human);
        }
    }
    private void getSiblingsAndBloodBrotherAndSister(StringBuilder sb, List<E> motherChildren, List<E> fatherChildren, E human){
        if (motherChildren.toString().equals(fatherChildren.toString())) {
            sb.append("Родные сестры:\n");
            getFemale(sb, motherChildren, human);
            sb.append("Родные братья:\n");
            getMale(sb, motherChildren, human);
        } else {
            List<E> common = findCommonChildren(motherChildren, fatherChildren);
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

    /**
     * Показать ближайших родственников человека и степень родства
     * @param human
     */
    public String nextOfKin(E human){
        StringBuilder sb = new StringBuilder();
        sb.append("Отец:\n");
        getParent(sb, human.getFather());
        sb.append("Мать:\n");
        getParent(sb, human.getMother());
        sb.append("Дети:\n");
        getChildren(sb, human);
        if ((human.getMother() == null) && (human.getFather() != null)){
            getFatherOrMotherChildren(sb, human.getFather());
        }
        else if ((human.getMother() != null) && (human.getFather() == null)){
            getFatherOrMotherChildren(sb, human.getMother());
        }
        else if ((human.getMother() != null) && (human.getFather() != null)) {
            List<E> motherChildren = human.getMother().getChildren();
            List<E> fatherChildren = human.getFather().getChildren();
            if ((motherChildren.size() == 1) || (fatherChildren.size() == 1)) {
                sb.append("Родные сестры и братья: нет \n");
                maternalBrothersAndSisters(sb, motherChildren, human);
                paternalBrothersAndSisters(sb, fatherChildren, human);
            } else {
                getSiblingsAndBloodBrotherAndSister(sb, motherChildren, fatherChildren, human);
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
    private List<E> differentChildren(List<E> commonList, List<E> parentList){
        List<E> list = new ArrayList<>();
        for(E i: commonList){
            for(E j : parentList){
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
    private List<E> findCommonChildren(List<E> motherChildren, List<E> fatherChildren){
        List<E> list = new ArrayList<>();
        for(E i: motherChildren){
            for(E j : fatherChildren){
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
    private void getFemale(StringBuilder sb, List<E> list, E human){
        boolean flag = false;
        for(E el : list){
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
    private void getMale(StringBuilder sb, List<E> list, E human) {
        boolean flag = false;
        for (E el : list) {
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
    public String findParents(E human) {
        StringBuilder parents = new StringBuilder();
        if (human.getFather() != null) parents.append("Father:\n" + human.getFather().getName() + "\n");
        else parents.append("Father not found\n");
        if (human.getMother() != null) parents.append("Mother:\n" + human.getMother().getName() + "\n");
        else parents.append("Mother not found\n");
        return parents.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }

    public String getHumanInfo(E human) {
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
        if (human.getAge() != 0) {
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
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(tree);
    }
    public List<E> getTree() {
        return tree;
    }

    public void sortByName(){
        Collections.sort(tree, new HumanComparatorByName<>());
    }
    public void sortByAge(){
        Collections.sort(tree, new HumanComparatorByAge<>());
    }
    public void sortByBirth(){
        Collections.sort(tree, new HumanComparatorByBirth<>());
    }

    public E getHumanByID(int id) {
        for (E el: tree){
            if(el.getId() == id) return el;
        }
        return null;
    }
}