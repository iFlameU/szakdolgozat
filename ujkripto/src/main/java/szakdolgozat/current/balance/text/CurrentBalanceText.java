package szakdolgozat.current.balance.text;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import szakdolgozat.texts.Texts;

public class CurrentBalanceText {

    private static final CurrentBalanceText instance = new CurrentBalanceText();
    private StringProperty textProperty = new SimpleStringProperty(Texts.CURRENT_BALANCE_TEXT);

    private CurrentBalanceText() {}

    public static CurrentBalanceText getInstance() {
        return instance;
    }

    public Property<String> getTextProperty() {
        return textProperty;
    }

    public void set(final String currentBalanceText) {
        textProperty.set(currentBalanceText);
    }
}
