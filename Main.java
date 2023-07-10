public class Main {
    public static void main(String[] args) {
        Person person = new Person("name","Person");
        person.addData("gender", "male");

        Person mother = new Person("name","Mother");
        mother.addData("gender", "female");
        Person father = new Person("name","Father");
        father.addData("gender", "male");

        System.out.println(person);
        System.out.println(father);
        System.out.println(mother);

        Tree personTree = new Tree(person);
        personTree.setParent(new Node(father));
        personTree.setParent(new Node(mother));

        Tree fatherTree = new Tree(personTree.getParent("male"));

        System.out.println(fatherTree.getChildren());
    }
}
