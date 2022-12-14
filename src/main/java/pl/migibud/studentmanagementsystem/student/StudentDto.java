package pl.migibud.studentmanagementsystem.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class StudentDto implements StudentInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
