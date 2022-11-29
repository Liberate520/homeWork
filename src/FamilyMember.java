public class FamilyMember extends Man {
    private CONST.FamilyRelationShip frs;

    public CONST.FamilyRelationShip getFrs() {
        return frs;
    }

    private FamilyMember(String first_name, String second_name, int age, int height, int weight, CONST.Sex sex,
            CONST.FamilyRelationShip frs) {
        super(first_name, second_name, age, height, weight, sex);
        this.frs = frs;
    }
    
    public FamilyMember(Man man, CONST.FamilyRelationShip frs) {
        this(man.getFirst_name(), man.getSecond_name(), man.getAge(), man.getHeight(), man.getWeight(), man.getSex(),
                frs);
    }

    @Override
    public String toString() {
        return String.format("-> %s %s %d %s %s",
                this.getSecond_name(),
                this.getFirst_name(),
                this.getAge(),
                this.getSex().toString(),
                this.getFrs().toString());
    }
}
