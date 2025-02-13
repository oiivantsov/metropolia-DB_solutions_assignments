package student.dao;

import jakarta.persistence.*;
import java.util.List;

import student.datasource.MariaDbJpaConnection;
import student.model.Student;

public class StudentDAO {

    public void addStudent(Student student) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
        em.close();
    }

    public Student findStudent(Long id) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public void updateStudent(Student student) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(student);
        tx.commit();
        em.close();
    }

    public List<Student> getAllStudents() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        em.close();
        return students;
    }
}
