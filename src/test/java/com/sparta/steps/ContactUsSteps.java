package com.sparta.steps;

import com.sparta.pages.ContactUsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.thucydides.core.steps.ScenarioSteps;

import java.nio.file.Paths;

public class ContactUsSteps extends ScenarioSteps {
//
   public static Performable withDetails(
           String name,
           String email,
           String subject,
           String message
   ){
       // 0 = actor name
       return Task.where( "{0} submits the contact form",
               Enter.theValue(name)
                       .into(ContactUsPage.NAME),
               Enter.theValue(email)
                       .into(ContactUsPage.EMAIL),
               Enter.theValue(subject)
                       .into(ContactUsPage.SUBJECT),
               Enter.theValue(message)
                       .into(ContactUsPage.MESSAGE),
               Upload.theFile(
                       Paths.get("src/test/resources/fileToTestContactUsForm.jpg"))
                       .to(ContactUsPage.UPLOAD_FILE),
               Click.on(ContactUsPage.SUBMIT)
       );
   }
}
