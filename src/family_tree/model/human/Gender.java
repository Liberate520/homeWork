package family_tree.model.human;
public enum Gender {
    MALE, FAMALE;
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MALE);
        stringBuilder.append(FAMALE);
        return stringBuilder.toString();
    }
}
