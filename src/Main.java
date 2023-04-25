public class Main {
    public static void main(String[] args) {
        Spisok IvanIvanov = new Spisok("Иван", "Иванов");
        Spisok UliaIvanova = new Spisok("Юлия", "Иванова");
        Spisok VasilisaPetrova = new Spisok("Василиса", "Петрова");
        Spisok KirillVasilev = new Spisok("Кирилл", "Васильев");
        Spisok PetrKavalerov = new Spisok("Петр", "Кавалеров");
        Spisok NadiaGlasova = new Spisok("Надежда", "Гласова");
        Spisok ValeriaKomarova = new Spisok("Валерия", "Комарова");





        Human NadiaGlasovaTree = new Human(ValeriaKomarova, PetrKavalerov);
        Human PetrKavalerovTree = new Human(UliaIvanova, IvanIvanov, NadiaGlasova);
        Human KirillVasilevTree = new Human(UliaIvanova, IvanIvanov);
        Human VasilisaPetrovaTree = new Human(UliaIvanova, IvanIvanov);
        Human UliaIvanovaTree = new Human("Анжела", "Евгений", VasilisaPetrova, KirillVasilev, PetrKavalerov);
        Human IvanIvanovTree = new Human("Ефростинья", "Аккакий", VasilisaPetrova, KirillVasilev, PetrKavalerov);
        Human ValeriaKomarovaTree = new Human("Феодосия", "Вашнец", NadiaGlasova);


        Tree tree = new Tree();
        tree.addTree(NadiaGlasovaTree);
        tree.addTree(PetrKavalerovTree);
        tree.addTree(KirillVasilevTree);
        tree.addTree(VasilisaPetrovaTree);
        tree.addTree(UliaIvanovaTree);
        tree.addTree(IvanIvanovTree);
        tree.addTree(ValeriaKomarovaTree);

        System.out.println(PetrKavalerovTree);
        System.out.println(UliaIvanovaTree);
        IvanIvanov.read();
    }
}