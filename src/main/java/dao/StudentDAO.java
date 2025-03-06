package dao;

import model.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentDAO extends GenericDAO<Student> {
    public StudentDAO(EntityManager entityManager) {
        super(Student.class, entityManager);
    }

    public List<Student> findAllStudentsThatJoinedByDate(String date) {
        return entityManager.createQuery("SELECT s FROM Student s JOIN s.trainingSessions ts WHERE ts.date = :date", Student.class)
                .setParameter("date", date)
                .getResultList();
    }

    
}
