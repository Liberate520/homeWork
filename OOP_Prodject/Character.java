package OOP_Prodject;

import java.util.Random;

public class Character implements Attackable, Healable, Speakable, Comparable<Character> {
    protected String name;
    protected String profession;
    protected Integer health_points;
    protected Integer experience_points;
    protected Integer level;
    protected Integer attack;
    protected Integer max_health_points;
    protected Integer speed;
    protected Integer mana;
    protected Integer max_mana;
    protected Integer resistance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String prof) {
        this.profession = prof;
    }

    public Integer getHealthPoints() {
        return health_points;
    }

    public void setHealthPoints(Integer health_points) {
        this.health_points = health_points;

    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getMaxHealthPoints() {
        return max_health_points;
    }

    public void setMaxHealthPoints(Integer max_hp) {
        this.max_health_points = max_hp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getMaxMana() {
        return max_mana;
    }

    public void setMaxMana(Integer max_mana) {
        this.max_mana = max_mana;
    }

    public Integer getResist() {
        return resistance;
    }

    public void setResist(Integer resistance) {
        this.resistance = resistance;
    }

    // public Integer getRegeneration() {
    // return regeneration;
    // }

    // public void setRegeneration(Integer regineration) {
    // this.regeneration = regineration;
    // }

    public Character(String name, String prof, Integer health_points, Integer exp, Integer level, Integer attack,
            Integer max_health_points, Integer speed, Integer mana, Integer max_mana, Integer resistance) {
        this.name = name;
        this.profession = prof;
        this.health_points = health_points;
        this.experience_points = exp;
        this.level = level;
        this.attack = attack;
        this.max_health_points = max_health_points;
        this.speed = speed;
        this.mana = mana;
        this.max_mana = max_mana;
        this.resistance = resistance;

    }

    public Character(String name) {
        this(name, "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    public String toString() {
        return String.format(
                "Имя: %s\nУровень: %d\nОпыт: %d\nНаносимый урон: %d\nЗдоровье: %d\nМана: %d\nСкорость: %d\n",
                name, level, experience_points, attack, health_points, mana, speed);
    }

    @Override
    public void attack(Character a_c, Character d_c) {
        Integer damage = a_c.getAttack();
        Integer resist = d_c.getResist();
        Integer speed_a = a_c.getSpeed();
        Integer speed_c = d_c.getSpeed();
        Double probability = 0.5 + (speed_a - speed_c) / (speed_a * 2);
        Random r = new Random();
        int test = r.nextInt(1, 101);
        if (test <= probability * 100) {
            damage *= 2;
        }
        damage = damage - resist;

        if (damage > 0) {
            d_c.setHealthPoints(d_c.getHealthPoints() - damage);
        } else {
            Miss.miss();
        }
    }

    @Override
    public void heal(Character h_c, Integer healling_points) {
        {
            h_c.setHealthPoints(h_c.getHealthPoints() + healling_points);
        }
    }

    @Override
    public void speak() {
        // Надо прописать, что он говорит ,но можно оставить и пустым, а для
        // конкретного класса персов прописать свое
        throw new UnsupportedOperationException("Unimplemented method 'speak'");
    }

    @Override
    // Надо прописать критерий сравнения

    public int compareTo(Character c) {

        return speed.compareTo(c.speed);
    }

}