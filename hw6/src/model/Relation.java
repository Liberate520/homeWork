package model;

public class Relation {
    private int relationId;
    private String relation;
    private int relationHuman;

    public Relation(int relationId, int humanId){
        this.relationId = relationId;
        if (relationId == 1){
            this.relation = "Married";
        } else if(relationId == 2){
            this.relation = "Parant";
        }
        this.relationHuman = humanId;
    }

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRelationHuman() {
        return relationHuman;
    }

    public void setRelationHuman(int relationHuman) {
        this.relationHuman = relationHuman;
    }
}
