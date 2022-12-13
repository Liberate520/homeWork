package model;

public class Relation {

    private int relationId;
    private String relation;
    private int relationToHumanId;
    
    public Relation(int relationsId, int relationToHumanId) {
        this.relationId = relationsId;

        if (relationsId == 1){
            this.relation = "Брак";
        }
        else if (relationsId == 2){
            this.relation = "Ребенок";
        }
        
        this.relationToHumanId = relationToHumanId;
    }

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationsId) {
        this.relationId = relationsId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRelationToHumanId() {
        return relationToHumanId;
    }

    public void setRelationToHumanId(int relationToHumanId) {
        this.relationToHumanId = relationToHumanId;
    }
}    