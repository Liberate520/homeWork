package Homework1.homeWork;

public class Main {
    Human human1 = new Human("Олег", Gender.Male, 1970);
    Human human2 = new Human("Ольга", Gender.Female, 1973);
    Human human3 = new Human("Петя", Gender.Male, 1999);
    human1.SetParent();
    human2.SetParent();
    human3.SetChild();
}