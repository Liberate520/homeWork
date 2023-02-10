import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Family<People> family = new Family<>();

        People grandmaF = new People("Ekaterina", "female", 78, null, null);
        People grandpaF = new People("Mikhail", "male", 61, null, null);
        People dad_a = new People("Ivan", "male", 45, grandpaF, grandmaF);

        People grandmaM = new People("Anastasia", "female", 78, null, null);
        People mom_a = new People("Julia", "female", 39, null, grandmaM);
        People mom_b = new People("Evgenia", "female", 39, null, grandmaM);

        People son_a = new People("Petr", "male", 30, dad_a, mom_a);
        People daughter_a = new People("Nataly", "female", 23, dad_a, mom_a);
        People son_b = new People("Alex", "male", 30, dad_a, mom_a);
        People daughter_b = new People("Anna", "female", 25, null, mom_b);

        People grandaughter_a = new People("Daria", "female", 5, son_a, daughter_b);

        family.add(grandmaF);
        family.add(grandpaF);
        family.add(dad_a);
        family.add(grandmaM);
        family.add(mom_a);
        family.add(mom_b);
        family.add(son_a);
        family.add(daughter_a);
        family.add(son_b);
        family.add(daughter_b);
        family.add(grandaughter_a);

        // FileHandler fileHandler = new FileHandler();
        // family.setFileHandler(fileHandler);
        // family.saveFamily();
        // Family readFile = family.readFile();
        // System.out.println(readFile);

        // People foundPeople = family.search("Julia");

        // System.out.println(family.search("Julia"));
        // List<String> broAndSis = family.getFamMembers("Evgenia");


        // System.out.println("--------------------------------------------");
        // System.out.println("Вывод с использованием цикла foreach");
        // for (People people: family) {
        //     System.out.println(people);
        // }
        // System.out.println("--------------------------------------------");

        // System.out.println("-----------------------------------------------");
        // System.out.println("Вывод отсортированных людей по имени:");
        // family.sortByName();
        // for (People people : family) {
        //     System.out.println(people);0
        // }
        // System.out.println("-----------------------------------------------");
        // System.out.println();
        // System.out.println("Вывод отсортированных людей по дате рождения:");
        // family.sortByDate();
        // for (People people : family) {
        //     System.out.println(people);
        // }
        
        ViewFamilyTree<People> viewTree = new ViewFamilyTree<>(family);
        viewTree.startView();
    }
}