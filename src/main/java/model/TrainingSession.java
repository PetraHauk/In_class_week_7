package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "training_sessions")
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String location;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToMany(mappedBy = "trainingSessions")  // This refers to the "trainingSessions" property in Student
    private List<Student> students;

    public TrainingSession() {
    }

    public TrainingSession(LocalDate date, String location, int duration, Instructor instructor) {
        this.date = date;
        this.location = location;
        this.duration = duration;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
