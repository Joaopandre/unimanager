package pt.iade.unimanage.models;
import java.time.LocalDate;

public class Student {
    private static int nextNumber = 0;
    private String name;
    private LocalDate birthDate;
    private String email;
    private char gender;
    private int number;

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getNumber() {
        

		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

    public Student(String name, LocalDate birthDate,
                   char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = nextNumber;
        nextNumber++;
        email = "";
    }
 public static int getNextNumber() { return nextNumber; }
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public LocalDate getBirthDate() {
    return birthDate;
 }
}

