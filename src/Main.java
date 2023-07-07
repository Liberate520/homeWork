import java.io.*;

public class Main {
        public static void main(String[] args) {
                String filePath = "src/tree.out";
                FileHandling fileHandling = new FileHandling();
                FamilyTree tree = testTree();
                //System.out.println(tree);
                fileHandling.save(tree, filePath);

                // FileHandling filehandling = new FileHandling();
                // FamilyTree tree = (FamilyTree) fileHandling.read(filePath);
                // System.out.println(tree);
        }
                static FamilyTree testTree() {
                        FamilyTree tree = new FamilyTree();
                        Human human1 = new Human("Панаитов", "Иван", "Васильевич", Gender.Male, 1995, 8, 9);
                        tree.addPerson(human1);
                        tree.addFather("Панаитов", "Василий", "Иванович", Gender.Male, 1969, 8, 12, human1);
                        tree.addMother("Панаитова", "Зинаида", "Петровна", Gender.Female, 1971, 8, 11, human1);
                        tree.addFather("Панаитов", "Иван", "Степанович", Gender.Male, 1948, 10, 21, human1.getFather());
                        tree.addMother("Панаитова", "Пелагея", "Константиновна", Gender.Female, 1949, 10, 7, human1.getMother());
                        System.out.println("=".repeat(70));
                        System.out.println(human1);
                        System.out.println("=".repeat(70));
                        System.out.print(tree.findParents(human1));
                        System.out.println("=".repeat(70));
                        System.out.println("Дедушка:\n" + human1.getFather().getFather());
                        System.out.println("Бабушка:\n" + human1.getMother().getMother());
                        System.out.println("=".repeat(70));
                        return tree;
                }
        }
