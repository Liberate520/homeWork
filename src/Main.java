
public class Main {
    public static void main(String[] args) {
        Trees trees_com = new Trees();

        Human human = new Human("Igor", "Popov", 1955, 1980, "male");
        Human human1 = new Human("Egor", "Popov", 1960, 1970, "male");
        Communication communication = new Communication(human, human1, TypeCommunication.Father,
                TypeCommunication.Child);
    }

}
