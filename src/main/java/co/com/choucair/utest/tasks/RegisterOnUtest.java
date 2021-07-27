package co.com.choucair.utest.tasks;

import co.com.choucair.utest.models.UtestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.choucair.utest.userinterface.UtestRegisterPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterOnUtest implements Task {
    UtestData utestData;

    public RegisterOnUtest(UtestData utestData) {
        this.utestData = utestData;
    }

    public static RegisterOnUtest onThePage(UtestData utestData) {
        return instrumented(RegisterOnUtest.class,utestData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(JOIN_BUTTON),
                Enter.theValue(utestData.getStrFirstName()).into(FIRST_NAME),
                Enter.theValue(utestData.getStrLastName()).into(LAST_NAME),
                Enter.theValue(utestData.getStrEmail()).into(EMAIL),
                SelectFromOptions.byVisibleText(utestData.getStrBirthMonth()).from(DROP_MOMTH),
                SelectFromOptions.byVisibleText(utestData.getStrBirthDay()).from(DROP_DAY),
                SelectFromOptions.byVisibleText(utestData.getStrBirthYear()).from(DROP_YEAR),
                Enter.theValue(utestData.getStrLanguage()).into(SELECT_LANGUAGE),
                Click.on(LOCATION_BUTTON),
                Enter.theValue(utestData.getStrPostalCode()).into(POSTAL_CODE),
                Click.on(DEVICE_BUTTON),
                Click.on(LAST_BUTTON),
                Enter.theValue(utestData.getStrPassword()).into(PASSWORD),
                Enter.theValue(utestData.getStrConfirmPassword()).into(CONFIRM_PASSWORD),
                Click.on(TERMS_USE),
                Click.on(PRIVACY_POLICY)
                // Click.on(COMPLETE_BUTTON)

        );
    }
}
