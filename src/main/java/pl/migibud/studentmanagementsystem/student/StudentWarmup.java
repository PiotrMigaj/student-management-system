package pl.migibud.studentmanagementsystem.student;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@RequiredArgsConstructor
class StudentWarmup {

    private final StudentRepository studentRepository;

    @EventListener(ContextRefreshedEvent.class)
    void initDatabase(){
        if(studentRepository.count()!=0){
            return;
        }
        Student student1 = new Student("Piotr","Migaj","pmigaj@gmail.com");
        Student student2 = new Student("Anna","Migaj","amigaj@gmail.com");
        studentRepository.save(student1);
        studentRepository.save(student2);
    }
}
