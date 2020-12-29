package task;


import actions.Time;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.UploadFileUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class UploadFileTask implements Task {




    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Robot toma el mando");
        try {
            Robot robot = new Robot();
            //Mouse se mueve al boton Carga de archivos
            robot.mouseMove(621, 255);

            //click en el boton izquierdo
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            // Suelta el click izquierdp
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            // //Mouse se mueve donde esta el archivo
            robot.mouseMove(700, 285);

        }catch (AWTException e) {
            e.printStackTrace();
        }


        try {
            Robot robot = new Robot();

            Thread.currentThread().sleep(3000);

          //  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        }catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
            //  ruta donde esta el archivo
        String fileLocation = ("C:\\Users\\alejandro.polo\\Desktop\\AutomatizacionPragma\\src\\test\\resources\\data\\Info.txt");
        StringSelection filepath = new StringSelection(fileLocation);
       // Tomar la ruta que se almacena dentro de la variable filepath en el portapapeles o memoria temporal
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
        //    System.out.println("ruta esta en memoria");

        try {
            Robot robot = new Robot();


            // Press Ctrl key
            robot.keyPress(KeyEvent.VK_CONTROL);
            // Press Ctrl + V key - It will paste the file path in windows dialog
            robot.keyPress(KeyEvent.VK_V);

            // Now release V + Ctrl key
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Click Enter Key

            robot.keyPress(KeyEvent.VK_ENTER);

            // Release Enter Key
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
        System.out.println("Robot suelta mando");
        System.out.println("ya tomo el archivo");
        Time.getTimeThree();

        actor.attemptsTo(Click.on(UploadFileUI.BTN_UPLOAD));

    }
    public static Performable UploadFileTask(){
        return instrumented(UploadFileTask.class);
    }
}

