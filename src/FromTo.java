public interface FromTo {
   <T extends TreeElement> void saveTo(GenealogicalTree<T> family);
   GenealogicalTree readFrom(String fileName);
}
