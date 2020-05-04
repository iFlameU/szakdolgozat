package szakdolgozat.key.selector.choice.box;

import javafx.scene.control.ChoiceBox;
import szakdolgozat.key.selector.choice.box.change.listener.KeySelectorChoiceBoxChangeListener;
import szakdolgozat.key.selector.choice.box.values.KeySelectChoiceBoxOptions;

public class KeySelectorChoiceBox extends ChoiceBox<String> {

    public KeySelectorChoiceBox() {
        super(KeySelectChoiceBoxOptions.getInstance().getKeySelectorChoiceBoxOptions());
        valueProperty().bindBidirectional(KeySelectChoiceBoxOptions.getInstance().getKeySelectorChoiceBoxValue());
        valueProperty().addListener(new KeySelectorChoiceBoxChangeListener());
    }
}
