public interface Doable<T> {
    public void addRelation(T human1, T human2, Relations relation1, Relations relation2);
    public void addPerson(T human1);
    public void search(String name);
    public String print();
    public void sortByFirstName();
    public void sortByAge();
}
