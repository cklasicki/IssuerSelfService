package de.blogspot.mszalbach.iss.screenplay.tasks;

import de.blogspot.mszalbach.iss.pageobjects.SecurityListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.statematchers.IsPresentMatcher;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

/**
 * Created by ms on 09.12.16.
 */
public class OpenSecurityListPage
    implements Task {

    private SecurityListPage securityListPage;



    @Override
    @Step( "{0} öffnet die Wertpapierliste" )
    public <T extends Actor> void performAs( T actor ) {
        actor.attemptsTo(
            Open.browserOn().the( securityListPage ),
            WaitUntil.the( SecurityListPage.OPEN_CREATE_DIALOG_BUTTON, new IsPresentMatcher<>() )
        );
    }
}
