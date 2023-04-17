public interface FromTo {
    void saveTo(GenealogicalTree family);
    GenealogicalTree readFrom(String fileName);
}
