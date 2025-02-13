package student;

import io.github.cdimascio.dotenv.Dotenv;
import student.dao.StudentDAO;
import student.dao.TimeSpentDAO;
import student.datasource.MariaDbJpaConnection;
import student.model.Student;
import student.model.TimeSpent;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("JDBC_URL", dotenv.get("JDBC_URL"));
        System.setProperty("JDBC_USER", dotenv.get("JDBC_USER"));
        System.setProperty("JDBC_PASSWORD", dotenv.get("JDBC_PASSWORD"));

        StudentDAO studentDAO = new StudentDAO();
        TimeSpentDAO timeSpentDAO = new TimeSpentDAO();

        // add a new student
        Student student = new Student("Oleg I", "oleg@example.com");
        studentDAO.addStudent(student);

        // find a student
        Student foundStudent = studentDAO.findStudent(student.getId());
        if (foundStudent != null) {
            System.out.println("Student Found: " + foundStudent.getName());
        }

        // add time spent record
        TimeSpent timeSpent = new TimeSpent(1, 3, 2, foundStudent);
        timeSpentDAO.addTimeSpent(timeSpent);

        // update student info
        foundStudent.setEmail("oleg_i@example.fi");
        studentDAO.updateStudent(foundStudent);

        // close emf
        MariaDbJpaConnection.getInstance().close();
    }
}
