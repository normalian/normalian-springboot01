package work.normalian.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHellow(Model model){
        model.addAttribute("title", "hello world!");
        model.addAttribute("message", "welcome daichi's site");
        return "hello.html";
    }
}
