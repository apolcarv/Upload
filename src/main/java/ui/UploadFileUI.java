package ui;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class UploadFileUI {

    public static final Target VALID_HOME =  Target.the("Visualiza el inicio").located(By.xpath("//div[1]/h3"));
    public static final Target BTN_UPLOAD =  Target.the("Pulsa el boton cargar").located(By.id("file-submit"));
    public static final Target VALID_RESULT =  Target.the("Visualiza el resultado final").located(By.id("uploaded-files"));



}
