package model;

public class Link {
    private TreePerson first;
    private TreePerson second;
    private int tipeLink; // кем исходный объект является целевому

    public Link(TreePerson first, TreePerson second, int tipeLink, boolean flag) {
        this.first = first;
        this.second = second;
        this.setTipeLink(tipeLink);
        first.addLink(this);
    }

    public Link(TreePerson first, TreePerson second, int tipeLink) {
        this(first, second, tipeLink, true);
        new Link(second, first, Link.counterDetection(tipeLink,second.getGender()), true);

    }

    private static int counterDetection(int tipeLink, int secondGender) {
//        byte conter;
        // определяем встречную связь
        if (tipeLink / 100 == 1) {return (100 + secondGender);}
        if (tipeLink / 100 == 2) {return (200 + secondGender);}
        if (tipeLink / 100 >= 3) {return ((6 - (tipeLink/100) - ((tipeLink/100) - 3)) * 100 + secondGender);}

        return 0;
    }


    public TreePerson getFirst() {
        return first;
    }

    public TreePerson getSecond() {
        return second;
    }

    public int getTipeLink() {
        return tipeLink;
    }

    public void setTipeLink(int tipeLink) {
        this.tipeLink = tipeLink;
    }
}

/*
типы связей
**0, **1 (тоесть первая цифра) гендер
*0*, *1* (вторая цивра) возможная реализация кровного родства
0**, 1**, 2**... (и все последцющие) тип родства =>

1 = брат/сестра
2 = муж/жена


3 = Животное
4 = отец/мать
--
5 = сын/дочь
6 = Хозяин

6-тарг-(тарг-3)
*/
