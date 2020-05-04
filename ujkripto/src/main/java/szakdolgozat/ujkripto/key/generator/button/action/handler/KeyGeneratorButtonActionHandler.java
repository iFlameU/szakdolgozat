package szakdolgozat.ujkripto.key.generator.button.action.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import szakdolgozat.ujkripto.Ujkripto;

public class KeyGeneratorButtonActionHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Ujkripto.getInstance().generateAndSaveKey();
    }
}
