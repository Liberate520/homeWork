public class Service {
    private Tree family_tree;
    
    public Service(Tree family_tree){
        this.family_tree = family_tree;
    }

    public int addPerson(String name){
        int id = (int) System.currentTimeMillis();
        Person pers = new Person(id, name);
        this.family_tree.addPerson(pers);
        return id;
    }
}
