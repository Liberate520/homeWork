public class FamilyTree { // Программа для поиска потомка
        
    static int N = 10; // Максимальное количество детей

    static class Node
    {
        char val;
        Node[] child = new Node[N];

        Node(char Pip)
        {
            val = Pip;
            for (int i = 0; i < N; i++)
                child[i] = null;
        }
    }
    
    static void printChild(Node root, char Pip, int chain) // Обход заданного дерева до указанного значения
    {
        // Если Pip текущий корень
        if (root.val == Pip)
        {
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

    public static void main(String[] args)
    {
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

        char Pip = 'F';
        System.out.print("Второй ребёнок F: ");
        printChild(root, Pip, 2);
 
        Pip = 'A';
        System.out.print("Седьмой ребёнок А: ");
        printChild(root, Pip, 7);
    }
}