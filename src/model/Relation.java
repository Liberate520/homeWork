package model;

@SuppressWarnings("ALL")
public class Relation {

    private int relationId;
    private String relation;
    private int relationPerson;
    
    public Relation(int relationsId, int relationPersonId) {
        this.relationId = relationsId;

        if (relationsId == 1){
            this.relation = "Супруг";
        }
        else if (relationsId == 2){
            this.relation = "Ребенок";
        }
        
        this.relationPerson = relationPersonId;
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

    public int getRelationPerson() {
        return relationPerson;
    }

    public void setRelationPerson(int relationPerson) {
        this.relationPerson = relationPerson;
    }
}    