//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package auca.rw.registration.AucaRegistration.domain;

import jakarta.persistence.*;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long course_id;
    @ManyToOne
    private AcademicUnit unit;
    @ManyToOne
    private CourseDefinition courseDefinition;

    @ManyToOne
    private Semester semester;

    public Course() {
    }

    public Course(AcademicUnit unit, CourseDefinition courseDefinition, Semester semester) {
//        this.course_id = course_id;
        this.unit = unit;
        this.courseDefinition = courseDefinition;
        this.semester = semester;
    }

//    public UUID getCourse_id() {
////        return this.course_id;
////    }
//
//    public void setCourse_id(UUID course_id) {
//        this.course_id = course_id;
//    }

    public AcademicUnit getUnit() {
        return this.unit;
    }

    public void setUnit(AcademicUnit unit) {
        this.unit = unit;
    }

    public CourseDefinition getCourseDefinition() {
        return this.courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }


    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
    //public void
}
