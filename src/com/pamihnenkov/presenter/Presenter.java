package com.pamihnenkov.presenter;

import com.pamihnenkov.model.Human;
import com.pamihnenkov.model.Service;
import com.pamihnenkov.model.enums.Relation;
import com.pamihnenkov.view.View;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Presenter {
    private View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        service.load();
    }

    public Set<String> getAllMembers(){
        return service.getAllMembers().stream().map(String::valueOf).collect(Collectors.toSet()); //comment: Тут я только преобразую Set<Human> в Set<String> для отображения во View
    }

    public void addNewMember(String surname, String name, String lastname, String birthDate, String deathDate, String gender) {
        service.addNewMember(surname, name, lastname, birthDate, deathDate,gender);
    }

    public Set<String> getBrothersAndSisters(UUID memberId){
        return service.getBrothersAndSisters(service.getMemberById(memberId)).stream().map(Human::toString).collect(Collectors.toSet());
    }

    public Map<UUID,String> getAllMembersForChooseMenu(){
        return service.getAllMembers().stream().collect(Collectors.toMap(Human::getId,Human::toString));
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
