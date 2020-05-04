package szakdolgozat.balancer;

import szakdolgozat.block.Block;
import szakdolgozat.block.chain.BlockChain;
import szakdolgozat.transaction.Transaction;

import java.util.concurrent.atomic.AtomicReference;

public class Balancer {

    private static final Balancer instance = new Balancer();

    private Balancer(){}

    public static Balancer getInstance() {
        return instance;
    }

    public double getBalance(final BlockChain blockChain, final String publicKeyAsString) {
        AtomicReference<Double> balance = new AtomicReference<>((double) 0);
        blockChain.forEach(block -> balance.updateAndGet(v -> v + getBalance(block, publicKeyAsString)));
        return balance.get();
    }

    private double getBalance(final Block block, final String publicKeyAsString) {
        AtomicReference<Double> balance = new AtomicReference<>((double) 0);
        if(block.getResolver().equals(publicKeyAsString)) balance.updateAndGet(v -> v + 1);
        block.getTransactions()
                .forEach(transaction -> balance.updateAndGet(v -> v + getBalance(transaction, publicKeyAsString)));
        return balance.get();
    }

    private double getBalance(final Transaction transaction, final String publicKeyAsString) {
        double amount = 0;
        if(transaction.getReceiver().equals(publicKeyAsString)) amount += transaction.getAmount();
        if(transaction.getSender().equals(publicKeyAsString)) amount -= transaction.getAmount();
        return amount;
    }
}
