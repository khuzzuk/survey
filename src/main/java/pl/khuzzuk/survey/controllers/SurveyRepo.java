package pl.khuzzuk.survey.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.khuzzuk.survey.surveys.SurveyPages;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

@RestController
public class SurveyRepo {
    @RequestMapping("/survey1")
    public SurveyPages getLogicTest() throws RemoteException {
        try {
            return new ObjectMapper().readValue(new File("logicTest.json"), SurveyPages.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }
}
