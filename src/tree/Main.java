package tree;

import writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        FamilyTree familyTree;
        try {
            familyTree = handler.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Получаем всех детей выбранного человека
        List<Person> children = familyTree.getChildrenOfPerson("John");
        System.out.println("Children of John:");
        for (Person child : children) {
            System.out.println(child);
        }
        System.out.println(familyTree);

        handler.save(familyTree);
    }
}
