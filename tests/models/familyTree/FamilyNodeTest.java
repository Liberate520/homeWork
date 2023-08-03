package models.familyTree;

import models.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static models.Gender.MALE;
import static models.Roles.*;
import static org.junit.jupiter.api.Assertions.*;

class FamilyNodeTest {
    private FamilyNode node;
    private Human human;
    private Human human2;

    @BeforeEach
    void setUp() {
        this.node = new FamilyNode();
        human = new Human("Pavel", "XXX", MALE, LocalDate.of(2022, 1, 15));
        human2 = new Human("Andrey", "XXX", MALE, LocalDate.of(2022, 1, 15));
        this.node.addMember(human, FATHER);
    }

    @Test
    void findHuman() {
        assertTrue(node.findHuman(human));
        assertFalse(node.findHuman(human2));
    }

    @Test
    void getHumanRoleOrNull() {
        assertEquals(FATHER, node.getHumanRoleOrNull(human));
        assertNull(node.getHumanRoleOrNull(human2));
    }

    @Test
    void checkHumanRole() {
        assertTrue(node.checkHumanRole(human, FATHER));
        assertFalse(node.checkHumanRole(human, MOTHER));
    }

    @Test
    void addToUpRelatives() {
        FamilyNode newNode = new FamilyNode();
        this.node.addToUpRelatives(FATHER, newNode);

        assertFalse(this.node.getUpRelatives().isEmpty());
        assertTrue(this.node.getUpRelatives().containsValue(newNode));
    }

    @Test
    void delFromRelatives() {
        FamilyNode newNode = new FamilyNode();
        this.node.addToUpRelatives(FATHER, newNode);
        this.node.delFromRelatives(FATHER, newNode);

        assertTrue(this.node.getUpRelatives().isEmpty());
        assertFalse(this.node.getUpRelatives().containsValue(newNode));
    }

    @Test
    void addToChildrenFamilies() {
        FamilyNode newNode = new FamilyNode();
        this.node.addToChildrenFamilies(DAUGHTER, newNode);

        assertFalse(this.node.getChildrenFamilies().isEmpty());
        assertTrue(this.node.getChildrenFamilies().containsValue(newNode));
    }

    @Test
    void delFromChildrenFamilies() {
        FamilyNode newNode = new FamilyNode();
        this.node.addToChildrenFamilies(DAUGHTER, newNode);
        this.node.delFromChildrenFamilies(DAUGHTER, newNode);

        assertTrue(this.node.getChildrenFamilies().isEmpty());
        assertFalse(this.node.getChildrenFamilies().containsValue(newNode));
    }

    @Test
    void delMember() {
        node.delMember(human, FATHER);

        assertNull(node.getFatherOrNull());
    }

    @Test
    void getMother() {
        node.addMember(human, MOTHER);
        assertEquals(human, node.getMotherOrNull());
    }

    @Test
    void getFather() {
        assertEquals(human, node.getFatherOrNull());
    }

    @Test
    void getChildren() {
        node.addMember(human2, DAUGHTER);

        List<Human> list = node.getChildren();

        assertEquals(1, list.size());
        assertTrue(list.contains(human2));
    }

    @Test
    void getParents() {
        node.addMember(human2, MOTHER);

        List<Human> list = node.getParents();

        assertEquals(2, list.size());
        assertTrue(list.contains(human));
        assertTrue(list.contains(human2));
    }
}