package pro.neo.nowup.cucumber.stepdefs;

import pro.neo.nowup.NowupApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = NowupApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
