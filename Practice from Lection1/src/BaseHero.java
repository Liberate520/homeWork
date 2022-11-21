import java.util.Random;

public class BaseHero {

    enum State {
        ALIVE, DEAD, ZOMBIE
    }

    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;
    protected State state;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.state = State.ALIVE;
    }

//    public BaseHero() {
//        this(String.format("Hero_Priest #%d", ++BaseHero.number),
//                BaseHero.r.nextInt(100, 200));
//    }

    public String getInfo() {
        return String.format("Name: %s  Hp: %d  Type: %s",
                this.name, this.hp, this.getClass().getSimpleName());
    }

    /* возрождаем персонажа */
    public void setAlive(int hpPoints) {
        this.state = State.ZOMBIE;
        this.name = "ZOMBIE";
        this.hp = hpPoints;
    }

    /* проверяем сколько расходк осталось */
    private boolean checkConsumers(int consumables) {
        return consumables > 0;
    }

    private void healed(int Hp) {
        this.hp = Math.min(Hp + this.hp, this.maxHp);
    }

    /**
     * лечим с проверкой расходников
     * 
     * @param target кого лечим
     */
    public int healTarget(BaseHero target, int consumables) {
        if (target.state != State.DEAD) {
            int health = checkConsumers(consumables) ? getPoints(consumables) : 0;
            target.healed(health);
            return health;
        }
        return 0;
    }

    private void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else {
            die();
        }
    }

    /* помираем, обнуляем */
    private void die() {
        this.name = "Dead Mad";
        this.hp = 0;
        this.state = State.DEAD;
    }

    public int AttackTarget(BaseHero target, int consumables) {
        int damage = checkConsumers(consumables) ? getPoints(consumables) : 0;
        target.GetDamage(damage);
        return damage;
    }

    /* проверка во избежание отрицательных значений */
    private int getPoints(int consumables) {
        int rnd = BaseHero.r.nextInt(10, 50);
        return Math.min(consumables, rnd);
    }
}
