package szakdolgozat.transaction.amount.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.centralized.label.CentralizedLabel;
import szakdolgozat.transaction.amount.text.field.TransactionAmountTextField;

import static szakdolgozat.texts.Texts.TRANSACTION_AMOUNT;

public class TransactionAmountWidget extends HBox {

    public TransactionAmountWidget() {
        getChildren().add(new CentralizedLabel(TRANSACTION_AMOUNT));
        getChildren().add(new TransactionAmountTextField());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
