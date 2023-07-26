/*Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например получение всех детей выбранного человека. */


public class Test { // Программа для поиска потомка
        
        static int MAX_CHILD = 10; // Максимальное количество детей
    
        static class Node
        {
            char val;
            Node[] child = new Node[MAX_CHILD];
    
            Node(char Level)
            {
                val = Level;
                for (int i = 0; i < MAX_CHILD; i++)
                    child[i] = null;
            }
        }
        
        // Обход заданного дерева до указанного значения
        static void printChild(Node root, char Level, int chain) 
        {
            // Если Level текущий корень
            if (root.val == Level)
            {
                if (root.child[chain - 1] == null)
                    System.out.print("Ошибка: Данных не существует\n");
                else
                    System.out.print(root.child[chain - 1].val + "\n");
            } else{     // Если Pip лежит в поддереве
               for (int i = 0; i < MAX_CHILD; i++){
                  if (root.child[i] != null)
                      printChild(root.child[i], Level, chain);
               }
            }
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

            System.out.print("Третий ребёнок F: ");
            printChild(root, 'F', 3);
     
            System.out.print("Четвертый ребёнок А: ");
            printChild(root, 'A', 4);
        }
    }
