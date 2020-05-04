package szakdolgozat.mining.button.event.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import szakdolgozat.ujkripto.Ujkripto;

public class MiningButtonEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Ujkripto.getInstance().mine();
    }
}
