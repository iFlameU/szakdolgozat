package szakdolgozat.mining.button;

import javafx.scene.control.Button;
import szakdolgozat.mining.button.event.handler.MiningButtonEventHandler;
import szakdolgozat.mining.button.text.MiningButtonText;

public class MiningButton extends Button {

    public MiningButton() {
        textProperty().bindBidirectional(MiningButtonText.getInstance().getTextProperty());
        setOnAction(new MiningButtonEventHandler());
    }
}
