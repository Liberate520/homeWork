package Model;

public class Pet extends Instance{
    private static int pet_id;
    private String enterpreture;
    private String awards;
    public Pet(String record) {
        super(record);

        pet_id++;
    }


}

    
    
