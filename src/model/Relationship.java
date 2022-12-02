package model;

public class Relationship {

    private int relationsId;
    private String relation;
    private int relationToHumanId;
    
    public Relationship(int relationsId, int relationToHumanId) {
        this.relationsId = relationsId;

        if (relationsId == 1){
            this.relation = "Брак";
        }
        else if (relationsId == 2){
            this.relation = "Ребенок";
        }
        
        this.relationToHumanId = relationToHumanId;
    }

    public int getRelationsId() {
        return relationsId;
    }

    public void setRelationsId(int relationsId) {
        this.relationsId = relationsId;
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