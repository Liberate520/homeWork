public class Link {
    private Tree first;
    private Tree second;
    private int tipeLink; // кем исходный объект является целевому

    public Link(Tree first, Tree second, int tipeLink, boolean flag) {
        this.first = first;
        this.second = second;
        this.setTipeLink(tipeLink);
        first.addLink(this);
    }

    public Link(Tree first, Tree second, int tipeLink) {
        this(first, second, tipeLink, true);
        new Link(second, first, Link.counterDetection(tipeLink,second.getGender()), true);

    }

    private static int counterDetection(int tipeLink, int secondGender) {
//        byte conter;
        // определяем встречную связь
        if (tipeLink / 100 == 3) {return (100 + secondGender);}
        if (tipeLink / 100 == 4) {return (200 + secondGender);}
        if (tipeLink / 100 >= 5) {return ((1200 - tipeLink - (tipeLink - 500)) + secondGender);}

        return 0;
    }


    public Tree getFirst() {
        return first;
    }

    public Tree getSecond() {
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
0**, 1** (и все последцющие) тип родства

3 = брат/сестра
4 = муж/жена


5 = Животное
6 = прадед/прабабушка
7 = дед/бабушка
8 = отец/мать
--
9 = сын/дочь
10 = внук/внучка
11 = правнук/правнучка
12 = Хозяин

12-тарг-(тарг-5)
*/
