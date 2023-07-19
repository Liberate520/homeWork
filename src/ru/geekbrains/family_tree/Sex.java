package ru.geekbrains.family_tree;

/**
 * Пол человека.
 */
public enum Sex {

    MALE ("мужской"),
    FEMALE ("женский");

    /**
     * Конкретный пол человека.
     */
    private String sexKind;

    Sex(String sexKind) {
        this.sexKind = sexKind;
    }

    @Override
    public String toString() {
        return sexKind;
    }

}
