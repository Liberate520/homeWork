public class Сommunications {

    private Human h1;
    private Human h2;
    private TypeCommunications degreeKinship1;
    private TypeCommunications degreeKinship2;
    public void setH1(Human h1) {
        this.h1 = h1;
    }
    public void setH2(Human h2) {
        this.h2 = h2;
    }
    public void setDegreeKinship1(TypeCommunications degreeKinship1) {
        this.degreeKinship1 = degreeKinship1;
    }
    public void setDegreeKinship2(TypeCommunications degreeKinship2) {
        this.degreeKinship2 = degreeKinship2;
    }

    public Human getH1() {
        return h1;
    }

    public Human getH2() {
        return h2;
    }

    public TypeCommunications getDegreeKinship1() {
        return degreeKinship1;
    }

    public TypeCommunications getDegreeKinship2() {
        return degreeKinship2;
    }


    public Сommunications(Human h1, Human h2, TypeCommunications degreeKinship1, TypeCommunications degreeKinship2) {
        this.h1 = h1;
        this.h2 = h2;
        this.degreeKinship1 = degreeKinship1;
        this.degreeKinship2 = degreeKinship2;
    }
}
