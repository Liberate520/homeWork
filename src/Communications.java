public class Communications  {
    private Human human1;
    private Human human2;
    private String relationship;

    public Communications(Human human1, Human human2, String relationship) {
        this.human1 = human1;
        this.human2 = human2;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return human1.getFirstName() + " " + human1.getLastName() +
                " is " + relationship + " of " +
                human2.getFirstName() + " " + human2.getLastName();
    }
}
