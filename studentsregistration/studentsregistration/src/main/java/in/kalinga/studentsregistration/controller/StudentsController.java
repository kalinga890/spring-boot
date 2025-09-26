package in.kalinga.studentsregistration.controller;


import in.kalinga.studentsregistration.entity.Student;
import in.kalinga.studentsregistration.services.StudentServices;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Transactional
public class StudentsController {

    private final StudentServices studentServices;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student addStudents( @Valid @RequestBody Student student){

       return studentServices.addStudent(student);

    }

    @GetMapping
    public List<Student> readStudents(){

     return studentServices.getStudents();


    }
    @GetMapping("/{id}")
    public Student readStudent(@PathVariable Integer id){

       return  studentServices.getStudent(id);

    }

    @PutMapping("/{id}")
    public Student updateStudents( @PathVariable Integer id, @RequestBody Student upadtedStudent){

             upadtedStudent.setId(id);
          return  studentServices.updateStudent(upadtedStudent);


   }
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("/{id}")
   public void deleteStudents(@PathVariable Integer id){


        studentServices.deleteStudent(id);
   }


}
