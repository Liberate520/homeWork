public class Main {
    public static void main(String[] args) {
        Tree tree=new Tree();

        Person person1=new Person(80,0,"Иванова Наталья");
        Person person2=new Person(90,1,"Иванов Василий");
        Person person3=new Person(50,0,"Петрова Лилия",person1,person2);
        Person person4=new Person(50,1,"Петров Владимир");
        Person person11=new Person(55,0,"Кузнецова Полина");
        Person person12=new Person(60,1,"Кузнецов Дмитрий");
        Person person5=new Person(30,1,"Петров Иван",person3,person4);
        Person person6=new Person(30,0,"Петрова Галина",person11,person12);
        Person person7=new Person(10,1,"Петров Геннадий",person6,person5);
        Person person8=new Person(10,0,"Петрова Ольга",person6,person5);
        Person person9=new Person(10,1,"Петров Максим",person6,person5);
        Person person10=new Person(40,0,"Иванова Нина",person1,person2);



        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);
        tree.addPerson(person5);
        tree.addPerson(person6);
        tree.addPerson(person7);
        tree.addPerson(person8);
        tree.addPerson(person9);
        tree.addPerson(person10);

        //System.out.println(person3);
        System.out.println(tree.getGrandParents(person9));
        System.out.println(tree.getParents(person9));
        System.out.println(tree.getChildren(person6));
        System.out.println(person5.getGender());

        FileWorker.SaveFile(person2);
        FileWorker.ReadFile(person2);

        






    }
}
