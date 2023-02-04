package Model;

import java.io.Serializable;

public class HumanTreeOperation implements Operation, Serializable {
    private HumanTree<Human> humanTree;
    FileWorker fileWorkerHumanTree;

    public HumanTreeOperation() {
        this.humanTree = new HumanTree<>();
        this.fileWorkerHumanTree = new FileWorker();
        Human firstHuman = new Human("Romanov Michael Fedorovich", "1596-1645", "1613-1645", null, null);
        Human secondHuman = new Human("Streshneva Evdokiya Lukyanovna", "1608-1645", null, null, null);
        Human thirdHuman = new Human("Romanov Alexey Michaylovich", "1629-1676", "1645-1676", firstHuman, secondHuman);
        Human fourthHuman = new Human("Miloslavskaya Mariya Ilyinichna", "1624-1669", null, null, null);
        Human fifthHuman = new Human("Narishkina Nataliya Kirillovna", "1651-1694", null, null, null);
        Human sixthHuman = new Human("Romanov Fedor Alexeevich", "1661-1682", "1676-1682", thirdHuman, fourthHuman);
        Human seventhHuman = new Human("Romanova Sofia Alexeevna", "1657-1704", "1682-1689", thirdHuman, fourthHuman);
        Human eighthHuman = new Human("Romanov Ivan V Alexeevich", "1666-1696", "1682-1696", thirdHuman, fourthHuman);
        Human ninthHuman = new Human("Saltikova Praskoviya Fedorovna", "1664-1723", null, null, null);
        Human tenthHuman = new Human("Romanov Petr I Alexeevich", "1672-1725", "1682-1725", thirdHuman, fifthHuman);
        Human eleventhHuman = new Human("Lopuhina Evdokiya Fedorovna", "1669-1731", null, null, null);
        Human twelfthHuman = new Human("Mihaylova Ekaterina I Alexeevna", "1684-1727", "1725-1727", null, null);
        Human thirteenthHuman = new Human("Romanov Aleksey Petrovich", "1690-1718", null, tenthHuman, eleventhHuman);
        Human fourteenthHuman = new Human("Romanova Anna Petrovna", "1708-1728", null, tenthHuman, twelfthHuman);
        Human fiveteenthHuman = new Human("Romanov Petr II Alekseevich", "1715-1730", "1727-1730", thirteenthHuman,
                null);
        Human sixteenthHuman = new Human("Romanova Anna Ivanovna", "1693-1740", "1730-1740", eighthHuman, ninthHuman);
        Human seventeenthHuman = new Human("Romanova Ekaterina Ivanovna", "1691-1733", null, eighthHuman, ninthHuman);
        Human eighteenthHuman = new Human("Romanova Anna Leopoldovna", "1718-1746", null, null, seventeenthHuman);
        Human nineteenthHuman = new Human("Romanov Ivan VI Antonovich", "1740-1764", "1740-1741", null,
                eighteenthHuman);
        Human twentiethHuman = new Human("Romanova Elizaveta Petrovna", "1709-1762", "1741-1761", tenthHuman,
                twelfthHuman);
        Human twentyfirstHuman = new Human("Romanov Petr III Fedorovich", "1728-1762", "1761-1762", null,
                fourteenthHuman);
        Human twentysecondHuman = new Human("Ekaterina II Alekseevna", "1729-1796", "1762-1796", null, null);
        Human twentythirdHuman = new Human("Romanov Pavel I Petrovich", "1754-1801", "1796-1801", twentyfirstHuman,
                twentysecondHuman);
        Human twentyfourthHuman = new Human("Mariya Fedorovna", "1759-1828", null, null, null);
        Human twentyfifthHuman = new Human("Romanov Aleksandr I Pavlovich", "1777-1825", "1801-1825", twentythirdHuman,
                twentyfourthHuman);
        Human twentysixthHuman = new Human("Romanov Nikolay I Pavlovich", "1796-1855", "1825-1855", twentythirdHuman,
                twentyfourthHuman);
        Human twentyseventhHuman = new Human("Romanov Aleksandr II Nikolaevich", "1818-1881", "1855-1881",
                twentysixthHuman, null);
        Human twentyeighthHuman = new Human("Romanov Aleksandr III Aleksandrovich", "1845-1894", "1881-1894",
                twentyseventhHuman, null);
        Human twentyninthHuman = new Human("Romanov Nikolay II Aleksandrovich", "1868-1917", "1894-1917",
                twentyeighthHuman, null);

        humanTree.addHuman(firstHuman); 
        humanTree.addHuman(secondHuman);
        humanTree.addHuman(thirdHuman);
        humanTree.addHuman(fourthHuman);
        humanTree.addHuman(fifthHuman);
        humanTree.addHuman(sixthHuman);
        humanTree.addHuman(seventhHuman);
        humanTree.addHuman(eighthHuman);
        humanTree.addHuman(ninthHuman);
        humanTree.addHuman(tenthHuman);
        humanTree.addHuman(eleventhHuman);
        humanTree.addHuman(twelfthHuman);
        humanTree.addHuman(thirteenthHuman);
        humanTree.addHuman(fourteenthHuman);
        humanTree.addHuman(fiveteenthHuman);
        humanTree.addHuman(sixteenthHuman);
        humanTree.addHuman(seventeenthHuman);
        humanTree.addHuman(eighteenthHuman);
        humanTree.addHuman(nineteenthHuman);
        humanTree.addHuman(twentiethHuman);
        humanTree.addHuman(twentyfirstHuman);
        humanTree.addHuman(twentysecondHuman);
        humanTree.addHuman(twentythirdHuman);
        humanTree.addHuman(twentyfourthHuman);
        humanTree.addHuman(twentyfifthHuman);
        humanTree.addHuman(twentysixthHuman);
        humanTree.addHuman(twentyseventhHuman);
        humanTree.addHuman(twentyeighthHuman);
        humanTree.addHuman(twentyninthHuman);

        firstHuman.addChild(thirdHuman);
        secondHuman.addChild(thirdHuman);
        thirdHuman.addChild(sixthHuman);
        thirdHuman.addChild(seventhHuman);
        thirdHuman.addChild(eighthHuman);
        thirdHuman.addChild(tenthHuman);
        fourthHuman.addChild(sixthHuman);
        fourthHuman.addChild(seventhHuman);
        fourthHuman.addChild(eighthHuman);
        fifthHuman.addChild(tenthHuman);
        eighthHuman.addChild(sixteenthHuman);
        eighthHuman.addChild(seventeenthHuman);
        ninthHuman.addChild(sixteenthHuman);
        ninthHuman.addChild(seventeenthHuman);
        tenthHuman.addChild(thirteenthHuman);
        tenthHuman.addChild(fourteenthHuman);
        tenthHuman.addChild(twentiethHuman);
        eleventhHuman.addChild(thirteenthHuman);
        twelfthHuman.addChild(fourteenthHuman);
        twelfthHuman.addChild(twentiethHuman);
        thirteenthHuman.addChild(fiveteenthHuman);
        fourteenthHuman.addChild(twentyfirstHuman);
        seventeenthHuman.addChild(eighteenthHuman);
        eighteenthHuman.addChild(nineteenthHuman);
        twentyfirstHuman.addChild(twentythirdHuman);
        twentysecondHuman.addChild(twentythirdHuman);
        twentythirdHuman.addChild(twentyfifthHuman);
        twentythirdHuman.addChild(twentysixthHuman);
        twentyfourthHuman.addChild(twentyfifthHuman);
        twentyfourthHuman.addChild(twentysixthHuman);
        twentysixthHuman.addChild(twentyseventhHuman);
        twentyseventhHuman.addChild(twentyeighthHuman);
        twentyeighthHuman.addChild(twentyninthHuman);
    }

