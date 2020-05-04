package szakdolgozat.transaction.key.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import szakdolgozat.centralized.label.CentralizedLabel;
import szakdolgozat.transaction.submit.widget.TransactionSubmitWidget;
import szakdolgozat.transaction.amount.widget.TransactionAmountWidget;
import szakdolgozat.transaction.key.text.area.TransactionPublicKeyTextArea;

import static szakdolgozat.texts.Texts.TRANSACTION_LABEL_TEXT;

public class TransactionWidget extends VBox {

    public TransactionWidget() {

        getChildren().add(new CentralizedLabel(TRANSACTION_LABEL_TEXT));
        getChildren().add(new TransactionPublicKeyTextArea());
        getChildren().add(new TransactionAmountWidget());
        getChildren().add(new TransactionSubmitWidget());

        getChildren().forEach(child -> VBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
