package pl.migibud.studentmanagementsystem.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
class StudentController {

    private final StudentFacade studentFacade;
    private final StudentQueryRepository studentQueryRepository;

    @GetMapping
    String listStudent(Model model){
        model.addAttribute("students",studentQueryRepository.findAllBy());
        return "students";
    }

    @GetMapping("/register")
    String getRegistrationForm(Model model){
        StudentDto request = new StudentDto();
        model.addAttribute("student",request);
        return "register_student";
    }

    @PostMapping
    String registerStudent(@ModelAttribute("student") StudentDto request){
        studentFacade.registerStudent(request);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    String getUpdateForm(@PathVariable Long id,Model model){

        StudentInfo studentInfo = studentQueryRepository.findAllById(id).stream()
                .findFirst()
                .orElseThrow(()->new EntityNotFoundException("There is no student with id: " + id));
        model.addAttribute("student",studentInfo);
        return "update_student";
    }

    @PostMapping("/{id}")
    String updateStudent(@PathVariable Long id,@ModelAttribute("student") StudentDto studentDto){
        studentFacade.updateStudent(id,studentDto);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    String deleteStudent(@PathVariable Long id){
        studentFacade.deleteStudent(id);
        return "redirect:/students";
    }
}
