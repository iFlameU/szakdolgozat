package szakdolgozat.block.chain.validator;

import szakdolgozat.block.Block;
import szakdolgozat.block.chain.BlockChain;
import szakdolgozat.checker.Checker;
import szakdolgozat.decrypter.Decrypter;
import szakdolgozat.transaction.Transaction;

public class BlockChainValidator {

    private Checker checker = new Checker();
    private Decrypter decrypter = new Decrypter();

    public boolean isValid(final BlockChain blockChain) {
        return blockChain.stream().allMatch(this::isValid);
    }

    private boolean isValid(final Block block) {
        if(block.getPreviousBlockHash().equals("0")) return true;
        if(!checker.isResolution(block.getResolution(), Integer.parseInt(block.getPreviousBlockHash()))) return false;
        return block.getTransactions().stream().allMatch(this::isValid);
    }

    private boolean isValid(final Transaction transaction) {
        return decrypter.decrypt(transaction.getSignature(), transaction.getSender())
                .equals(String.valueOf(transaction.hashCode()));
    }
}