    @Override
    public void printConsole() {
        int i = 1;
        for (Human human : humanTree) {
            System.out.println(i + ". " + human);
            i++;
        }
    }

    @Override
    public void printFile() {
        fileWorkerHumanTree.write(humanTree, "human.txt");
    }
    
    @Override
    public void sortHumanByBirth() {
        humanTree.sortByBirth();
        int i = 1;
        for (Human human : humanTree) {
            System.out.println(i + ". " + human);
            i++;
        }        
    }

    @Override
    public void sortHumanByName() {
        humanTree.sortByName();
        int i = 1;
        for (Human human : humanTree) {
            System.out.println(i + ". " + human);
            i++;
        }        
    }

    @Override
    public void printHuman(int order) {
        int i = 0;
        for (Human human : humanTree) {
            i++;
            if (i == order) {
                System.out.println(human.toString());
            }
        }
    }

    @Override
    public void printHumanChild(int order) {
        int i = 0;
        for (Human human : humanTree) {
            i++;
            if (i == order) {
                human.getChild();
            }
        }
    }

    @Override
    public void printHumanSistBroth(int order) {
        int i = 0;
        for (Human human : humanTree) {
            i++;
            if (i == order) {
                System.out.println(human.getSistBroth());
            }
        }
    }

    @Override
    public void printHumanFather(int order) {
        int i = 0;
        for (Human human : humanTree) {
            i++;
            if (i == order) {
                System.out.println(human.getFather());
            }
        }
    }

    @Override
    public void printHumanMother(int order) {
        int i = 0;
        for (Human human : humanTree) {
            i++;
            if (i == order) {
                System.out.println(human.getMother());
            }
        }
    }

    @Override
    public boolean orderCheck(int order) {
        if (order > 0 && order <= humanTree.sizeHumanList()) {
            return true;
        } else {
            return false;
        }
    }
}
