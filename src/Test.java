//Реализовать,с учетом ооп подхода,приложение.
//Для проведения исследований с генеалогическим древом.
//Идея:описать некоторое количество компонент,например:
//модель человека и дерева
//Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
//Более детальное описание проекта и как его реализовать обсуждали в конце семинара
//Сделать PR к проекту:https://github.com/Liberate520/homeWork
//В качестве ответа указать ссылку на PR
//Ссылка на то как сделать пулреквест смотри в материалах к уроку
//Если PR все таки не дается,то можно и ссылкой на гит репозиторий

public class Test {
    static int N = 10; // Максимальное количество детей

    static class Node {
        char val;
        Node[] child = new Node[N];

        Node(char Pip) {
            val = Pip;
            for (int i = 0; i < N; i++)
                child[i] = null;
        }
    }

    static void printChild(Node root, char Pip, int chain) // Обход заданного дерева до указанного значения
    {
        // Если Pip текущий корень
        if (root.val == Pip) {
            if (root.child[chain - 1] == null)
                System.out.print("Ошибка: Данных не существует\n");
            else
                System.out.print(root.child[chain - 1].val + "\n");
        }

        // Если Pip лежит в поддереве
        for (int i = 0; i < N; i++)
            if (root.child[i] != null)
                printChild(root.child[i], Pip, chain);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.child[0] = new Node('B');
        root.child[1] = new Node('C');
        root.child[2] = new Node('D');
        root.child[3] = new Node('E');
        root.child[0].child[0] = new Node('F');
        root.child[0].child[1] = new Node('G');
        root.child[2].child[0] = new Node('H');
        root.child[0].child[0].child[0] = new Node('I');
        root.child[0].child[0].child[1] = new Node('J');
        root.child[0].child[0].child[2] = new Node('K');
        root.child[2].child[0].child[0] = new Node('L');
        root.child[2].child[0].child[1] = new Node('M');

//        Scanner in = new Scanner(System.in);
//
//        char Pip = in.next().charAt(0);
        char Pip = 'F';
        System.out.print("Второй ребёнок F: ");
        printChild(root, Pip, 2);

        Pip = 'A';
        System.out.print("Седьмой ребёнок А: ");
        printChild(root, Pip, 7);
    }
}
