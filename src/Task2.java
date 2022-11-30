public class Task2 {
    public static void task2() {
        
        MyCollectionCats cats = new MyCollectionCats();
        Cat catOnIndex; 
        int howManyCats = 5;
        int сatAtIndex = 0;

        cats.addRandomeCats(howManyCats);

        cats.add("Котик 1");
        cats.add("Котик 2");
        cats.add("Котик 3");

        for (Cat cat : cats) {
            System.out.print(cat.getName() + " ");
        }
        
        System.out.println();
        catOnIndex = cats.get(сatAtIndex);
        System.out.print(catOnIndex.getName() + " ");

    }
}
