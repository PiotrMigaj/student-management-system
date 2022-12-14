package pl.migibud.studentmanagementsystem.student;

/**
 * A Projection for the {@link Student} entity
 */
public interface StudentInfo {
    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();
}