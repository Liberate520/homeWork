
public class Controller<T>{
    //private final T fam = null;
    private final View view;

    public Controller(View view){
        this.view = view;
        view.setController(this);
        //this.in = new Scanner(System.in, "Cp866");
    }
    public void onClick(T fam) {
        switch (view.printMenu("Меню: для печати нажмите - 1, для печати родителей нажмите - 2, для закрытия - 3, для добавленя потомка - 4")){
        case 1: //печать древа
            ((Family) fam).printTree();
            this.onClick(fam);
            break;
        case 2: //печать детей родителяы
            ((Family) fam).printChildren(view.scanOne("Введите имя родителя"));
            this.onClick(fam);
            break;
        case 3:
            break;
        case 4:
            String p = view.scanOne("Введите имя родителя: ");
            String c = view.scanOther("Введите имя ребенка: ");
            String g = view.scanOther("Введите пол ребенка");
            ((Family) fam).addChild(p, c, g);
            this.onClick(fam);
            break;
        }
    }
    public void newFamily(){
        Repository r = new Repository();
        view.printStr("Создайте фамильное древо");
        String familyName = view.scanOther("Введите имя родителя : ");
        String gName = view.scanOther("Введите пол родителя: ");
        T fam = (T) new Family(familyName, gName);
        r.addFamily((Family) fam);
        System.out.println("Древо создано с родителем " + familyName);
        this.onClick((T) fam);
    }
}
