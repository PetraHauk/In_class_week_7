package model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String notes;

    @ManyToMany
    @JoinTable(
            name = "attendance_students",
            joinColumns = @JoinColumn(name = "attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    public Attendance() {
    }

    public Attendance(String status, String notes) {
        this.status = status;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void clearStudents() {
        students.clear();
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }
}
