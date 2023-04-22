import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Program implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human h1 = new Human("Natalia", 1966);
        Human h2 = new Human("Timur", 1965);
        tree.addMember(h1);
        tree.addMember(h2);
        //tree.showAllMembers();
        
        Human h3 = new Human("Liza", 1991, h1, h2);
        tree.addMember(h3);
        Human h4 = new Human("Lenya", 2015, h1, h2);
        tree.addMember(h4);
        //tree.showAllMembers();
        h1.addChild(h3);
        h1.addChild(h4);
        h2.addChild(h3);
        h2.addChild(h4);
        //h1.showChildren();
        //h2.showChildren();
        WriteAndRead writeAndRead = new WriteAndRead();
        writeAndRead.save(tree);
        writeAndRead.load();
    }
}
