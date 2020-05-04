package szakdolgozat.ujkripto.key.generator.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.ujkripto.key.generator.button.KeyGeneratorButton;
import szakdolgozat.ujkripto.key.generator.key.name.field.KeyGeneratorKeyNameField;

public class KeyGeneratorWidget extends HBox {

    public KeyGeneratorWidget() {
        getChildren().add(new KeyGeneratorButton());
        getChildren().add(new KeyGeneratorKeyNameField());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
