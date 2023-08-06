package com.pamihnenkov.presenter;

import com.pamihnenkov.model.FamilyTreeMember;
import com.pamihnenkov.model.Human;
import com.pamihnenkov.model.Service;
import com.pamihnenkov.model.enums.Gender;
import com.pamihnenkov.model.enums.Relation;
import com.pamihnenkov.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Presenter<T extends FamilyTreeMember<T>> {
    private View view;
    private final Service<T> service;

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
        service.load();
    }

    public Set<String> getAllMembers(){
        return service.getAllMembers().stream().map(String::valueOf).collect(Collectors.toSet());
    }

    public void addNewMember(String surname, String name, String lastname, String birthDate, String deathDate, String gender) {
        System.out.println(deathDate == null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        T newMember = (T) new Human(UUID.randomUUID(),
                                    name,
                                    surname,
                                    lastname,
                                    LocalDate.parse(birthDate,formatter),
                                    (deathDate == null || deathDate.length() == 0) ? null : LocalDate.parse(deathDate,formatter),
                                    gender.equals("м") ? Gender.MALE : Gender.FEMALE);
        service.addNewMember(newMember);
    }

    public Set<String> getBrothersAndSisters(UUID memberId){
        return service.getBrothersAndSisters(service.getMemberById(memberId)).stream().map(T::toString).collect(Collectors.toSet());
    }

    public Map<UUID,String> getAllMembersForChooseMenu(){
        return service.getAllMembers().stream().collect(Collectors.toMap(T::getId,T::toString));
    }

    public Set<String> getRelationVariants(){
        return Arrays.stream(Relation.values()).map(String::valueOf).collect(Collectors.toSet());
    }

    public void addRelativeForPerson(UUID member, UUID relative, String relation){
        service.addRelativeForPerson(member,relative,relation);
    }

    public Set<String> getSortedByBirthdate(){
        return service.getSortedByBirthdate().stream().map(String::valueOf).collect(Collectors.toSet());
    }

    public Set<String> getSortedByAge() {
        return service.getSortedByAge().stream().map(String::valueOf).collect(Collectors.toSet());
    }

    public void finish(){
        service.save();
    }
}
