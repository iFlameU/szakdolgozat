package szakdolgozat.current.balance.refresh.button;

import javafx.scene.control.Button;
import szakdolgozat.current.balance.refresh.button.action.handler.CurrentBalanceRefreshButtonActionHandler;
import szakdolgozat.texts.Texts;

public class CurrentBalanceRefreshButton extends Button {

    public CurrentBalanceRefreshButton() {
        setText(Texts.REFRESH_BUTTON_TEXT);
        setOnAction(new CurrentBalanceRefreshButtonActionHandler());
    }
}
