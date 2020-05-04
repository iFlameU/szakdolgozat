package szakdolgozat.transaction.key.text.area;

import javafx.scene.control.TextArea;
import szakdolgozat.texts.Texts;
import szakdolgozat.transaction.key.text.area.text.TransactionPublicKeyTextAreaText;

public class TransactionPublicKeyTextArea extends TextArea {

    public TransactionPublicKeyTextArea() {
        textProperty().bindBidirectional(TransactionPublicKeyTextAreaText.getInstance().getTextProperty());
        setPromptText(Texts.RECIEVER_PUBLIC_KEY_TEXT_AREA_PROMPT_TEXT);
        setWrapText(true);
        setMaxHeight(100);
    }
}
