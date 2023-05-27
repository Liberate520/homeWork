package model.tree.formatters;

import model.tree.Tree;
import model.tree.TreeItem;

public class TreeGrandFatherInfo<T extends TreeItem<T>> implements TreeFormat {
    Tree<T> tree;

    public TreeGrandFatherInfo(Tree<T> tree) {
        this.tree = tree;
    }

    
    public String showTreeInfo(String fullName) {
        if (!fullName.equals(null)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nЗАПРОС ПОИСКА ДЕДУШКИ ДЛЯ " + fullName + ":\n");
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
