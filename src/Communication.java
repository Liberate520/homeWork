public class Communication {
    private Human human1;
    private Human human2;
    private TypeCommunication typeCommunication;

    public Communication(Human human1, Human human2, TypeCommunication typeCommunication) {
        this.human1 = human1;
        this.human2 = human2;
        this.typeCommunication = typeCommunication;
    }

    public Human getHuman1() {
        return human1;
    }

    public void setHuman1(Human human) {
        this.human1 = human;
    }

    public void setHuman2(Human human2) {
        this.human2 = human2;
    }

    public Human getHuman2() {
        return human2;
    }

    public TypeCommunication getTypeCommunication() {
        return typeCommunication;
    }

    public void setTypeCommunication(TypeCommunication typeCommunication) {
        this.typeCommunication = typeCommunication;
    }

    @Override
    public String toString() {
        return "Communication [name=>" + human1.getName() + ", surname=>" + human1.getSurname() + 
                            "name=>" + human2.getName() + ", surname=>" + human2.getSurname() 
                            + ", typeCommunication=" + getTypeCommunication()
                + "]";
    }
}
