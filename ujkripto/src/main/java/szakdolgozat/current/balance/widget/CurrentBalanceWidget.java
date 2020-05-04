package szakdolgozat.current.balance.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import szakdolgozat.current.balance.label.CurrentBalanceLabel;
import szakdolgozat.current.balance.refresh.button.CurrentBalanceRefreshButton;

public class CurrentBalanceWidget extends HBox {

    public CurrentBalanceWidget() {

        getChildren().add(new CurrentBalanceLabel());
        getChildren().add(new CurrentBalanceRefreshButton());

        getChildren().forEach(child -> HBox.setMargin(child, new Insets(5, 5, 5, 5)));
    }
}
