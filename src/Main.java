public class Main {
    public static void main(String[] args ){
        Human hum0 = new Human("Vasja", "Pupkin", Gender.M);
        Human hum1 = new Human("Petya", "Zupkin", Gender.M);
        Human hum2 = new Human("Vasja", "Grivkin", Gender.M);
        Human hum3 = new Human("Olga", "Kuzina", Gender.W);
        Human hum4 = new Human("Natasha", "Ivanova", Gender.W);
        Human hum5 = new Human("Andrey", "Kozlov", Gender.M);
        Human hum6 = new Human("Alex", "Petrov", Gender.M);
        Human hum7 = new Human("Masha", "Medvedeva", Gender.W);
        Human hum8 = new Human("Gora", "Kornev", Gender.M);
        Human hum9 = new Human("Dunja", "Kulakova", Gender.M);


        FileWork  filework = new FileWork();

//        FamTree tree = new FamTree();
//        tree.addHum(hum0);
//        tree.addHum(hum1);
//        tree.addHum(hum2);
//        tree.addHum(hum3);
//        tree.addHum(hum4);
//        tree.addHum(hum5);
//        tree.addHum(hum6);
//        tree.addHum(hum7);
//        tree.addHum(hum8);
//        tree.addHum(hum9);

//       filework.write(tree, "Family.dat");
        //из файла почему-то не читает
              FamTree tree = (FamTree)filework.read("Family.dat");
        System.out.println(tree);
          tree.getHumahById(0).addChildren(hum4, hum5, hum6);
        tree.getHumahById(3).setMarriagePartner(hum0);

//        String inf = tree1.getHumahById(3).toString();
//        System.out.println(inf);
        System.out.println(tree.toString());
    }
}
