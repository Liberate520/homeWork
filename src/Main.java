import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Person mikhailI = new Person("Романов Михаил Федорович", "мужской", 1596, 1645);

        Person evdokiaStreshneva = new Person("Стрешнева Евдокия Лукьяновна", "женский");
        evdokiaStreshneva.setDateOfDeath(1645);
        Person mariaDolgorukova = new Person("Долгорукова Мария Владимировна", "женский");
        mariaDolgorukova.setDateOfDeath(1625);

        Person alexeyI = new Person("Романов Алексей Михайлович", "мужской", 1629, 1676);
        Person mariaMiloslavskaya = new Person("Милославская Мария Ильинична", "женский");
        Person natalyaNaryshkina = new Person("Нарышкина Наталья Кирилловна", "женский");

        Person irinaRomanova = new Person("Романова Ирина Михайловна", "женский", 1627, 1679);
        Person pelageyaRomanova = new Person("Романова Пелагея Михайловна", "женский", 1628, 1629);
        Person annaRomanova = new Person("Романова Анна Михайловна", "женский", 1630, 1692);
        Person marfaRomanova = new Person("Романова Марфа Михайловна", "женский", 1631, 1632);
        Person sofyaRomanova = new Person("Романова Софья Михайловна", "женский", 1634, 1636);
        Person tatyanaRomanova = new Person("Романова Татьяна Михайловна", "женский", 1636, 1706);
        Person evdokiyaRomanova = new Person("Романова Евдокия Михайловна", "женский", 1637);
        Person vasiliyRomanov = new Person("Романов Василий Михайлович", "мужской", 1639);


        Person marfaApraksina = new Person("Апраксина Марфа Матвеевна", "женский");

        Person praskovyaSaltykova = new Person("Салтыкова Прасковья Федоровна", "женский");
        Person evdokiyaLopukhina = new Person("Лопухина Евдокия Федоровна", "женский");

        Person alexeyAlexeevich = new Person("Романов Алексей Алексеевич", "мужской", 1654, 1670);
        Person evdokiyaAlexeevna = new Person("Романова Евдокия Алексеевна", "женский", 1650, 1712);
        Person dmitryAlexeevich = new Person("Романов Дмитрий Алексеевич", "мужской", 1648, 1649);
        Person marfaAlexeevna = new Person("Романова Марфа Алексеевна", "женский", 1652, 1707);
        Person sofyaAlexeevna = new Person("Романова Софья Алексеевна", "женский", 1657, 1704);
        Person ekaterinaAlexeevna = new Person("Романова Екатерина Алексеевна", "женский", 1658, 1718);
        Person mariaAlexeevna = new Person("Романова Мария Алексеевна", "женский", 1660, 1723);
        Person fedorAlexeevich = new Person("Романов Федор Алексеевич", "мужской", 1676, 1682);
        Person simeonAlexeevich = new Person("Романов Федор Алексеевич", "мужской", 1665, 1669);
        Person feodosiyaAlexeevna = new Person("Романова Феодосия Алексеевна", "женский", 1662, 1713);
        Person ioanV = new Person("Романов Иоан V Алексеевич", "мужской", 1666, 1696);
        Person evdokiyaAlexeevna2 = new Person("Романова Евдокия Алексеевна", "женский", 1669);

        Person petrI = new Person("Романов Петр I Алексеевич", "мужской", 1682, 1725);
        Person ekaterinaI = new Person("Романова Екатерина I Алексеевна", "женский", 1725, 1727);
        Person natalyaAlexeevna = new Person("Романова Наталья Алексеевна", "женский", 1673, 1716);
        Person feodoraAlexeevna = new Person("Романова Феодора Алексеевна", "женский", 1674, 1678);


        FamilyTree people = new FamilyTree();

