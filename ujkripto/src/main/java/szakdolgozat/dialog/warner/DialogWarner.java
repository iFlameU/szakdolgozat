package szakdolgozat.dialog.warner;

import szakdolgozat.warning.dialog.WarningDialog;

public class DialogWarner {

    public void show(final String message) {
        new WarningDialog(message);
    }
}
