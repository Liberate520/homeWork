
enum Relation {
    Husband, Wife, Father, Mother, Daughter, Son, Grandma, Grandpa, Brother, Sister
}
public class Communications {
    
    private Human human_one;
    private Human human_two;
    private Relation relation;

    public Communications(Human human_one, Human human_two, Relation relation) {
        this.human_one = human_one;
        this.human_two = human_two;
        this.relation = relation;
    }

    public Human getHumanOne(){
        return this.human_one;
    }

    public Human getHumanTwo(){
        return this.human_two;
    }

    public Relation getRelation(){
        return relation;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %s for %s %s", 
                this.human_one.getFirstName(), 
                this.human_two.getLastName(),
                this.relation,
                this.human_two.getFirstName(), 
                this.human_two.getLastName());
    }
}
