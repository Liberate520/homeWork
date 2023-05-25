package model.tree.formatters;

import model.tree.Tree;
import model.tree.TreeItem;

public class TreeGrandMotherInfo<T extends TreeItem<T>> implements TreeFormat {
    Tree<T> tree;

    public TreeGrandMotherInfo(Tree<T> tree) {
        this.tree = tree;
    }

    @Override
    public String showTreeInfo(String fullName) {
        if (!fullName.equals(null)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nЗАПРОС ПОИСКА БАБУШКИ ДЛЯ " + fullName + ":\n");
            try {
                T human = tree.getHumanByFullName(fullName);
                stringBuilder.append(human.getShortInfo());

            } catch (NullPointerException e) {
                stringBuilder.append("не обнаружено");
            }
            return stringBuilder.toString();
        }
        return "Введено недопустимое значение полного имени";
    }

}
