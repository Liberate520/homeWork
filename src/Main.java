import human.Human;

public class Main {
    public static void main(String[] args) {
        TreeFamily treeFamily = new TreeFamily();

        Human human = new Human("Boris",84);
        Human human1 = new Human("Marina",82);
        Human human2 = new Human("Vasya",59);
        Human human3 = new Human("Masha",57);
        Human human4 = new Human("Sofi",37);
        Human human5 = new Human("Petr",45);
        Human human6 = new Human("Yana",25);
        Human human7 = new Human("Den",24);
        Human human8 =new Human("Roma",50);
        treeFamily.addTreeFamily(human);
        treeFamily.addTreeFamily(human1);
        treeFamily.addTreeFamily(human2);
        treeFamily.addTreeFamily(human3);
        treeFamily.addTreeFamily(human4);
        treeFamily.addTreeFamily(human5);
        treeFamily.addTreeFamily(human6);
        treeFamily.addTreeFamily(human7);
        treeFamily.addTreeFamily(human8);

        treeFamily.addChildren(human2,human,human1);
        treeFamily.addChildren(human3,human,human1);
        treeFamily.addChildren(human5,human,human1);
        treeFamily.addChildren(human6,human5,human4);
        treeFamily.addChildren(human4,human3,human8);
        treeFamily.addChildren(human7,human3,human8);

        treeFamily.searchHuman("Masha");
        treeFamily.searchHuman("Sofi");
        treeFamily.searchHuman("Boris");
        treeFamily.searchHuman("Petr");


    }


}
