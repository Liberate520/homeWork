package model.tree.formatters;

import model.human.Gender;
import model.tree.Tree;
import model.tree.TreeItem;

public class TreeGenderStatistics<T extends TreeItem<T>> implements TreeFormat {
    Tree<T> tree;

    public TreeGenderStatistics(Tree<T> tree) {
        this.tree = tree;
    }

    @Override
    public String showTreeInfo(String gender) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСПИСОК ВСЕХ ЛЮДЕЙ ");
        stringBuilder.append((tree.convertStringToGender(gender).equals(Gender.Male)) ? "МУЖСКОГО" : "ЖЕНСКОГО");
        stringBuilder.append(" ПОЛА В ДЕРЕВЕ\n");
        String text = stringBuilder.toString();
        for (T human : tree.getHumans()) {
            if (human.getGender().equals(tree.convertStringToGender(gender))) {
                stringBuilder.append(human.getFullInfo());
            }
        }
        if (stringBuilder.toString().equals(text)){
            return stringBuilder.append("Информация не найдена").toString();
        }
        else{return stringBuilder.toString();}
        
    }

}
