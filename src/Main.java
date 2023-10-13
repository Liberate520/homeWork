import java.time.LocalDate;

import Writer.FileHandler;
import model.famailyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;


public class Main {
        public static void main(String[] args) {
                String filePath = "src/Writer/treeFamily.txt";
                FileHandler fileHandler = new FileHandler();
                FamilyTree<Human> tree = treeFamily();
//                FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
                System.out.println(tree);
                fileHandler.save(tree, filePath);

                
                System.out.println("Сортировка по дате рождения");
                tree.sortBirthDay();
                System.out.println(tree);

                System.out.println("Сортировка по имени");
                tree.sortByName();
                System.out.println(tree);
                
                               
        }

        

        public static FamilyTree<Human> treeFamily() {
                FamilyTree<Human> tree = new FamilyTree<>();

                Human grandMother1 = new Human("Нила", "Нила", "Кожедуб",
                                LocalDate.of(1947, 01, 11),
                                LocalDate.of(2015, 05, 10), Gender.Female);

                Human grandFather1 = new Human("Иван", "Иван", "Кожедуб",
                                LocalDate.of(1941, 01, 10), Gender.Male);

                Human grandMother2 = new Human("Людмила", "Людмила", "Кожедуб",
                                LocalDate.of(1932, 03, 11),
                                LocalDate.of(2012, 06, 20), Gender.Female);

                Human grandFather2 = new Human("Павел", "Павел", "Кожедуб",
                                LocalDate.of(1930, 06, 10), Gender.Male);

                tree.add(grandMother1);
                tree.add(grandFather1);
                tree.add(grandMother2);
                tree.add(grandFather2);

                Human mother = new Human("Татьяна", "Татьяна", "Кожедуб",
                                LocalDate.of(1965, 02, 13), Gender.Female, grandMother1, grandFather1);

                Human father = new Human("Константин", "Константин", "Кожедуб",
                                LocalDate.of(1963, 01, 15), Gender.Male, grandMother2, grandFather2);

                Human child1 = new Human("Владимир", "Владимир", "Кожедуб",
                                LocalDate.of(1988, 02, 11), Gender.Male, mother, father);

                Human child2 = new Human("Светлана", "Светлана", "Кожедуб",
                                LocalDate.of(1986, 05, 14), Gender.Female, mother, father);

                tree.add(mother);
                tree.add(father);
                tree.add(child1);
                tree.add(child2);

                return tree;
        }
}
