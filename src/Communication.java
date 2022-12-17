public class Communication {
    private Human human1;
    private Human human2;
    private TypeCommunication typeCommunicationHuman1;
    private TypeCommunication typeCommunicationHuman2;

    public Communication(Human human1, Human human2, TypeCommunication typeCommunicationHuman1,
            TypeCommunication typeCommunicationHuman2) {
        this.human1 = human1;
        this.typeCommunicationHuman1 = typeCommunicationHuman1;
        this.human2 = human2;
        this.typeCommunicationHuman2 = typeCommunicationHuman2;
    }

    public void setTypeCommunicationHuman1(TypeCommunication typeCommunicationHuman1) {
        this.typeCommunicationHuman1 = typeCommunicationHuman1;
    }

    public TypeCommunication getTypeCommunicationHuman1() {
        return typeCommunicationHuman1;
    }

    public void setTypeCommunicationHuman2(TypeCommunication typeCommunicationHuman2) {
        this.typeCommunicationHuman2 = typeCommunicationHuman2;
    }

    public TypeCommunication getTypeCommunicationHuman2() {
        return typeCommunicationHuman2;
    }

}
