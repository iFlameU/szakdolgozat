package szakdolgozat.mining.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.mining.button.MiningButton;

public class MiningWidget extends HBox {

    public MiningWidget() {
        getChildren().add(new MiningButton());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
