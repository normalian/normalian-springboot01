package work.normalian.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHello(Model model){
        model.addAttribute("title", "Hello World!");
        model.addAttribute("message", "welcome Daichi's site");
        LOGGER.info("Here is MainController#showHello");
        return "index.html";
    }
}
