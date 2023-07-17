package faminly_tree.model.tree;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.comparators.HumanComparatorByAge;
import faminly_tree.model.human.comparators.HumanComparatorByID;
import faminly_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//задача класса это исследование семейного древа в виде листа, этим он и занимается, кроме метода GetHumanInfo все хорошо
public class FamilyTree<E extends FamiliItem<E>> implements Serializable, Iterable<E> {
    private List<E> tree;
    private int newID;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void addToTree(E human) {
        tree.add(human);
        human.setId(newID);
        this.newID++;
    }

    //TODO

    /**
     * Показать всех родственников выбранного человека и степень родства
     *
     * @param human
     */
    //public void allRelatives(Human human){
    //}
    private void getParent(StringBuilder sb, E human) {
        if (human == null) return;
        if (human.getGender() == Gender.Female) sb.append("Мать:\n");
        else sb.append("Отец:\n");
        sb.append(getHumanInfo(human));
        sb.append("\n");
    }

    private void getChildren(StringBuilder sb, E human) {
        List<E> Children = human.getChildren();
        if (Children == null) return;
        else {
            sb.append("Дети:\n");
            for (E el : Children) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
    }

    /**
     * Добавить в StringBuilder всех детей по отцу или матери
     *
     * @param sb
     * @param parent human.getFather() or human.GetMother()
     */
    private void getFatherOrMotherChildren(StringBuilder sb, E parent, E humanException) {
        List<E> children = parent.getChildren();
        if (children.size() == 1) return;
        if (checkFemale(children, humanException)) {
            sb.append("Cестры (степень родства определить невозможно):\n");
            getFemale(sb, children, humanException);
        }
        if (checkMale(children, humanException)) {
            sb.append("Братья (степень родства определить невозможно):\n");
            getMale(sb, children, humanException);
        }
    }

    private void maternalBrothersAndSisters(StringBuilder sb, List<E> motherChildren, E humanException) {
        if ((motherChildren.size() > 1)) {
            if (checkFemale(motherChildren, humanException)) {
                sb.append("Кровные сестры по матери:\n");
                getFemale(sb, motherChildren, humanException);
            }
            if (checkMale(motherChildren, humanException)) {
                sb.append("Кровные братья по матери:\n");
                getMale(sb, motherChildren, humanException);
            }
        }
    }

    private void paternalBrothersAndSisters(StringBuilder sb, List<E> fatherChildren, E humanException) {
        if ((fatherChildren.size() > 1)) {
            if (checkFemale(fatherChildren, humanException)) {
                sb.append("Кровные сестры по отцу:\n");
                getFemale(sb, fatherChildren, humanException);
            }
            if (checkMale(fatherChildren, humanException)) {
                sb.append("Кровные братья по отцу:\n");
                getMale(sb, fatherChildren, humanException);
            }
        }
    }

    private void getSiblingsAndBloodBrotherAndSister(StringBuilder sb, List<E> motherChildren, List<E> fatherChildren, E humanException) {
        List<E> common = findCommonChildren(motherChildren, fatherChildren);
        if (checkFemale(common, humanException)) {
            sb.append("Родные сестры:\n");
            getFemale(sb, common, humanException);
        }
        if (checkMale(common, humanException)) {
            sb.append("Родные братья:\n");
            getMale(sb, common, humanException);
        }
        if (motherChildren.toString().equals(fatherChildren.toString())) return;
        List<E> diff = differentChildren(common, fatherChildren);
        if (checkFemale(diff, humanException)) {
            sb.append("Кровные сестры по отцу:\n");
            getFemale(sb, diff, humanException);
        }
        if (checkMale(diff, humanException)) {
            sb.append("Кровные братья по отцу:\n");
            getMale(sb, diff, humanException);
        }
        diff = differentChildren(common, motherChildren);
        if (checkFemale(diff, humanException)) {
            sb.append("Кровные сестры по матери:\n");
            getFemale(sb, diff, humanException);
        }
        if (checkMale(diff, humanException)) {
            sb.append("Кровные братья по матери:\n");
            getMale(sb, diff, humanException);
        }
    }

    /**
     * Показать ближайших родственников человека и степень родства
     *
     * @param human
     */
    public String nextOfKin(E human) {
        StringBuilder sb = new StringBuilder();
        getParent(sb, human.getFather());
        getParent(sb, human.getMother());
        getChildren(sb, human);
        if ((human.getMother() == null) && (human.getFather() != null)) {
            getFatherOrMotherChildren(sb, human.getFather(), human);
        } else if ((human.getMother() != null) && (human.getFather() == null)) {
            getFatherOrMotherChildren(sb, human.getMother(), human);
        } else if ((human.getMother() != null) && (human.getFather() != null)) {
            List<E> motherChildren = human.getMother().getChildren();
            List<E> fatherChildren = human.getFather().getChildren();
            if ((motherChildren.size() == 1) || (fatherChildren.size() == 1)) {
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
     *
     * @param commonList список общих детей у родителей персоны
     * @param parentList список детей родителя (отца или матери)
     * @return
     */
    private List<E> differentChildren(List<E> commonList, List<E> parentList) {
        List<E> list = new ArrayList<>();
        for (E i : commonList) {
            for (E j : parentList) {
                if (!i.equals(j)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    /**
     * Поиск родных братьев и сестер
     *
     * @param motherChildren список детей матери
     * @param fatherChildren список детей отца
     * @return
     */
    private List<E> findCommonChildren(List<E> motherChildren, List<E> fatherChildren) {
        List<E> list = new ArrayList<>();
        for (E i : motherChildren) {
            for (E j : fatherChildren) {
                if (i.equals(j)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    /**
     * Поиск сестер
     *
     * @param sb
     * @param list  список по которому ищем (по родным или кровным)
     * @param human человек, для которого ищем сестер
     */
    private void getFemale(StringBuilder sb, List<E> list, E human) {
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Female) && (el != human)) {
                sb.append(getHumanInfo(el));
                sb.append("\n");
                flag = true;
            }
        }
        if (flag == false) sb.append("Отсутствуют\n");
    }

    private boolean checkFemale(List<E> list, E human) {
        if (list == null) return false;
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Female) && (el != human)) {
                flag = true;
            }
        }
        return flag;
    }

    private boolean checkMale(List<E> list, E human) {
        if (list == null) return false;
        boolean flag = false;
        for (E el : list) {
            if ((el.getGender() == Gender.Male) && (el != human)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Поиск братьев
     *
     * @param sb
     * @param list  список по которому ищем (по родным или кровным)
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
        if (flag == false) sb.append("Отсутствуют\n");
    }

    /**
     * Поиск родителей человека
     *
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


    //метод завязан на класс Human, а если в дерево передается что-то другое, кроме человека? Нужен интерфейс
    // getObgectInfo и его реализации для разных существ и, как следствие, отдельный пакет для этого интерфейса и
    // реализующих его классов
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
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (tree.size() > 0) {
            for (int i = 0; i < tree.size(); i++) {
                sb.append(tree.get(i));
                sb.append("\n");
            }
        } else sb.append("Дерево не заполнено");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(tree);
    }

    public void sortByName() {
        Collections.sort(tree, new HumanComparatorByName<>());
    }
    public void sortByAge() {
        Collections.sort(tree, new HumanComparatorByAge<>());
    }
    public void sortByID(){
        Collections.sort(tree, new HumanComparatorByID<>());
    }
    public E getHumanByID(int id) {
        for (E el : tree) {
            if (el.getId() == id) return el;
        }
        return null;
    }

    public int getSize() {
        return tree.size();
    }
}