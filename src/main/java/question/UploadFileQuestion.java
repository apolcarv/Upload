package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.UploadFileUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class UploadFileQuestion  implements Question {
    private final String  Inicio;

    public UploadFileQuestion(String inicio) {
        Inicio = inicio;
    }


    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(UploadFileUI.VALID_HOME, containsText(Inicio)).forNoMoreThan(20).seconds());
        return true;
    }

    public static UploadFileQuestion InicioValid (String inicio) {
        return new UploadFileQuestion(inicio);
    }
}
