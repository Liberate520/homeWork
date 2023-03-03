package org.example.model.print;

import org.example.model.Human;
import org.example.model.Tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintHuman {  // создает текст вывода отдельных Human, и всего списка.
    private final Tree <Human> tree;
    private final ArrayList<Map<String, String>> list;


    public PrintHuman(Tree<Human> tree) {
        this.tree = tree;
        this.list = getAListPrintHuman();
    }

    public ArrayList<Map<String, String>> getList() {
        return list;
    }


    public ArrayList<Map<String, String>> getAListPrintHuman(){
        ArrayList <Map<String, String>> printHuman = new ArrayList<>();
        for (int i = 0; i < tree.getBigFamily().size(); i++) {
            printHuman.add(new LinkedHashMap<>(Map.of(tree.getBigFamily().get(i).getName(), superPrintHumanHC(tree.getBigFamily(), i))));
        }
        return printHuman;
    }


    public  String superPrintHumanHC(ArrayList<Human> bigFamily, int indexH) {  // Создание строки для печати
        StringBuilder string = new StringBuilder(String.format("Ф.И.О.: %s, Пол: %s, Дата рождения: %s", bigFamily.get(indexH).getName(),
                bigFamily.get(indexH).getGender(),
                bigFamily.get(indexH).getDateOfBirth()));
        string.append(", ");

        if (bigFamily.get(indexH).getDateOfDeath() == null) {
            string.append(" ");
        } else {
            string.append(String.format("Дата смерти: %s, ", bigFamily.get(indexH).getDateOfDeath()));
        }
        string.append(bigFamily.get(indexH).getId()).append("\n");
        if(bigFamily.get(indexH).getMother() == null){
            string.append("Мама: не определенна\n");
        }else {
            string.append(String.format("Мама: %s", bigFamily.get(indexH).getMother().getName() + "\n"));
        }
        if(bigFamily.get(indexH).getFather() == null){
            string.append("Папа: не определен\n");
        }else {
            string.append(String.format("Папа: %s", bigFamily.get(indexH).getFather().getName())).append("\n");
        }
        if (bigFamily.get(indexH).getChildren().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getChildren().size(); i++) {
                string.append(String.format("Сын/Дочь: %s", bigFamily.get(indexH).getChildren().get(i).getName() + "\n"));
            }
        }else if(bigFamily.get(indexH).getChildren().size() == 0){
            string.append("Дети: не определенны\n");
        }
        if (bigFamily.get(indexH).getBrothersAndSisters().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getBrothersAndSisters().size(); i++) {
                string.append(String.format("Брат/Сестра: %s", bigFamily.get(indexH).getBrothersAndSisters().get(i).getName() + "\n"));
            }

            string.append("\n\n");
        } else if (bigFamily.get(indexH).getBrothersAndSisters().size() == 0){
            string.append("Братья/Сестры: не определенны\n\n");
        }
        return string.toString();
    }

}
