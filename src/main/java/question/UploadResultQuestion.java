package question;


import actions.Time;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.UploadFileUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class UploadResultQuestion implements Question {
    private final String Resultado;

    public UploadResultQuestion(String resultado) {
        Resultado = resultado;
           }

    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(UploadFileUI.VALID_RESULT, containsText(Resultado)).forNoMoreThan(20).seconds());
        return true;

    }

    public static UploadResultQuestion ResultValid (String resultado){
        return new UploadResultQuestion(resultado);
    }

}