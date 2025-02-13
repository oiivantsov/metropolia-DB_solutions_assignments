package student.model;

import jakarta.persistence.*;

@Entity
public class TimeSpent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int homeworkHours;
    private int inClassHours;
    private int theoryHours;

    // foreign key to the student table
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // zero-argument constructor required by JPA
    public TimeSpent() {}

    public TimeSpent(int homeworkHours, int inClassHours, int theoryHours, Student student) {
        this.homeworkHours = homeworkHours;
        this.inClassHours = inClassHours;
        this.theoryHours = theoryHours;
        this.student = student;
    }

    // getters/setters
    public Long getId() { return id; }
    public int getHomeworkHours() { return homeworkHours; }
    public void setHomeworkHours(int homeworkHours) { this.homeworkHours = homeworkHours; }
    public int getInClassHours() { return inClassHours; }
    public void setInClassHours(int inClassHours) { this.inClassHours = inClassHours; }
    public int getTheoryHours() { return theoryHours; }
    public void setTheoryHours(int theoryHours) { this.theoryHours = theoryHours; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

