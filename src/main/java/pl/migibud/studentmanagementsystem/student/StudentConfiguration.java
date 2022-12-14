package pl.migibud.studentmanagementsystem.student;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class StudentConfiguration {

    @Bean
    StudentFacade studentFacade(StudentRepository studentRepository,ModelMapper modelMapper){
        return new StudentFacade(studentRepository,modelMapper);
    }

    @Bean
    ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }
}
