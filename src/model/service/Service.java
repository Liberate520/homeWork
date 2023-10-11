package model.service;

import model.familyThree.FamilyThree;

public class Service {
    private FamilyThree familyThree;

    public Service()
    {
        familyThree = new FamilyThree<>();
    }

    public String getFamilyMembers()
    {
        return familyThree.getFamilyMembers().toString();
    }

}
