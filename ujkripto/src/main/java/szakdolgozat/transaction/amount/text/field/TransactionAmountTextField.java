package szakdolgozat.transaction.amount.text.field;

import javafx.scene.control.TextField;
import szakdolgozat.transaction.amount.text.field.text.TransactionAmountTextFieldText;

public class TransactionAmountTextField extends TextField {

    public TransactionAmountTextField() {
        textProperty().bindBidirectional(TransactionAmountTextFieldText.getInstance().getTextProperty());
    }
}
