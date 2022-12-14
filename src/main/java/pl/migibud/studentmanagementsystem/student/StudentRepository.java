package pl.migibud.studentmanagementsystem.student;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends StudentQueryRepository, JpaRepository<Student,Long> {
}
