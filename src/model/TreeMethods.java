package model;

public class TreeMethods {
//    private List<Tree> treeList;

    public TreeMethods() {
//        this.treeList = new ArrayList<>();
    }


    public Tree<TreePerson> newTree(){
        Tree<TreePerson> newTree = new Tree<>();
//        treeList.add(newTree);
        return newTree;
    }

    public void add(TreePerson obj, Tree tree){
        tree.add(obj);
    }

    public void findOfName (String name, Tree tree){
        Human humanLink;
        int index = 0;
        for (Object person : tree.getHumanList()) { // Почему не даёт сразу Human?
            String p = person.toString();
            System.out.println(p);
            System.out.println(name);
            System.out.println(p == name); // не проходит сравнение с переданой строкой.
        }
//        return humanLink;
    }
}
