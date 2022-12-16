package part2;

public class Main {
    public static void main(String[] args) {
        CatsFlock flock = new CatsFlock();
        Repository repository = new Repository(flock);

        repository.addCats("Пушок");
        repository.addCats("Барсик");
        repository.addCats("Тася");
        Cats newCat = repository.getCat(1);

        for (Cats cat : flock) {
            System.out.println(cat);
        }
        System.out.println();
        System.out.println(newCat);
    }
}