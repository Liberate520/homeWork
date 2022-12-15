package FT;

import java.util.List;

public class SearchRelations {
    public static void printSon(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.SON) {
                System.out.println(name + " является сыном " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printDaughter(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.DAUGHTER) {
                System.out.println(name + " является дочерью " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printFather(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.FATHER) {
                System.out.println(name + " является папой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printMother(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.MOTHER) {
                System.out.println(name + " является мамой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printWife(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.WIFE) {
                System.out.println(
                        name + " является женой " + el.getHumanSecond().getName() + " " + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printHusbant(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.HUSBANT) {
                System.out.println(
                        name + " является мужем " + el.getHumanSecond().getName() + " " + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printSyster(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.SYSTER) {
                System.out.println(name + " является сестрой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printBrother(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.BROTHER) {
                System.out.println(name + " является братом " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printGrandMother(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.GRANDMOTHER) {
                System.out.println(name + " является бабушкой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printGrandFather(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.GRANDFATHER) {
                System.out.println(name + " является дедушкой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printGrandSon(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.GRANDSON) {
                System.out.println(name + " является внуком " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }

    public static void printGrandDaughter(String name, Tree tree) {

        List<Link> links = tree.getLinks();

        for (Link el : links) {
            if (el.getHumanFirst().getName().equals(name) &&
                    el.getLink() == Relation.GRANGDAUGHTER) {
                System.out.println(name + " является внучкой " + el.getHumanSecond().getName() + " "
                        + el.getHumanSecond().getSurname());
            }
        }
    }
}
