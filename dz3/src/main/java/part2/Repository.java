package part2;

public class Repository {
    private CatsFlock flock;
    private static int id;

    public Repository(CatsFlock flock) {
        id = 0;
        this.flock = flock;
    }

    public void addCats(String name) {
        Cats cat = new Cats(id++, name);
        flock.addCats(cat);
    }
    public Cats getCat(int id) {
        return flock.getCat(id);
    }
}