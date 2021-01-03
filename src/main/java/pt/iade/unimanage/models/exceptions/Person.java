package pt.iade.unimanage.models.exceptions;
import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected LocalDate birthDay;
    protected String email;
    protected char gender;
    public Person(String name, LocalDate birthDay, char gender, String email){
            this.name = name;
            this.email = "";
            this.gender = gender;
            this.birthDay = birthDay;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; 
    }       
    @Override
    public abstract String getReference();
    
    
   }
}
