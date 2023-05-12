package OOP_Prodject;

import java.util.List;

public class Profession {
    protected String profession;
    protected Integer health_modifier;
    protected Integer attack_modifier;
    protected Integer speed_modifier;
    protected Integer mana_modifier;
    protected Integer resist_modifier;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String prof) {
        this.profession = prof;
    }

    public Integer getHealthModifier() {
        return health_modifier;
    }

    public void setHealthModifier(Integer h_m) {
        this.health_modifier = h_m;
    }

    public Integer getAttackModifier() {
        return attack_modifier;
    }

    public void setAttackModifier(Integer a_m) {
        this.attack_modifier = a_m;
    }

    public Integer getSpeedModifier() {
        return speed_modifier;
    }

    public void setSpeedModifier(Integer s_m) {
        this.speed_modifier = s_m;
    }

    public Integer getManaModifier() {
        return mana_modifier;
    }

    public void setManaModifier(Integer m_m) {
        this.mana_modifier = m_m;
    }

    public Integer getResistModifier() {
        return resist_modifier;
    }

    public void setResistModifier(Integer r_m) {
        this.resist_modifier = r_m;
    }

    public Profession(String prof, Integer health_m, Integer attack_m, Integer speed_m, Integer mana_m,
            Integer resist_m) {
        this.profession = prof;
        this.health_modifier = health_m;
        this.attack_modifier = attack_m;
        this.speed_modifier = speed_m;
        this.mana_modifier = mana_m;
        this.resist_modifier = resist_m;

    }

    public Profession(String prof) {
        this(prof, 0, 0, 0, 0, 0);
    }

    public void professionModifier(Character c) {
        c.setProfession(this.profession);
    }

    public void healthModifier(Character c) {
        c.setHealthPoints(c.getHealthPoints() + this.health_modifier);
    }

    public void maxHealthModifier(Character c) {
        c.setMaxHealthPoints(c.getMaxHealthPoints() + this.health_modifier);
    }

    public void attackModifier(Character c) {
        c.setAttack(c.getAttack() + this.attack_modifier);
    }

    public void speedModifier(Character c) {
        c.setSpeed(c.getSpeed() + this.speed_modifier);
    }

    public void manaModifier(Character c) {
        c.setMana(c.getMana() + this.mana_modifier);
    }

    public void maxManaModifier(Character c) {
        c.setMaxMana(c.getMaxMana() + this.mana_modifier);
    }

    public void resistanceModifier(Character c) {
        c.setResist(c.getResist() + this.resist_modifier);
    }

    public void modify(Character c) {
        this.professionModifier(c);
        this.healthModifier(c);
        this.maxHealthModifier(c);
        this.attackModifier(c);
        this.speedModifier(c);
        this.manaModifier(c);
        this.maxManaModifier(c);
        this.resistanceModifier(c);

    }

}
