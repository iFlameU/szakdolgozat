package szakdolgozat.key.text.area.text;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static szakdolgozat.texts.Texts.EMPTY;

public class PublicKeyTextAreaText {

    private static final PublicKeyTextAreaText instance = new PublicKeyTextAreaText();
    private StringProperty textProperty = new SimpleStringProperty(EMPTY);

    private PublicKeyTextAreaText(){}

    public static PublicKeyTextAreaText getInstance() {
        return instance;
    }

    public Property<String> getTextProperty() {
        return textProperty;
    }

    public void set(final String publicKey) {
        textProperty.set(publicKey);
    }
}
