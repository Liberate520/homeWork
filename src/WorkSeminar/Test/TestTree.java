package WorkSeminar.Test;

import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;
import WorkSeminar.model.Service.Service;
import WorkSeminar.model.Tree.Tree;

import java.time.LocalDate;

public class TestTree {
    public Tree test (){
        Service service = new Service();

        Persona one = service.addPersona("Граф", "Грэй", Gender.Male, LocalDate.of(1990, 2, 22));
        Persona two = service.addPersona("Графиня", "Грэй", Gender.Female, LocalDate.of(1988, 6, 1));
        service.setWedding(one, two);

        Persona Three = service.addPersona("Старший сын", "Грэй", Gender.Male, LocalDate.of(2010, 1, 5));
        Persona Four = service.addPersona("Старшая дочь", "Грэй", Gender.Female, LocalDate.of(2009, 5, 1));
        Persona Five = service.addPersona("Младший сын", "Грэй", Gender.Male, LocalDate.of(2015, 3, 17));

        service.addParent(one, two, Three);
        service.addParent(one, two, Four);
        service.addParent(one, two, Five);
        //TODO Добавить метод присовения детей сразу двум родителям.
        service.addKid(one, Three);
        service.addKid(two, Three);
        service.addKid(one, Four);
        service.addKid(two, Four);
        service.addKid(one, Five);
        service.addKid(two, Five);

        return service.getTree();

    }

}
