package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "progress_reports")
public class ProgressReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate reportDate;
    private String achievements;
    private String improvements;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public ProgressReport() {
    }

    public ProgressReport(LocalDate reportDate, String achievements, String improvements, Student student) {
        this.reportDate = reportDate;
        this.achievements = achievements;
        this.improvements = improvements;
        this.student = student;
    }

    public Long getId() {
        return id;
    }
    public LocalDate getReportDate() {
        return reportDate;
    }
    public String getAchievements() {
        return achievements;
    }
    public String getImprovements() {
        return improvements;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
