package szakdolgozat.ujkripto.key.generator.widget.key.name.field.value;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static szakdolgozat.texts.Texts.EMPTY;

public class KeyGeneratorWidgetKeyNameFieldValue {

    private static KeyGeneratorWidgetKeyNameFieldValue instance = new KeyGeneratorWidgetKeyNameFieldValue();
    private StringProperty keyName = new SimpleStringProperty(EMPTY);

    private KeyGeneratorWidgetKeyNameFieldValue() {}

    public Property<String> getProperty() {
        return keyName;
    }

    public String get() {
        return keyName.get();
    }

    public void set(final String keyName) {
        this.keyName.set(keyName);
    }

    public static KeyGeneratorWidgetKeyNameFieldValue getInstance() {
        return instance;
    }

}
