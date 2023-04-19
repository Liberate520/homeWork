public class Main {
    public static void main(String[] args) {
        Human person1 = new Human("Мария", "Иванова", "01.01.1970", null, null);
        GenealogyTree.addHuman(person1);
        Human person2 = new Human("Иван", "Иванов", "02.02.1971", null, null);
        GenealogyTree.addHuman(person2);
        Human person3 = new Human("Анна", "Петрова", "03.03.1995", person1, person2);
        GenealogyTree.addHuman(person3);
        Human person4 = new Human("Петр", "Сидоров", "04.04.1996", person1, person2);
        GenealogyTree.addHuman(person4);
        Human person5 = new Human("Ольга", "Кузнецова", "05.05.1998", person1, person2);
        GenealogyTree.addHuman(person5);

        // Печать родителей и детей
        System.out.println(person3.getMother());  // Мария Иванова
        System.out.println(person4.getFather());  // Иван Иванов
        System.out.println(person1.getChildren());  // [Анна Петрова, Петр Сидоров, Ольга Кузнецова]
        System.out.println(person5.getParents()); // Мария Иванова, Иван Иванов

        // Печать дерева конкретного экземпляра
        GenealogyTree.printTree("", person1); // [Анна Петрова, Петр Сидоров, Ольга Кузнецова]
    }
}
