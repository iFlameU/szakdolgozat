package szakdolgozat.transaction.submit.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.send.button.SendButton;

public class TransactionSubmitWidget extends HBox {

    public TransactionSubmitWidget() {
        getChildren().add(new SendButton());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));

    }
}
