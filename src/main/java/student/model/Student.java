package student.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // one student can have multiple timeSpent entries
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeSpent> timeSpentList;

    // zero-argument constructor required by JPA
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters/setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<TimeSpent> getTimeSpentList() { return timeSpentList; }
    public void setTimeSpentList(List<TimeSpent> timeSpentList) { this.timeSpentList = timeSpentList; }
}
