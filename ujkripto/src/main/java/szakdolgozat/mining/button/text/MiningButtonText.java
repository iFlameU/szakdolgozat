package szakdolgozat.mining.button.text;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static szakdolgozat.texts.Texts.MINING_BUTTON_TEXT_START;

public class MiningButtonText {

    private static final MiningButtonText instance = new MiningButtonText();
    private StringProperty textProperty = new SimpleStringProperty(MINING_BUTTON_TEXT_START);

    private MiningButtonText() {}

    public static MiningButtonText getInstance() {
        return instance;
    }

    public Property<String> getTextProperty() {
        return textProperty;
    }

    public void set(final String text) {
        textProperty.set(text);
    }
}
