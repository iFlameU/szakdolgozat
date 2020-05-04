package szakdolgozat.transaction.amount.text.field.text;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static szakdolgozat.texts.Texts.EMPTY;

public class TransactionAmountTextFieldText {

    private static final TransactionAmountTextFieldText instance = new TransactionAmountTextFieldText();
    private StringProperty textProperty = new SimpleStringProperty(EMPTY);

    private TransactionAmountTextFieldText(){}

    public static TransactionAmountTextFieldText getInstance() {
        return instance;
    }

    public Property<String> getTextProperty() {
        return textProperty;
    }

    public String get() {
        return textProperty.get();
    }

    public void set(final String amount) {
        textProperty.set(amount);
    }
}
