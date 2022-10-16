public interface Queue {
    void enqueue(int num);

    int dequeue();

    int first();
}
