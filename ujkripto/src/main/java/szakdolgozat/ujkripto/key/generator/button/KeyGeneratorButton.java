package szakdolgozat.ujkripto.key.generator.button;

import javafx.scene.control.Button;
import szakdolgozat.ujkripto.key.generator.button.action.handler.KeyGeneratorButtonActionHandler;

import static szakdolgozat.texts.Texts.KEY_GENERATOR_BUTTON_TEXT;

public class KeyGeneratorButton extends Button {

    public KeyGeneratorButton() {
        setText(KEY_GENERATOR_BUTTON_TEXT);
        setOnAction(new KeyGeneratorButtonActionHandler());
    }
}
