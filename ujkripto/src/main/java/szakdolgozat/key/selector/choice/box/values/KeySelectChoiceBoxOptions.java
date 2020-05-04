package szakdolgozat.key.selector.choice.box.values;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static szakdolgozat.texts.Texts.EMPTY;

public class KeySelectChoiceBoxOptions {

    private static final KeySelectChoiceBoxOptions instance = new KeySelectChoiceBoxOptions();
    private final ObservableList<String> keySelectorChoiceBoxOptions = FXCollections.observableArrayList();
    private StringProperty keySelectorChoiceBoxValue = new SimpleStringProperty(EMPTY);

    private KeySelectChoiceBoxOptions(){}

    public static KeySelectChoiceBoxOptions getInstance() {
        return instance;
    }

    public ObservableList<String> getKeySelectorChoiceBoxOptions() {
        return keySelectorChoiceBoxOptions;
    }

    public void add(final String newOption) {
        keySelectorChoiceBoxOptions.add(newOption);
        keySelectorChoiceBoxValue.set(newOption);
    }

    public Property<String> getKeySelectorChoiceBoxValue() {
        return keySelectorChoiceBoxValue;
    }

    public String getValue() {
        return keySelectorChoiceBoxValue.get();
    }

    public void setValue(final String keyName) {
        keySelectorChoiceBoxValue.set(keyName);
    }
}
