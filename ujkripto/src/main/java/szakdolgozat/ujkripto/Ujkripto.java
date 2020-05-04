package szakdolgozat.ujkripto;

import szakdolgozat.block.chain.controller.BlockChainController;
import szakdolgozat.current.balance.text.CurrentBalanceText;
import szakdolgozat.dialog.warner.DialogWarner;
import szakdolgozat.key.NamedKeyPair;
import szakdolgozat.key.selector.choice.box.values.KeySelectChoiceBoxOptions;
import szakdolgozat.key.text.area.text.PublicKeyTextAreaText;
import szakdolgozat.keys.controller.KeysController;
import szakdolgozat.miner.Miner;
import szakdolgozat.mining.button.text.MiningButtonText;
import szakdolgozat.texts.Texts;
import szakdolgozat.transaction.amount.text.field.text.TransactionAmountTextFieldText;
import szakdolgozat.transaction.key.text.area.text.TransactionPublicKeyTextAreaText;
import szakdolgozat.ujkripto.key.generator.KeyGenerator;
import szakdolgozat.ujkripto.key.generator.widget.key.name.field.value.KeyGeneratorWidgetKeyNameFieldValue;
import szakdolgozat.ujkripto.server.UjkriptoServer;

import java.util.List;

import static szakdolgozat.texts.Texts.CURRENT_BALANCE_TEXT_PRETEXT;
import static szakdolgozat.texts.Texts.EMPTY;
import static szakdolgozat.texts.Texts.MINING_BUTTON_TEXT_START;
import static szakdolgozat.texts.Texts.MINING_BUTTON_TEXT_STOP;
import static szakdolgozat.texts.Texts.WANING_TRANSACTION_NO_KEY;
import static szakdolgozat.texts.Texts.WARNING_GENERATE_KEY_KEY_NAME_ALREADY_IN_USE;
import static szakdolgozat.texts.Texts.WARNING_GENERATE_KEY_NO_KEY_NAME;
import static szakdolgozat.texts.Texts.WARNING_MINING_NO_KEY;
import static szakdolgozat.texts.Texts.WARNING_TRANSACITON_AMOUNT_TOO_SPECIFIC;
import static szakdolgozat.texts.Texts.WARNING_TRANSACTION_AMOUNT_NOT_DOUBLE;
import static szakdolgozat.texts.Texts.WARNING_TRANSACTION_NO_RECEIVER;

public class Ujkripto {
    private static final String NUMBER_WITH_TWO_DECIMALS_REGEX = "[\\+\\-]?(\\d+)|[\\+\\-]?(\\d+)\\.(\\d){1,2}";
    private static Ujkripto instance = new Ujkripto();
    private final BlockChainController blockChainController = BlockChainController.getInstance();
    private final KeyGenerator keyGenerator = new KeyGenerator();
    private final KeyGeneratorWidgetKeyNameFieldValue keyGeneratorWidgetKeyNameFieldValue =
            KeyGeneratorWidgetKeyNameFieldValue.getInstance();
    private final KeySelectChoiceBoxOptions keySelectChoiceBoxOptions = KeySelectChoiceBoxOptions.getInstance();
    private final PublicKeyTextAreaText publicKeyTextAreaText = PublicKeyTextAreaText.getInstance();
    private final TransactionPublicKeyTextAreaText transactionPublicKeyTextAreaText = TransactionPublicKeyTextAreaText.getInstance();
    private final TransactionAmountTextFieldText transactionAmountTextFieldText = TransactionAmountTextFieldText.getInstance();
    private DialogWarner dialogWarner;
    private KeysController keysController = KeysController.getInstance();
    private Miner miner = new Miner();
    private final MiningButtonText miningButtonText = MiningButtonText.getInstance();

    public static Ujkripto getInstance() {
        return instance;
    }

    private Ujkripto() {
        UjkriptoServer.getInstance().start();
        final List<String> allKeyNames = keysController.getAllKeyNames();
        if (allKeyNames.size() > 0) {
            keySelectChoiceBoxOptions.getKeySelectorChoiceBoxOptions().addAll(allKeyNames);
            keySelectChoiceBoxOptions.setValue(allKeyNames.get(0));
            refreshKeyData();
        }

    }

    public void refreshKeyData() {
        final String keyName = keySelectChoiceBoxOptions.getValue();
        refreshCurrentBalance();
        publicKeyTextAreaText.set(keysController.get(keyName).getPublicKey());
    }

    public void sendTransaction() {
        final String keyName = keySelectChoiceBoxOptions.getValue();
        final String receiver = transactionPublicKeyTextAreaText.get();
        final String amount = transactionAmountTextFieldText.get();
        if (keyName.equals(EMPTY)) dialogWarner.show(WANING_TRANSACTION_NO_KEY);
        else if (receiver.equals(EMPTY)) dialogWarner.show(WARNING_TRANSACTION_NO_RECEIVER);
        else if (notDouble(amount)) dialogWarner.show(WARNING_TRANSACTION_AMOUNT_NOT_DOUBLE);
        else if (!amount.matches(NUMBER_WITH_TWO_DECIMALS_REGEX))
            dialogWarner.show(WARNING_TRANSACITON_AMOUNT_TOO_SPECIFIC);
        else {
            final double amountAsNumber = Double.parseDouble(amount);
            final NamedKeyPair namedKeyPair = keysController.get(keyName);
            if (amountAsNumber > blockChainController.getBalanceFor(namedKeyPair.getPublicKey()))
                dialogWarner.show(Texts.WARNING_TRANSACTION_NOT_ENOUGH_MONEY);
            else {
                transactionPublicKeyTextAreaText.set(EMPTY);
                transactionAmountTextFieldText.set(EMPTY);
                blockChainController.addTransaction(namedKeyPair, receiver, amountAsNumber);
                refreshCurrentBalance();
            }
        }
    }

    private boolean notDouble(final String amount) {
        try {
            Double.parseDouble(amount);
            return false;
        } catch (NumberFormatException expected) {
            return true;
        }
    }

    public void refreshCurrentBalance() {
        CurrentBalanceText.getInstance().set(CURRENT_BALANCE_TEXT_PRETEXT +
                blockChainController.getBalanceFor(
                        keysController.get(keySelectChoiceBoxOptions.getValue()).getPublicKey()));
    }

    public void generateAndSaveKey() {
        final String keyName = keyGeneratorWidgetKeyNameFieldValue.get();
        if (keyName.equals(EMPTY)) dialogWarner.show(WARNING_GENERATE_KEY_NO_KEY_NAME);
        else if (keysController.contains(keyName)) dialogWarner.show(WARNING_GENERATE_KEY_KEY_NAME_ALREADY_IN_USE);
        else {
            keysController.save(keyName, keyGenerator.generateKey());
            keyGeneratorWidgetKeyNameFieldValue.set(EMPTY);
            keySelectChoiceBoxOptions.add(keyName);
            publicKeyTextAreaText.set(keysController.get(keyName).getPublicKey());
        }
    }

    public void setDialogWarner(DialogWarner dialogWarner) {
        this.dialogWarner = dialogWarner;
    }

    public void mine() {
        if (miner.isMining()) {
            miner.stop();
            miningButtonText.set(MINING_BUTTON_TEXT_START);
            refreshCurrentBalance();
        } else {
            final String keyName = keySelectChoiceBoxOptions.getValue();
            if (keyName.equals(EMPTY)) {
                dialogWarner.show(WARNING_MINING_NO_KEY);
                return;
            }
            miner.start(keysController.get(keyName).getPublicKey(), blockChainController);
            miningButtonText.set(MINING_BUTTON_TEXT_STOP);
        }
    }
}
