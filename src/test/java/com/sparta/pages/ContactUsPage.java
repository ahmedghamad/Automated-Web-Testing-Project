package com.sparta.pages;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactUsPage extends PageObject {

//declare constants:
    public static final String URL = "https://automationexercise.com/contact_us";
    public static final Target NAME =
            Target.the("name field")
                    .locatedBy("input[name='name']");
    public static final Target EMAIL =
            Target.the("email field")
                    .locatedBy("input[name = 'email']");
    public static final Target SUBJECT =
            Target.the("subject field")
                    .locatedBy("input[name = 'subject']");
    public static final Target MESSAGE =
            Target.the("message field")
                    .locatedBy("textarea[name = 'message']");
    public static final Target UPLOAD_FILE =
            Target.the("upload file input")
                    .locatedBy("input[name = 'upload_file]");
    public static final Target SUBMIT =
            Target.the("submit button")
                    .locatedBy("input[name = 'submit'] ");
    public static final Target SUCCESS_MESSAGE =
            Target.the("success message field")
                    .locatedBy(".status.alert.alert-success");

}
