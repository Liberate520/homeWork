import models.Human;
import models.familyTree.FamilyNode;
import models.familyTree.FamilyTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static models.Gender.FEMALE;
import static models.Gender.MALE;
import static models.Roles.DAUGHTER;
import static models.Roles.MOTHER;
import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    private FamilyService service;
    private Human human;
    private Human human2;
    private FamilyNode node;

    @BeforeEach
    void setUp() {
        this.service = new FamilyService(new FamilyTree());
        human = new Human("Pavel", "XXX", MALE, LocalDate.of(2022, 1, 15));
        human2 = new Human("Irina", "XXX", FEMALE, LocalDate.of(2022, 1, 15));
        this.node = service.createNewFamily(human);
    }

    @Test
    void createNewFamily() {
        assertTrue(service.containsFamily(node));
    }

    @Test
    void deleteFamily() {
        service.deleteFamily(human);

        assertFalse(service.containsFamily(node));
    }

    @Test
    void addMemberToFamily() {
        service.addMemberToFamily(human, human2, MOTHER);

        assertTrue(node.findHuman(human2));
    }

    @Test
    void delMemberFromFamily() {
        service.addMemberToFamily(human, human2, MOTHER);
        service.delMemberFromFamily(human, human2, MOTHER);

        assertFalse(node.findHuman(human2));
    }

    @Test
    void getChildren() {
        service.addMemberToFamily(human, human2, MOTHER);
        Human human3 = new Human("Anna", "XXX", FEMALE, LocalDate.of(2022, 1, 15));
        service.addMemberToFamily(human, human3, DAUGHTER);

        List<Human> list = service.getChildren(human);

        assertEquals(1, list.size());
        assertTrue(list.contains(human3));
    }

    @Test
    void getParents() {
        service.addMemberToFamily(human, human2, MOTHER);

        List<Human> list = service.getParents(human);

        assertEquals(2, list.size());
        assertTrue(list.contains(human2));
    }
}