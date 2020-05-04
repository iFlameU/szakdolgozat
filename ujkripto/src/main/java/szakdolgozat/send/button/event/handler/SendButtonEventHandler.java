package szakdolgozat.send.button.event.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import szakdolgozat.ujkripto.Ujkripto;

public class SendButtonEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Ujkripto.getInstance().sendTransaction();
    }
}
