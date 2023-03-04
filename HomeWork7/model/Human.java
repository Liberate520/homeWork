package HomeWork7.model;

public class Human extends Animale
{
    public Human(String name, String sex, int age) 
    {
        super(name, sex, age);     
    }

    public Human(String name, String sex, int age, Animale mather, Animale father) 
    {
        super(name, sex, age, mather, father);
    }

    public void saveObj(IO save)
    {
        save.save("FreeFamily.data", this);
    }

}