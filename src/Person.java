public class Person {
	private String name;
	private String surname;
	private String birthDate;
	private String birthPlace;
	public Person(String name, String surname, String birthDate, String birthPlace) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
	}
	//Геттеры и сеттеры для всех полей
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
}
