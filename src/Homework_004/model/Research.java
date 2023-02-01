package Homework_004.model;

import java.util.ArrayList;
import java.util.List;

public class Research {

    private FamilyTree ft;
    private Human person;

    public Research(FamilyTree ft, Human person) {
        this.ft = ft;
        this.person=person;

    }
    
    public List<Human> getBrothers(){
        List<Human> mens = this.ft.getHumansByGender("м");
        List<Human> humans = this.ft.getAll();
        List<Integer> parent_ids = this.person.getRelatives('p');
        int person_id = this.person.getId();
        List<Integer> children_ids = new ArrayList<>();   

        for ( Human human : humans) {
            for (Integer parent_id: parent_ids) {
                if (parent_id == human.getId()){
                    for (Integer ch_id : human.getRelatives('c')) {
                        children_ids.add(ch_id);
                    }
                }
            }
        }
        List<Human> brothers = new ArrayList<>();   
        for ( Human human : mens) {
            for (int ch_id : children_ids) {
                if(human.getId()==ch_id && ch_id!= person_id) {
                    brothers.add(human);
                }
            }
        }
        return brothers;
   }

}
