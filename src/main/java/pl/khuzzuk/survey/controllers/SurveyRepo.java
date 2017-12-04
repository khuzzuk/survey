package pl.khuzzuk.survey.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.khuzzuk.survey.surveys.SurveyPages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class SurveyRepo {
    Logger logger = Logger.getLogger("name");
    @RequestMapping("/survey1")
    public SurveyPages getLogicTest() throws RemoteException {
        try {
            Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:static/logicTest.json");
            return new ObjectMapper().readValue(resource.getInputStream(), SurveyPages.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "file not found");
            throw new RemoteException();
        }
    }
}
