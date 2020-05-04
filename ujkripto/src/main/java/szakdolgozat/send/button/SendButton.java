package szakdolgozat.send.button;

import javafx.scene.control.Button;
import szakdolgozat.send.button.event.handler.SendButtonEventHandler;

import static szakdolgozat.texts.Texts.SEND_BUTTON_TEXT;

public class SendButton extends Button {

    public SendButton() {
        setText(SEND_BUTTON_TEXT);
        setOnAction(new SendButtonEventHandler());
    }
}
