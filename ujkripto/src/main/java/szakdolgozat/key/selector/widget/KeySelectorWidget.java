package szakdolgozat.key.selector.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.centralized.label.CentralizedLabel;
import szakdolgozat.key.selector.choice.box.KeySelectorChoiceBox;

import static szakdolgozat.texts.Texts.*;

public class KeySelectorWidget extends HBox {

    public KeySelectorWidget() {
        getChildren().add(new CentralizedLabel(KEY_SELECTOR_LABEL_TEXT));
        getChildren().add(new KeySelectorChoiceBox());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
