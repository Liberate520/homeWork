enum RelationAnimal {
    owner
}

public class RelationWithAnimal {

    private Human human_one;
    private Animal animal_one;
    private RelationAnimal relationAnimal;
    

    public RelationWithAnimal(Human human_one, Animal animal_one, RelationAnimal relationAnimal) {
        this.human_one = human_one;
        this.animal_one = animal_one;
        this.relationAnimal = relationAnimal;
    }
    
    public Human getHumanOne(){
        return this.human_one;
    }
    
    public Animal getAnimalOne(){
        return this.animal_one;
    }

    public RelationAnimal getRelationAnimal(){
        return this.relationAnimal;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s is %s for %s %s", 
                this.human_one.getFirstName(), 
                this.human_one.getLastName(),
                this.relationAnimal,
                this.animal_one.getTypeAnimal(),
                this.animal_one.getName());
    }
}

