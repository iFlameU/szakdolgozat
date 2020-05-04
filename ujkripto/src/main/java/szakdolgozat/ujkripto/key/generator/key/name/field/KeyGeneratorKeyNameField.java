package szakdolgozat.ujkripto.key.generator.key.name.field;

import javafx.scene.control.TextField;
import szakdolgozat.ujkripto.key.generator.widget.key.name.field.value.KeyGeneratorWidgetKeyNameFieldValue;

import static szakdolgozat.texts.Texts.KEY_GENERATOR_KEY_NAME_FIELD_PROMPT_TEXT;

public class KeyGeneratorKeyNameField extends TextField {

    public KeyGeneratorKeyNameField() {
        setPromptText(KEY_GENERATOR_KEY_NAME_FIELD_PROMPT_TEXT);
        textProperty().bindBidirectional(KeyGeneratorWidgetKeyNameFieldValue.getInstance().getProperty());
    }
}
