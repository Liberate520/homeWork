import java.util.ArrayList;

import gb.FamilyTree.Node.Node;
import gb.FamilyTree.Node.RelativeNode.RelativeNode;
import gb.FamilyTree.Tree.Relations;
import gb.FamilyTree.Tree.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        Tree familyTree = new Tree();

        RelativeNode me = new RelativeNode("K", "V", "D");

        familyTree.addNode(me);

        RelativeNode mom = new RelativeNode("K", "I", "G");

        familyTree.addNode(me, mom, Relations.PARENT);

        System.out.printf("me - %s\n", me);
        System.out.printf("my parents - %s\n", me.getParents());

        System.out.printf("mom's childs: %s\n", mom.getChilds());

        System.out.println("...\nSister was born!");
        RelativeNode sis = new RelativeNode("K", "P", "D");

        familyTree.addNode(me, sis, Relations.ONE_LEVEL);
        System.out.printf("Mom's childs after my sis was born: %s\n", mom.getChilds());

        System.out.printf("My sis: %s\n", sis);
        System.out.printf("Check does my sis know about my mom?: %s\n", sis.getParents());

        System.out.println("...");

        RelativeNode third = familyTree.getNode(3);
        System.out.printf("Trying to get third added person: %s\n", third);
        System.out.printf("Trying to get sisters/brothers of third person: %s", third.getOneLevelNodes());

        System.out.println("...\nI forgot to add the dad..");

        RelativeNode dad = new RelativeNode("K", "D", "A");
        familyTree.addNode(sis, dad, Relations.PARENT);

        System.out.printf("Let's check do I know now about my dad?: %s\n", me.getParents());
        System.out.println("...");

        System.out.println("Let's help dad to remember who is the mother of his kids: ");

        ArrayList<Node> childs = dad.getChilds();
        if (childs.size() > 0) {
            Node child = childs.get(0);
            System.out.print(child.getParents());
        }

        System.out.println("... We will encapsulate this later, but now it's just example of the project structure.");
    }
}
