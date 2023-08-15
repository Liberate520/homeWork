package ru.geekbrains.family_tree.model.family_tree;

import java.time.LocalDate;

/**
 * Член семьи, являющийся частью её рода и обязательно имеющий числовой
 * идентификатор, имя или кличку и дату рождения. Может иметь дату смерти, отца
 * или мать.
 */
public interface FamilyMember {

    /**
     * Возвращает числовой идентфикатор члена семьи.
     */
    long getIdentifier();
    
    /**
     * Возвращает имя или кличку члена семьи.
     */
    String getName();

    /**
     * Возвращает дату рождения члена семьи.
     */
    LocalDate getBirthDate();

    /**
     * Возвращает дату смерти члена семьи.
     */
    LocalDate getDeathDate();

    /**
     * Возвращает отца члена семьи.
     */
    FamilyMember getFather();

    /**
     * Возвращает мать члена семьи.
     */
    FamilyMember getMother();
    
}
