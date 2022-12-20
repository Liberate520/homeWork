
public class Main  {
    public static void main(String[] args) {
        Trees trees = new Trees();
        Human human1 = new Human("Egor", "Petrov", 1, 60, "male");
        Human human2 = new Human("Olga", "Petrova", 5, 60, "female");
        Human human3 = new Human("Vasya", "Petrov", 25, 100, "male");
        Human human4 = new Human("Eva", "Petrova", 27, 50, "female");
        Communication comun12 = new Communication(human1, human2, TypeCommunication.Husband, TypeCommunication.Wife);
        Communication comun13 = new Communication(human1, human3, TypeCommunication.Father, TypeCommunication.Child);
        Communication comun14 = new Communication(human1, human4, TypeCommunication.Father, TypeCommunication.Child);
        Communication comun23 = new Communication(human2, human3, TypeCommunication.Mother, TypeCommunication.Child);
        Communication comun24 = new Communication(human2, human4, TypeCommunication.Mother, TypeCommunication.Child);
        Communication comun34 = new Communication(human3, human4, TypeCommunication.Brother, TypeCommunication.Sister);
        trees.add_communication(comun12);
        trees.add_communication(comun13);
        trees.add_communication(comun14);
        trees.add_communication(comun23);
        trees.add_communication(comun24);
        trees.add_communication(comun34);
        System.out.println(trees);

    }

}
