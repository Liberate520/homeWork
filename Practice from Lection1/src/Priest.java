public class Priest extends BaseHero {
    private int elixir;
    private int maxElixir;

    public Priest() {
        super(String.format("Hero_Priest #%d", ++Magician.number),
                Magician.r.nextInt(100, 200));
        this.maxElixir = Magician.r.nextInt(500, 1500);
        this.elixir = maxElixir;
    }

    public String getInfo() {
        return String.format("%s  Elixir: %d", super.getInfo(), this.elixir);
    }


    public void Attack(BaseHero target) {
        int delta = super.AttackTarget(target, elixir);
        this.elixir -= delta;
    }
}
