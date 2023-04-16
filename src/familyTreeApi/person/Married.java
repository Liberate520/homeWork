package familyTreeApi.person;

import familyTreeApi.member.Member;

public interface Married extends Member {
    Member getMarried();


    boolean addMarried(Member married, boolean isMarried);

    @Override
    default String printInfo() {
        StringBuilder result = new StringBuilder();
        if (this.getMarried() != null) {
            if (this.getGender().equals(true)) {
                result.append("Жена ");
            } else {
                result.append("Муж ");
            }
            result.append(this.getMarried().printWithBornDate() + "\n");
        }
        return new StringBuilder(Member.super.printInfo()).insert(this.printWithBornDate().length(), result).toString();
    }
}
