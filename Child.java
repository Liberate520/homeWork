package homeWork;
public class Child extends Human
{   
    public Child(String name, String surname, String patronymic, GenderType sex, int birthYear, int birthMonth, int birthDay, String spouse, String father, String mother ) 
    {
        super(name, surname, patronymic, sex, birthYear, birthMonth, birthDay, spouse, father, mother);
    }

    @Override
    public String toString() 
    {
        return super.toString();
    }
}

