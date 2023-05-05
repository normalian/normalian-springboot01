package work.normalian.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHello(Model model, Authentication user){
        model.addAttribute("title", "This is Daichi's web site!");
        model.addAttribute("message", "Welcome this page!");
        LOGGER.info("Here is MainController#showHello");

        if(user.isAuthenticated() == true){
            model.addAttribute("username", user.getName());
        }

        return "index.html";
    }
}
