package szakdolgozat.ujkripto.layout;

import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import szakdolgozat.current.balance.widget.CurrentBalanceWidget;
import szakdolgozat.key.selector.widget.KeySelectorWidget;
import szakdolgozat.key.widget.PublicKeyWidget;
import szakdolgozat.mining.widget.MiningWidget;
import szakdolgozat.transaction.key.widget.TransactionWidget;
import szakdolgozat.ujkripto.key.generator.widget.KeyGeneratorWidget;

public class UjkriptoLayout extends VBox {

    public UjkriptoLayout() {
        getChildren().add(new KeyGeneratorWidget());
        getChildren().add(new CurrentBalanceWidget());
        getChildren().add(new KeySelectorWidget());
        getChildren().add(new PublicKeyWidget());
        getChildren().add(new Separator());
        getChildren().add(new MiningWidget());
        getChildren().add(new Separator());
        getChildren().add(new TransactionWidget());
    }
}
