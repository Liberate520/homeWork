package org.example;

import org.example.Iterator.HumanIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Tree <T extends Human> implements Iterable<T>{
    private final ArrayList <String> existingIds;  // хранит существующие id Human после загрузки с файла, для того, чтобы
                                                      //при добавлении или удалении человека, id назначались последовательно.
    {                                                 // Уадлен id 6, следующий созданный станет 6-стым.
        existingIds = new ArrayList<String>();
    }
    private String nameFamily;
    private final ArrayList<T> bigFamily;
    {
        bigFamily = new ArrayList<>();
    }


    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public ArrayList<T> getBigFamily() {
        return bigFamily;
    }

    public ArrayList<String> getExistingIds() {
        return existingIds;
    }

    public void addHuman(T human){
        this.bigFamily.add(human);
        this.existingIds.add(bigFamily.get(bigFamily.size() - 1).getId());
    }

    public void removingAPerson(ArrayList<Human> bigFamily, int index){
        bigFamily.remove(index);
    }

    public  void printNamesHuman(ArrayList<T> bigFamily) {  // Печать имен Human
        int i = 1;
        for (T human : bigFamily) {
            System.out.printf("%d - %s%n", i, human.getName());
            i++;
        }
    }

    public void printHuman(ArrayList<T> bigFamily, int indexH) {  // Печать Human
        System.out.printf("%s, %s, %s, %s%n", bigFamily.get(indexH).getName(), bigFamily.get(indexH).getGender(),
                bigFamily.get(indexH).getDateOfBirth(), bigFamily.get(indexH).getDateOfDeath());
        System.out.println();
    }

    public  void superPrintHumanHC(ArrayList<T> bigFamily, int indexH) {  // Печать Human центральной фигуры
        System.out.print(String.format("Ф.И.О.: %s, Пол: %s, Дата рождения: %s",
                bigFamily.get(indexH).getName(),
                bigFamily.get(indexH).getGender(),
                bigFamily.get(indexH).getDateOfBirth()));
        System.out.print(", ");
        if (bigFamily.get(indexH).getDateOfDeath() == null) {
            System.out.print("");
        } else {
            System.out.print(String.format("Дата смерти: %s, ", bigFamily.get(indexH).getDateOfDeath()));
        }
        System.out.println(bigFamily.get(indexH).getId());
        if(bigFamily.get(indexH).getMother() == null){
            System.out.println("Мама: не определенна");
        }else {
            System.out.println(String.format("Мама: %s", bigFamily.get(indexH).getMother().getName()));
        }
        if(bigFamily.get(indexH).getFather() == null){
            System.out.println("Папа: не определен");
        }else {
            System.out.println(String.format("Папа: %s", bigFamily.get(indexH).getFather().getName()));
        }
        if (bigFamily.get(indexH).getChildren().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getChildren().size(); i++) {
                System.out.println(String.format("Сын/Дочь: %s", bigFamily.get(indexH).getChildren().get(i).getName()));
            }
        }else if(bigFamily.get(indexH).getChildren().size() == 0){
            System.out.println("Дети: не определенны");
        }
        if (bigFamily.get(indexH).getBrothersAndSisters().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getBrothersAndSisters().size(); i++) {
                System.out.println(String.format("Брат/Сестра: %s", bigFamily.get(indexH).getBrothersAndSisters().get(i).getName()));
            }

            System.out.println("\n\n");
        } else if (bigFamily.get(indexH).getBrothersAndSisters().size() == 0){
            System.out.println("Братья/Сестры: не определенны");
            System.out.println();
        }
    }


    @Override
    public Iterator<T> iterator() {
        return  new HumanIterator<>(bigFamily);
    }
}


