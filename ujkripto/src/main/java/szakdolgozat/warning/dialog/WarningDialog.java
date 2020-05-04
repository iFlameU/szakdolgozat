package szakdolgozat.warning.dialog;

import javafx.scene.control.Alert;

import static javafx.scene.control.Alert.AlertType.WARNING;
import static szakdolgozat.texts.Texts.WARNING_DIALOG_TITLE;

public class WarningDialog extends Alert {
    public WarningDialog(final String message) {
        super(WARNING);
        setTitle(WARNING_DIALOG_TITLE);
        setHeaderText(null);
        setContentText(message);
        showAndWait();
    }
}
