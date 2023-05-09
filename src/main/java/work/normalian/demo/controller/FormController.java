package work.normalian.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work.normalian.demo.dto.Restaurant;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//https://spring.io/guides/gs/handling-form-submission/
@Controller
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("title", "Please input your favorite restaurant!");
        model.addAttribute("message", "Please input your favorite restaurant");
        return "form.html";
    }

    @PostMapping(value="/form")
    public String post(@ModelAttribute Restaurant restaurant) {
        LOGGER.info(restaurant.getName() + " is " + restaurant.getGenre() + " restaurant!");
        return "form.html";
    }
}
