package model.memberFactory;

public class FactoryMemberProvider {
    public static AbstractMemberFactory getFactory(String choice) {
        if ("human".equalsIgnoreCase(choice)) return new HumanFactory();
        if ("dog".equalsIgnoreCase(choice)) return new DogFactory();
        return null;
    }
}
