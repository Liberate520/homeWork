import java.io.IOException;
import java.util.Scanner;
/**
 * класс для общения с пользователем
 */
public class Controller<T> implements View{
    private T fam = null;
    private Scanner in;

    public Controller(T f){
        this.fam = f;
        this.in = new Scanner(System.in, "Cp866");

    }
    public void funct(T fam) throws IOException{
        init();
        int fun = this.in.nextInt();
        switch (fun){
        case 1: //печать древа
            ((Family) fam).printTree();
            this.funct(fam);
            break;
        case 2: //печать детей родителя
            answer("Введите имя родителя: ");
            in.nextLine();
            ((Family) fam).printChildren(in.nextLine());

            this.funct(fam);
            break;
        case 3:
            in.close();
            break;
        }
    }
    @Override
    public void answer(String s) {
        System.out.print(s);
        
    }
    @Override
    public void init() {
        System.out.print("Меню: для печати нажмите 1, для ввыода детей 2, для выхода - 3: ");
        
    }
}
