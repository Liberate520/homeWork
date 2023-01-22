package Model;

import java.io.Serializable;

public class HumanTreeOperation implements Operation, Serializable {    
    private HumanTree<Human> humanTree;
    private Human firstHuman;
    private Human secondHuman;
    private Human thirdHuman;
    private Human fourthHuman;
    private Human fifthHuman;
    private Human sixthHuman;
    private Human seventhHuman;
    FileWorker fileWorkerHumanTree;
    
    public HumanTreeOperation() {        
        this.humanTree = new HumanTree<>();
        this.fileWorkerHumanTree = new FileWorker();
        this.firstHuman = new Human("Romanov Michael Fedorovich", "1596-1645", "1613-1645", null, null);
        this.secondHuman = new Human("Streshneva Evdokiya Lukyanovna", "1608-1645", null, null, null);
        this.thirdHuman = new Human("Romanov Alexey Michaelevich", "1629-1676", "1645-1676", firstHuman, secondHuman);
        this.fourthHuman = new Human("Romanov Fedor Alexeevich", "1661-1682", "1676-1682", thirdHuman, null);
        this.fifthHuman = new Human("Romanova Sofia Alexeevna", "1657-1704", "1682-1689", thirdHuman, null);
        this.sixthHuman = new Human("Narishkina Nataliya Kirillovna", "1651-1694", null, null, null);
        this.seventhHuman = new Human("Romanov Petr 1 Alexeevich", "1672-1725", "1682-1725", thirdHuman, sixthHuman);
        humanTree.addHuman(firstHuman);
        humanTree.addHuman(secondHuman);
        humanTree.addHuman(thirdHuman);
        humanTree.addHuman(fourthHuman);
        humanTree.addHuman(fifthHuman);
        humanTree.addHuman(sixthHuman);
        humanTree.addHuman(seventhHuman);
        firstHuman.addChild(thirdHuman);
        thirdHuman.addChild(fourthHuman);
        thirdHuman.addChild(fifthHuman);
        thirdHuman.addChild(seventhHuman);
    }

    @Override
    public void printConsole() {        
        for (Human human: humanTree){
            System.out.println(human);
        }
    }

    @Override
    public void printFile() {        
        fileWorkerHumanTree.write(humanTree, "human.txt");
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
            if (i == humanTree.sizeHumanList()){
            System.out.println(human);
            }
        }     
    }

    @Override
    public void printFirstChild() {        
        firstHuman.getChild();        
    }

    @Override
    public void printLastSistBroth() {
        int i  = 0;
        for (Human human: humanTree){
            i++;
            if (i == humanTree.sizeHumanList()){
            System.out.println(human.getSistBroth());
            }
        }     
        
    }

    @Override
    public void printLastFather() {
        int i  = 0;
        for (Human human: humanTree){
            i++;
            if (i == humanTree.sizeHumanList()){
            System.out.println(human.getFather());
            }
        }     
    }

    @Override
    public void printLastMother() {
        int i  = 0;
        for (Human human: humanTree){
            i++;
            if (i == humanTree.sizeHumanList()){
            System.out.println(human.getMother());
            }
        }     
    }

    
}
