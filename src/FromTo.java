public interface FromTo {
   <T extends Human> void saveTo(GenealogicalTree<T> family);
   GenealogicalTree readFrom(String fileName);
}
