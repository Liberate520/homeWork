class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Михаил", "Федорович", "Романов", "1613", "1645");
        Person person2 = new Person("Евдокия", "Лукьяновна","Стрешнева", "нет данных", "нет данных");
        Person person3 = new Person("Алексей", "Михайлович","Романов", "1645", "1676");

        person1.addChild(person3);
        person2.addChild(person3);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);

        familyTree.printChildren(person1);
        familyTree.printChildren(person2);
    }
}
