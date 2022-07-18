package work.normalian.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.normalian.demo.dto.Student;

// https://qiita.com/MizoguchiKenji/items/2a041f3a3eb13274e55c
@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student read(@PathVariable(required = false) String id){
        Student s = new Student();
        s.setAge(10);
        s.setName("Daisuke - ID:" + id + ".");
        return s;
    }
}
