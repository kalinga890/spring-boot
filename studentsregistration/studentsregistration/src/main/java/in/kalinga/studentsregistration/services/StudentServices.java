package in.kalinga.studentsregistration.services;

import in.kalinga.studentsregistration.dao.StudentsDao;
import in.kalinga.studentsregistration.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class StudentServices {

    @Autowired
    private StudentsDao studentsDao;


    public Student  addStudent(Student student){

         return studentsDao.addStudent(student);

    }

    public List<Student> getStudents(){

      return   studentsDao.getStudents();
    }

    public Student getStudent(Integer id){

      Student student = studentsDao.getStudent(id);

        if(student!=null){

            return student;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the id");
    }

    public Student updateStudent(Student updatedStudent){
        try {
            return  studentsDao.updateStudent(updatedStudent);


        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the id" + updatedStudent.getId());

        }
    }

    public void deleteStudent(Integer id){

        if(!studentsDao.deleteStudent(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the id" + id);
        }


    }
}
