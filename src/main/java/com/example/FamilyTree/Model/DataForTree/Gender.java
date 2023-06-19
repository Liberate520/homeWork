package com.example.FamilyTree.Model.DataForTree;

public enum Gender {
    male("male"),
    female("female");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
