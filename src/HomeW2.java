public class HomeW2 {

    public static void main(String[] args) {

        String s1 = "\"фамилия\":\"Иванов\", \"оценка\":\"5\", \"предмет\":\"Математика\"";
        String s2 = "\"фамилия\":\"Петрова\", \"оценка\":\"4\", \"предмет\":\"Информатика\"";
        String s3 = "\"фамилия\":\"Краснов\", \"оценка\":\"5\", \"предмет\":\"Физика\"";
        System.out.println(s1);

        String family = (ex1(s1));
        StringBuilder grade = new StringBuilder();
        StringBuilder subject = new StringBuilder();

        System.out.println("Студент " + family + " получил" + grade + " по предмету " + subject);
        }
        public static String ex1 (String s1){

            String family1= s1.substring(Integer.parseInt("11"), Integer.parseInt("17"));
            return family1;
        }
    }