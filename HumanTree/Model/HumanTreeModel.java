package Model;

public class HumanTreeModel implements Model {    
    private HumanTree<Human> humanTree;
    private Human firstHuman;
    private Human secondHuman;
    private Human thirdHuman;
    private Human fourthHuman;
    private Human fifthHuman;
    
    public HumanTreeModel() {        
        this.humanTree = new HumanTree<>();
        this.firstHuman = new Human("Romanov Michael Fedorovich", "1596-1645", "1613-1645", null, null);
        this.secondHuman = new Human("Streshneva Evdokiya", "1608-1645", null, null, null);
        this.thirdHuman = new Human("Romanov Alexey Michaelevich", "1629-1676", "1645-1676", firstHuman, secondHuman);
        this.fourthHuman = new Human("Romanov Fedor Alexeevich", "1661-1682", "1676-1682", thirdHuman, null);
        this.fifthHuman = new Human("Romanova Sofia Alexeevna", "1657-1704", "1682-1689", thirdHuman, null);
        humanTree.addHuman(firstHuman);
        humanTree.addHuman(secondHuman);
        humanTree.addHuman(thirdHuman);
        humanTree.addHuman(fourthHuman);
        humanTree.addHuman(fifthHuman);
    }

    @Override
    public void print() {        
        for (Human human: humanTree){
            System.out.println(human);
        }
    }

    @Override
    public void printFirst() {
            System.out.println(firstHuman.toString());              
    }

    @Override
    public void printLast() {        
        int i  = 0;
        for (Human human: humanTree){
            i++;
            if (i == humanTree.sizeHumanTree()){
            System.out.println(human);
            }
        }     
    }
}
