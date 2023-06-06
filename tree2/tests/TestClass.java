package homeWork.tree2.tests;

import homeWork.tree2.human.HumanObjectInterface;

public class TestClass implements HumanObjectInterface {
    private int id;
    private static int nextId = 1;

    public TestClass() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return "Я тестовый класс, экземпляр №" + this.getId();
    }
}
