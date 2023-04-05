public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human NikolayII = new Human("Николай II Александрович", Gender.Male, 1868, Reign.Yes);
        tree.addHuman(NikolayII);

        Human alexandrafedorovna = new Human("Александра Федоровна Гессенская", Gender.Female, 1872, Reign.No);
        tree.addHuman(alexandrafedorovna);

        Human AlexandrIII = new Human("Александр III Александрович", Gender.Male, 1845, Reign.Yes);
        tree.addHuman(AlexandrIII);
        NikolayII.addFather(AlexandrIII);
        AlexandrIII.addChild(NikolayII);

        Human AlexandrII = new Human("Алексадр II Николаевич", Gender.Male, 1818, Reign.Yes);
        tree.addHuman(AlexandrII);
        AlexandrIII.addFather(AlexandrII);
        AlexandrII.addChild(AlexandrIII);

        tree.printFamily();
    }
}
