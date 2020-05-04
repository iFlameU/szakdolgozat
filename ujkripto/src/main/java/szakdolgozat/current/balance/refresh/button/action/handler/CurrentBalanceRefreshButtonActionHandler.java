package szakdolgozat.current.balance.refresh.button.action.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import szakdolgozat.ujkripto.Ujkripto;

public class CurrentBalanceRefreshButtonActionHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Ujkripto.getInstance().refreshCurrentBalance();
    }
}
