package pl.khuzzuk.survey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyController {
    @RequestMapping("/home")
    public String logicTestMainPage() {
        return "/logicTest.html";
    }
}
