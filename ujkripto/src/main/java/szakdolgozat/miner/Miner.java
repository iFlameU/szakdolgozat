package szakdolgozat.miner;

import szakdolgozat.block.chain.controller.BlockChainController;
import szakdolgozat.mining.thread.MiningThread;

public class Miner {

    private MiningThread miningThread = new MiningThread();

    public boolean isMining() {
        return miningThread.isMining();
    }

    public void stop() {
        miningThread.setMiningFalse();
    }

    public void start(final String publicKeyAsString, BlockChainController blockChainController) {
        miningThread = new MiningThread();
        miningThread.setSolver(publicKeyAsString);
        miningThread.setBlockChainController(blockChainController);
        miningThread.start();
    }
}
