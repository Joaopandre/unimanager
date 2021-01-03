package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

import pt.iade.unimanage.models.exceptions.Person;

public class Teacher extends Person {
    private static int nextNumber = 1;
    private int mecNumber;
    private ArrayList<Unit> units;
    private ArrayList<EnrolmentTeacher> enrolmentsteacher;

    public Teacher(String name, char gender, LocalDate birthDay){
        super(name, gender,birthDay);
        this.mecNumber = nextNumber;
        nextNumber++;
        units = new ArrayList<>();
    }
    public int getMecNumber(){
        return mecNumber;
    }
    public ArrayList<Unit> getUnits() {
        return units;
    }
    public EnrolmentTeacher getEnrolmentByUnitId(int unitId) {
        for(EnrolmentTeacher enr: enrolmentsteacher)
            if (enr.getUnit().getId()==unitId) return enr;
        return null;
    }
    public void enroll(Unit unit) {
        units.add(unit);
        unit.getTeachers().add(this);
    }
    public ArrayList<EnrolmentTeacher> getEnrolmentsTeacher(){
        return enrolmentsteacher; }
    public void enroll(EnrolmentTeacher enrolment){
        enrolmentsteacher.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }
}
