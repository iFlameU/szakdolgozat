package szakdolgozat.key.text.area;

import javafx.scene.control.TextArea;
import szakdolgozat.key.text.area.text.PublicKeyTextAreaText;

public class PublicKeyTextArea extends TextArea {

    public PublicKeyTextArea() {
        textProperty().bindBidirectional(PublicKeyTextAreaText.getInstance().getTextProperty());
        setWrapText(true);
        setEditable(false);
        setMaxHeight(100);
    }
}
