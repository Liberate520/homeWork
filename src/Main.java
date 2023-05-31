import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree ft = Data.dataEntry();
        DataFileManager.saveData(ft);
        //Tree ft = (Tree)DataFileManager.loadData();

        System.out.println("\nЛица в генеалогическом дереве:");
        Lib.printList(ft.getPersonList());
        System.out.println();
        System.out.println("Папой для лица \"" + ft.findPersonByName("Степан") + "\" является:\n" +  ft.findPersonByName("Степан").getFather());
        System.out.println();
        System.out.println("Мамой для лица \"" + ft.findPersonByName("Алексей") + "\" является:\n" +  ft.findPersonByName("Алексей").getMother());
        System.out.println();
        System.out.println("Родителями для лица \"" + ft.findPersonByName("Степан") + "\" являются:");
        Lib.printList(ft.findPersonByName("Степан").getParents());
        System.out.println();
        System.out.println("Детьми для лица \"" + ft.findPersonByName("Татьяна") + "\" являются:");
        Lib.printList(ft.findPersonByName("Татьяна").getChildren());
        System.out.println("Братьями и сетстрами для лица \"" + ft.findPersonByName("Вика") + "\" являются:");
        Lib.printList(ft.findSiblings(ft.findPersonByName("Вика")));
    }

}