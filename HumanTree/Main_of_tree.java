import java.io.IOException;
import java.io.Serializable;

public class Main_of_tree  implements Serializable{
    public static void main(String[] args)  throws IOException, ClassNotFoundException{
        HumanTree humanTree = new HumanTree();
        Human firstHuman = new Human("Romanov Michael Fedorovich", "1596-1645", "1613-1645", null, null);
        Human secondHuman = new Human("Streshneva Evdokiya", "1608-1645", null, null, null);
        Human thirdHuman = new Human("Romanov Alexey Michaelevich", "1629-1676", "1645-1676", firstHuman, secondHuman);
        Human fourthHuman = new Human("Romanov Fedor Alexeevich", "1661-1682", "1676-1682", thirdHuman, null);
        Human fifthHuman = new Human("Romanova Sofia Alexeevich", "1657-1704", "1682-1689", thirdHuman, null);
        humanTree.addHuman(firstHuman);
        humanTree.addHuman(secondHuman);
        humanTree.addHuman(thirdHuman);
        humanTree.addHuman(fourthHuman);
        humanTree.addHuman(fifthHuman);

        // System.out.println(firstHuman.toString());
        // System.out.println(humanTree.getHumanList());
        // System.out.println(thirdHuman.getFather());
        // System.out.println(humanTree.getChild(firstHuman));
        // System.out.println(humanTree.getSistBroth(fourthHuman));  
        // firstHuman.write();
        firstHuman.read();
        System.out.println(firstHuman.toString());      
    }
}
