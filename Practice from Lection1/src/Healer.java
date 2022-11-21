public class Healer extends BaseHero {

    private int pills;
    private int maxPills;

    public Healer() {
        super(String.format("Hero_Healer #%d", ++Healer.number),
                Healer.r.nextInt(100, 200));
        this.maxPills = Healer.r.nextInt(50, 150);
        this.pills = maxPills;

    }

    public String getInfo() {
        return String.format("%s  Pills: %d", super.getInfo(), this.pills);
    }

    /* уникальная способность для этого класса */
    public void necromance(BaseHero target) {
        target.setAlive(pills);
        this.pills = 0;
        this.hp = this.hp / 2;
    }

    public void heal(BaseHero target) {
        int delta = super.healTarget(target, pills);
        this.pills -= delta;
    }
}
