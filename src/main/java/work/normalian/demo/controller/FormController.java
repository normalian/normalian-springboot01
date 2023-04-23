package work.normalian.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import work.normalian.demo.dto.Student;

@Controller
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("title", "hello world!");
        model.addAttribute("message", "welcome daichi's site");
        return "form.html";
    }

    @PostMapping(value="/form")
    public String post(@RequestBody Student student) {
        LOGGER.info(student.getName() + " is " + student.getAge() + " years old");
        return "form.html";
    }
}
