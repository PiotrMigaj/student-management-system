package pl.migibud.studentmanagementsystem.student;

import java.util.List;

interface StudentQueryRepository {
    List<StudentInfo> findAllBy();
    List<StudentInfo> findAllById(Long id);
}