//        ADD PEOPLE TO TREE

        people.addPerson(mikhailI);
        people.addPerson(evdokiaStreshneva);
        people.addPerson(mariaDolgorukova);
        people.addPerson(alexeyI);
        people.addPerson(mariaMiloslavskaya);
        people.addPerson(natalyaNaryshkina);
        people.addPerson(irinaRomanova);
        people.addPerson(pelageyaRomanova);
        people.addPerson(annaRomanova);
        people.addPerson(marfaRomanova);
        people.addPerson(sofyaRomanova);
        people.addPerson(tatyanaRomanova);
        people.addPerson(evdokiyaRomanova);
        people.addPerson(vasiliyRomanov);
        people.addPerson(alexeyAlexeevich);
        people.addPerson(evdokiyaAlexeevna);
        people.addPerson(dmitryAlexeevich);
        people.addPerson(marfaAlexeevna);
        people.addPerson(sofyaAlexeevna);
        people.addPerson(ekaterinaAlexeevna);
        people.addPerson(mariaAlexeevna);
        people.addPerson(fedorAlexeevich);
        people.addPerson(simeonAlexeevich);
        people.addPerson(feodosiyaAlexeevna);
        people.addPerson(ioanV);
        people.addPerson(evdokiyaAlexeevna2);
        people.addPerson(petrI);
        people.addPerson(ekaterinaI);
        people.addPerson(natalyaAlexeevna);
        people.addPerson(feodoraAlexeevna);


//        SET SPOUSES
        people.addSpouse(mikhailI, mariaDolgorukova);
        people.addSpouse(mikhailI, evdokiaStreshneva);

        people.addSpouse(alexeyI, mariaMiloslavskaya);
        people.addSpouse(alexeyI, natalyaNaryshkina);

        people.addSpouse(fedorAlexeevich, marfaApraksina);

        people.addSpouse(ioanV, praskovyaSaltykova);

        people.addSpouse(petrI, evdokiyaLopukhina);
        people.addSpouse(petrI, ekaterinaI);


//        SET CHILDRENS
        people.addChildrens(mikhailI, evdokiaStreshneva, irinaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, pelageyaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, alexeyI);
        people.addChildrens(mikhailI, evdokiaStreshneva, annaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, marfaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, sofyaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, tatyanaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, evdokiyaRomanova);
        people.addChildrens(mikhailI, evdokiaStreshneva, vasiliyRomanov);

        people.addChildrens(alexeyI, mariaMiloslavskaya, alexeyAlexeevich);
        people.addChildrens(alexeyI, mariaMiloslavskaya, evdokiaStreshneva);
        people.addChildrens(alexeyI, mariaMiloslavskaya, dmitryAlexeevich);
        people.addChildrens(alexeyI, mariaMiloslavskaya, marfaAlexeevna);
        people.addChildrens(alexeyI, mariaMiloslavskaya, sofyaAlexeevna);
        people.addChildrens(alexeyI, mariaMiloslavskaya, ekaterinaAlexeevna);
        people.addChildrens(alexeyI, mariaMiloslavskaya, mariaAlexeevna);
        people.addChildrens(alexeyI, mariaMiloslavskaya, fedorAlexeevich);
        people.addChildrens(alexeyI, mariaMiloslavskaya, simeonAlexeevich);
        people.addChildrens(alexeyI, mariaMiloslavskaya, feodosiyaAlexeevna);
        people.addChildrens(alexeyI, mariaMiloslavskaya, ioanV);
        people.addChildrens(alexeyI, mariaMiloslavskaya, evdokiyaAlexeevna2);

        people.addChildrens(alexeyI, natalyaNaryshkina, petrI);
        people.addChildrens(alexeyI, natalyaNaryshkina, ekaterinaI);
        people.addChildrens(alexeyI, natalyaNaryshkina, natalyaAlexeevna);
        people.addChildrens(alexeyI, natalyaNaryshkina, feodoraAlexeevna);

        people.manageParents();
//        people.printFamilyTree();

        System.out.println(alexeyI.getSpouse());
//        System.out.println(alexeyAlexeevich.getFather());
    }
}
