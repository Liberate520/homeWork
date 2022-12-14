import java.util.List;

public class Communication {
    private Human human;
    private TypeCommunication typeCommunication;

    public Communication(Human human, TypeCommunication typeCommunication, Trees humanlist,
            List<Communication> communa_list) {
        this.human = human;
        this.typeCommunication = typeCommunication;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public TypeCommunication getTypeCommunication() {
        return typeCommunication;
    }

    public void setTypeCommunication(TypeCommunication typeCommunication) {
        this.typeCommunication = typeCommunication;
    }

    @Override
    public String toString() {
        return "Communication [human=" + human + ", typeCommunication=" + typeCommunication + "]";
    }

}
