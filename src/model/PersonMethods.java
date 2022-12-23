package model;

import java.util.ArrayList;
import java.util.List;

public class PersonMethods {

    public PersonMethods() {
    }

    public Human newHuman(String name, int gender){
        Human newHuman = new Human(name, gender);
        return newHuman;
    }

    public void createLink(TreePerson first, TreePerson second, int tipeLink){
        new Link(first, second, tipeLink);
    }

    public void getAllLink(Human person){
        getAllLink(person, 'a');
    }

    public List<Link> getAllLink(Human person, Character filter){
        if (filter == 'a'){
            return person.getLink();
        }

        List<Link> filteredLink = new ArrayList<>();
        for (Link item : person.getLink()) {
            switch (filter) {
                case 'c': // для фильтра по Children
                    if (item.getTipeLink()/100 == 4) filteredLink.add(item);
                    break;
            }
        }
        return filteredLink;
    }


}
