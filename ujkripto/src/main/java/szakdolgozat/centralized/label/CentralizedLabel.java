package szakdolgozat.centralized.label;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CentralizedLabel extends StackPane {

    private final Label label;

    public CentralizedLabel(final String text) {
        label = new Label(text);
        getChildren().add(label);
    }

    public StringProperty textProperty() {
        return label.textProperty();
    }
}
