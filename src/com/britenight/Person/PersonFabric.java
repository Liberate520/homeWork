package com.britenight.Person;

import com.britenight.MVP.Presenter.Fabric;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PersonFabric implements Fabric<Person> {
    @Override
    public Person create(Function<Map<String, String>, Map<String, String>> prompt) {
        Map<String, String> idTitle = new HashMap<>();
        idTitle.put("id", "ID (number)");
        idTitle.put("name", "Name");
        idTitle.put("gender", "Gender (1 - Male, 2 - Female)");
        idTitle.put("dateOfBirth", "Date of birth (yyyy-MM-dd)");

        Map<String, String> idData = prompt.apply(idTitle);
        int id = Integer.parseInt((String) idData.get("id"));
        String name = (String) idData.get("name");
        Gender gender = (((String) idData.get("gender")).equals("1")) ? Gender.Male
                : (((String) idData.get("gender")).equals("2")) ? Gender.Female
                : null;
        LocalDate dateOfBirth = LocalDate.parse((String) idData.get("dateOfBirth"));

        return new Person(id, name, gender, dateOfBirth);
    }
}
