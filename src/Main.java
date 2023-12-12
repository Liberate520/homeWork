import family.Tree;
import family.writer.FileHandler;
import human.Human;
import human.Gender;

public class Main {
    public static void main(String[] args) {

        Human A = new Human("A",Gender.female,1930,2011);
        Human AA = new Human("AA",Gender.male);
        Human B = new Human("B",Gender.female);
        Human C = new Human("C",Gender.male,1991);
        Human D = new Human("D", Gender.female,1995);

        Tree family = new Tree();

        family.addHuman(A);
        family.addHuman(B);
        family.addHuman(C);
        family.addHuman(D);
        family.addHuman(AA);

        System.out.print("исходная семья \n"+family.outputTree()+"\n");
        //save(family);

        B.addParent(A);
        B.addParent(AA);
        B.addChild(C);
        B.setBirn(1960);
        B.setDie(2023);
        D.setPair(C);

        System.out.print("новые данные \n"+family.outputTree()+"\n");
        /*
        Tree familyNEW = load();
        System.out.print("загруженные данные \n"+familyNEW.outputTree()+"\n");
*/


        family.sortByName();
        System.out.print("Сортировкапо имени \n"+family.outputTree()+"\n");;
        family.sortByBirn();
        System.out.print("Сортировка по дате рождения \n"+family.outputTree()+"\n");;

    }

    private static void save(Tree family){
        FileHandler fileHandler=new FileHandler();
        String path="src/family.txt";
        fileHandler.save(family,path);
    }

    private static Tree load(){
        FileHandler fileHandler=new FileHandler();
        String path="src/family.txt";
        return (Tree) fileHandler.read(path);
    }







}