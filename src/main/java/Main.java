import entities.Semester;
import entities.Student;
import facades.SchoolFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    private static SchoolFacade schoolFacade;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        schoolFacade = SchoolFacade.getInstance(emf);

        /*List<Student> students = schoolFacade.getAllStudentsFromSemester(1);
        for (Student student : students) {
            System.out.println(student);
        } */
        //schoolFacade.createStudent("Christoffer","Nielsen");
        //schoolFacade.createSemester("Datamatiker 1. sem", "CLdatone-a14e");
        //schoolFacade.createTeacher("Frank","Hansen");
        //schoolFacade.updateSemester(1,"Mit semester","my semester");
        //schoolFacade.addStudentToSemester(7,2);
        schoolFacade.addTeacherToSemester(1,1);
    }
}
