package szakdolgozat.key.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import szakdolgozat.centralized.label.CentralizedLabel;
import szakdolgozat.key.text.area.PublicKeyTextArea;

import static szakdolgozat.texts.Texts.PUBLIC_KEY_LABEL_TEXT;

public class PublicKeyWidget extends VBox {

    public PublicKeyWidget() {
        final CentralizedLabel centralizedLabel = new CentralizedLabel(PUBLIC_KEY_LABEL_TEXT);
        final PublicKeyTextArea publicKeyTextArea = new PublicKeyTextArea();

        getChildren().add(centralizedLabel);
        getChildren().add(publicKeyTextArea);

        VBox.setMargin(centralizedLabel, new Insets(5, 5, 0, 5));
        VBox.setMargin(publicKeyTextArea, new Insets(0, 5, 5, 5));
    }
}
