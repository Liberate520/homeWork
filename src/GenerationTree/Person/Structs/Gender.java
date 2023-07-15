package GenerationTree.Person.Structs;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Мужской";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Женский";
        }
    },
}
