package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenealogyApp {
    public static void main(String[] args) {
        GenealogyApp app = new GenealogyApp();
        app.run();
    }

    private void run() {
        List<FamilyMember> familyMembers = createFamilyMembers();
        FamilyTree<FamilyMember> familyTree = new FamilyTree<>(familyMembers);

//        FamilyTreeFileManager fileManager = new FamilyTreeFileManager(familyMembers);

//        try {
//            saveAndLoadFamilyTree(fileManager);
//        } catch (IOException | ClassNotFoundException e) {
//            handleException(e);
//        }

        GenealogyPresenter presenter = new GenealogyPresenter(familyTree);

        ConsoleUI consoleUI = new ConsoleUI(presenter);
        consoleUI.start();
    }


    private List<FamilyMember> createFamilyMembers() {
        // Создаем членов семьи
        FamilyMember familyMember1 = new FamilyMember(1, "John", "Smith", Gender.MALE, LocalDate.of(1971, 8, 8), null, null);
        FamilyMember familyMember2 = new FamilyMember(2, "Alise", "Smith", Gender.FEMALE, LocalDate.of(1974, 3, 5), null, null);
        FamilyMember familyMember3 = new FamilyMember(3, "Ann", "Smith", Gender.FEMALE, LocalDate.of(1998, 9, 11), null, null);
        FamilyMember familyMember4 = new FamilyMember(4, "Will", "Smith", Gender.MALE, LocalDate.of(1901, 1, 2), LocalDate.of(1992, 4, 13), null);

        // Создаем список членов семьи
        List<FamilyMember> familyMembers = new ArrayList<>(List.of(familyMember1, familyMember2, familyMember3, familyMember4));

        // Добавляем отношения
        familyMember1.addRelationship(RelationshipType.SPOUSE, familyMember2);
        familyMember2.addRelationship(RelationshipType.SPOUSE, familyMember1);
        familyMember1.addRelationship(RelationshipType.CHILD, familyMember3);
        familyMember2.addRelationship(RelationshipType.CHILD, familyMember3);
        familyMember3.addRelationship(RelationshipType.FATHER, familyMember1);
        familyMember3.addRelationship(RelationshipType.MOTHER, familyMember2);
        familyMember1.addRelationship(RelationshipType.FATHER, familyMember4);

        return familyMembers;
    }




//    private void saveAndLoadFamilyTree(FamilyTreeFileManager fileManager) throws IOException, ClassNotFoundException {
//        // Сохраняем и загружаем семейное дерево из файла
//        fileManager.saveFamilyTree("family_bush.dat");
//        fileManager.loadFamilyTree("family_bush.dat");
//    }

    private void displayFamilyTreeInfo(FamilyTree familyTree) {
        List<Relationship> allRelationships = familyTree.getAllRelationships();
        List<FamilyMember> allPeople = familyTree.getAllPeople();

        // Вывод информации о загруженных отношениях и людях
//        System.out.println("All Relationships:");
//        for (Relationship relationship : allRelationships) {
//            System.out.println(relationship);
//        }

//        System.out.println("All People:");
//        for (FamilyMember familyMember : allPeople) {
//            System.out.println(familyMember);
//        }
    }

    /*private void displaySortedFamilyTree(FamilyTree familyTree) {
        // Вывод отсортированного семейного дерева
        System.out.println("==== Family Tree Sorted by Name ====");
        familyTree.sortByName();
        printFamilyTree(familyTree);

        System.out.println("\nSorting Family Tree by Birth Date...");
        familyTree.sortByBirthDate();
        printFamilyTree(familyTree);
    }*/

    private void printFamilyTree(FamilyTree<FamilyMember> familyTree) {
        for (FamilyMember familyMember : familyTree) {
            System.out.println("----------------------------");
            System.out.println("Name: " + familyMember.getFullName());
            System.out.println("Gender: " + familyMember.getGender());
            System.out.println("Birth Date: " + familyMember.getBirthDate());
            System.out.println("Death Date: " + familyMember.getDeathYear());

            if (familyMember.isAlive()) {
                System.out.println("Age: " + familyMember.getAge() + " years (Alive)");
            } else {
                System.out.println("Age: " + familyMember.getAge() + " years (Died " + familyMember.getYearsSinceDeath() + " years ago)");
            }

            System.out.println("Relationships:");
            for (Relationship relationship : familyTree.getRelationships(familyMember)) {
                FamilyMember relatedFamilyMember = (relationship.getPerson1() == familyMember) ? relationship.getPerson2() : relationship.getPerson1();
                System.out.println("  " + relationship.getType() + ": " + relatedFamilyMember.getFullName());
            }
        }
    }




    private void handleException(Exception e) {
        // Обработка исключения: вывод ошибки и/или дополнительная логика
        e.printStackTrace();
    }
}
