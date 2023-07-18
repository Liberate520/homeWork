package family_tree.model.registry_office;

import family_tree.model.human.Human;
import family_tree.model.infrastucture.try_catch.TryLong;
import family_tree.model.tree.FamilyTree;
import family_tree.presenter.Presenter;

public class Get_person {

    private final TryLong tryLong;

    public Get_person() {
        tryLong = new TryLong();
    }


    public long get_person_id(String message, FamilyTree<Human> family_tree){
        String str = new Presenter().send_request(message + " - введите id: ");
        long id_person = tryLong.try_long(str);
        try {
            family_tree.getById(id_person);
        } catch (Exception e){
            id_person = -1;
        }
        if (id_person > -1) {
            new Presenter().send_info(message + ": " + family_tree.getById(id_person));
        }
        return id_person;
    }
}
