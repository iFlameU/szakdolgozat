package szakdolgozat.current.balance.label;

import szakdolgozat.centralized.label.CentralizedLabel;
import szakdolgozat.current.balance.text.CurrentBalanceText;

import static szakdolgozat.texts.Texts.EMPTY;

public class CurrentBalanceLabel extends CentralizedLabel {
    public CurrentBalanceLabel() {
        super(EMPTY);

        textProperty().bindBidirectional(CurrentBalanceText.getInstance().getTextProperty());
    }
}
