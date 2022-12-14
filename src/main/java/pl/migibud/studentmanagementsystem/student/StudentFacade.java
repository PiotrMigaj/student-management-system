package pl.migibud.studentmanagementsystem.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
class StudentFacade {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    StudentDto registerStudent(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        log.info("Student before save: {}",student);
        Student save = studentRepository.save(student);
        log.info("Student after save: {}",save);
        return modelMapper.map(save,StudentDto.class);
    }

    @Transactional
    public StudentDto updateStudent(Long id, StudentDto studentDto){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no student with id: " + id));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        return modelMapper.map(student,StudentDto.class);
    }

    @Transactional
    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no student with id: " + id));
        studentRepository.delete(student);
    }

}
