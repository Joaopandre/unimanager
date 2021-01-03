package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
                                Teacher t;

    public static List<Teacher> getTeachers() {
        return teachers;
    } 
    public static Student getTeacher(int mecNumber) {
        for (Teacher teacher: teachers)
            if (teacher.getNumber() == mecNumber)
                return teacher;
        return null;
    } 
    public static boolean deleteTeacherUnit(int unitId){
        return teacher.removeIf(
                        (t)-> t.getNumber()==unitId);
    }
    public static Teacher addTeacherUnit(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }
}
