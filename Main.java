public class Main {
    public static void main(String[] args) {
            Tree tree = new Tree();
            tree.createFamilyHeader("Sergey", "01.01.1937", "M");
            tree.createFamilyHeader("Elizaveta", "01.01.1935", "W");
            tree.marrage(tree.getPerson("Sergey", "01.01.1937"), tree.getPerson("Elizaveta", "01.01.1935"));
            tree.born(tree.getPerson("Sergey", "01.01.1937"), tree.getPerson("Elizaveta", "01.01.1935"), "Valentina", "29.07.1959","W");



            tree.createFamilyHeader("Aleksandr", "24.09.1963", "M");
            tree.marrage(tree.getPerson("Aleksandr", "24.09.1963"), tree.getPerson("Valentina", "29.07.1959"));
            tree.born(tree.getPerson("Aleksandr", "24.09.1963"), tree.getPerson("Valentina", "29.07.1959"), "Elena", "13.12.1984", "W");

            tree.createFamilyHeader("Aleksandr", "19.03.1985", "M");
            tree.marrage(tree.getPerson("Aleksandr", "19.03.1985"), tree.getPerson("Elena", "13.12.1984"));
            tree.born(tree.getPerson("Aleksandr", "19.03.1985"), tree.getPerson("Elena", "13.12.1984"), "Liza", "12.02.2009", "W");
            tree.born(tree.getPerson("Aleksandr", "19.03.1985"), tree.getPerson("Elena", "13.12.1984"), "Danila", "16.03.2014", "M");

            tree.petFamily("Мася", "Cat", tree.getPerson("Elena", "13.12.1984"));

            tree.Print();
            System.out.println("--------------------------------");
            tree.Print2("Aleksandr");
            System.out.println("--------------------------------");
    }
}