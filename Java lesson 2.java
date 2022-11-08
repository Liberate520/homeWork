public class Test {

	public static void main(String[] args) {

		    String s="фамилия, Иванов, оценка, 5, предмет, Математика";
			String f="фамилия, Петрова, оценка, 4, предмет, Информатика";
			String r="фамилия, Краснов, оценка, 5, предмет, Физика";

    System.out.println("Студент " + s.substring(9,15)  + " получил " + s.substring(25,26) + " по " + s.substring(28, 35) + "у " + s.substring(37));
	System.out.println("Студентка " + f.substring(9,16)  + " получила " + f.substring(26,27) + " по" + f.substring(28, 36) + "у" + f.substring(37));
	System.out.println("Студент " + r.substring(9,16)  + " получила " + r.substring(26,27) + " по" + r.substring(28, 36) + "у" + r.substring(37));