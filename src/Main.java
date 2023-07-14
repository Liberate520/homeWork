import java.time.LocalDate;

import GenerationTree.Person.PersonIdGenerator;
import GenerationTree.Person.PersonService;
import GenerationTree.Structs.Gender;

public class Main {
    public static void main(String[] args) {

        ConsoleManager cmdManager = new ConsoleManager();

        var idGenerator = new PersonIdGenerator();
        var betaFamily = new PersonService("Бетта", idGenerator);
        var testFamily = new PersonService("Тестюк", idGenerator);

        int annaId = betaFamily.addPerson("Анна", Gender.FEMALE, LocalDate.of(1970, 1, 1));
        int romanId = betaFamily.addPerson("Рома", Gender.MALE, LocalDate.of(1994, 11, 14));
        int lizaId = betaFamily.addPerson("Елизавета", Gender.FEMALE, LocalDate.of(1997, 1, 12));
        int danilId = betaFamily.addPerson("Даниил", Gender.MALE, LocalDate.of(2017, 3, 13));
        int dariaId = betaFamily.addPerson("Даша", Gender.FEMALE, LocalDate.of(2016, 1, 1));

        betaFamily.addChild(annaId, romanId);
        betaFamily.addChild(annaId, lizaId);
        betaFamily.addChild(romanId, danilId);
        betaFamily.addChild(romanId, dariaId);

        int mariaId = testFamily.addPerson("Маша", Gender.FEMALE, LocalDate.of(1971, 4, 1));
        int ivanId = testFamily.addPerson("Иван", Gender.MALE, LocalDate.of(1996, 12, 15));
        int alanId = testFamily.addPerson("Алан", Gender.MALE, LocalDate.of(2017, 3, 16));

        testFamily.addChild(mariaId, ivanId);
        testFamily.addChild(ivanId, alanId);

        testFamily.addSpouse(ivanId, betaFamily.getPersonById(lizaId), LocalDate.of(2021, 1, 25));

        int katiaId = testFamily.addPerson("Катя", Gender.FEMALE, LocalDate.of(2022, 2, 17));
        testFamily.addChild(ivanId, katiaId);

        cmdManager.PrintText(betaFamily.getDescendantsOfPerson(annaId));

    }
}