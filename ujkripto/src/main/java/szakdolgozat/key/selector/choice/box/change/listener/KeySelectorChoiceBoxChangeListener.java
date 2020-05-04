package szakdolgozat.key.selector.choice.box.change.listener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import szakdolgozat.ujkripto.Ujkripto;

public class KeySelectorChoiceBoxChangeListener implements ChangeListener<String> {

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        Ujkripto.getInstance().refreshKeyData();
    }
}
