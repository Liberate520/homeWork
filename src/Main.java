public class Main {
    public static void main(String[] args) {
        GenealogicalTree ivanovTree = new Tree();

        TreeElement treeElement1 = new TreeElement("Александр Иванов", Gender.male);
        TreeElement treeElement2 = new TreeElement("Пётр Иванов", Gender.male);
        TreeElement treeElement3 = new TreeElement("Иван Иванов", Gender.male);
        TreeElement treeElement4 = new TreeElement("Анастасия Иванова", Gender.female);

        ivanovTree.addElement(treeElement1);
        ivanovTree.addElement(treeElement2);
        ivanovTree.addElement(treeElement3);
        ivanovTree.addElement(treeElement4);

        treeElement4.addConnection(treeElement1, FamilyConnectionType.son);
        treeElement4.addConnection(treeElement2, FamilyConnectionType.son);
        treeElement3.addConnection(treeElement1, FamilyConnectionType.son);
        treeElement3.addConnection(treeElement2, FamilyConnectionType.son);

        treeElement1.showConnection(FamilyConnectionType.father);
        System.out.println(ivanovTree);
    }
}