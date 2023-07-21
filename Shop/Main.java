package homeWork.Shop;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Constructor> arr = new PriorityQueue<>();
        fillQueue(arr);
        Queue<Constructor> commonQueue = new PriorityQueue<>(arr);

        ArrayList<Constructor> extractedElements = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Constructor extractedElement = getFromQueue(commonQueue);
            extractedElements.add(extractedElement);
        }

        FileHandler.toFileExtraction(extractedElements);
    }

    public static void fillQueue(Queue<Constructor> myOwnPriorityQueue) {
        ArrayList<Constructor> model = new ArrayList<>();
        model.add(new Constructor("rabbit", 2));
        model.add(new Constructor("wolf", 3));
        model.add(new Constructor("snake", 4));
        model.add(new Constructor("eagle", 5));
        model.add(new Constructor("crocodile", 6));
        model.add(new Constructor("fish", 1));
        model.add(new Constructor("bear", 7));
        model.add(new Constructor("tiger", 8));
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            int randomIndex = random.nextInt(model.size());
            Constructor randomElement = model.get(randomIndex);
            myOwnPriorityQueue.add(randomElement);
        }
    }

    public static Constructor getFromQueue(Queue<Constructor> queue) {
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            System.out.println("Очередь пуста.");
            return null;
        }
    }

}
