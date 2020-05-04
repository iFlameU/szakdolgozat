package szakdolgozat.transaction.key.text.area.text;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static szakdolgozat.texts.Texts.EMPTY;

public class TransactionPublicKeyTextAreaText {
    private static final TransactionPublicKeyTextAreaText instance = new TransactionPublicKeyTextAreaText();
    private StringProperty textProperty = new SimpleStringProperty(EMPTY);

    private TransactionPublicKeyTextAreaText(){}

    public static TransactionPublicKeyTextAreaText getInstance() {
        return instance;
    }

    public Property<String> getTextProperty() {
        return textProperty;
    }

    public void set(final String publicKey) {
        textProperty.set(publicKey);
    }

    public String get() {
        return textProperty.get();
    }
}
