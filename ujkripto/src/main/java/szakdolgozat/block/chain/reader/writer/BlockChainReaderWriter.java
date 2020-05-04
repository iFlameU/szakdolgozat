package szakdolgozat.block.chain.reader.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import szakdolgozat.block.Block;
import szakdolgozat.block.chain.BlockChain;
import szakdolgozat.block.chain.change.to.exception.BlockChainChangeToException;
import szakdolgozat.block.chain.read.exception.BlockChainReadException;
import szakdolgozat.block.chain.write.block.exception.BlockChainWriteBlockException;
import szakdolgozat.block.chain.write.transaction.exception.BlockChainWriteTransactionException;
import szakdolgozat.config.Config;
import szakdolgozat.property.loader.PropertyLoader;
import szakdolgozat.transaction.Transaction;
import szakdolgozat.ujkripto.server.UjkriptoServer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class BlockChainReaderWriter {

    private ReentrantLock lock = new ReentrantLock();
    private ObjectMapper mapper = new ObjectMapper();
    private String block_chainJson = PropertyLoader.load(Config.PATH).getProperty(Config.Properties.BLOCK_CHAIN);

    public BlockChain read() {
        lock.lock();
        try {
            return mapper.readValue(new File(block_chainJson), BlockChain.class);
        } catch (IOException e) {
            throw new BlockChainReadException();
        } finally {
            lock.unlock();
        }
    }

    public void save(final Block block) {
        lock.lock();
        try {
            BlockChain blockChain = mapper.readValue(new File(block_chainJson), BlockChain.class);
            blockChain.add(block);
            writeToFile(blockChain);
        } catch (IOException e) {
            throw new BlockChainWriteBlockException();
        } finally {
            lock.unlock();
        }
    }

    public void save(final Transaction transaction) {
        lock.lock();
        try {
            BlockChain blockChain = mapper.readValue(new File(block_chainJson), BlockChain.class);
            blockChain.getLast().getTransactions().add(transaction);
            writeToFile(blockChain);
        } catch (IOException e) {
            throw new BlockChainWriteTransactionException();
        } finally {
            lock.unlock();
        }
    }

    private void writeToFile(BlockChain blockChain) throws IOException {
        mapper.writeValue(new File(block_chainJson), blockChain);
        UjkriptoServer.getInstance().send(blockChain);
    }

    public void changeTo(final BlockChain blockChain) {
        lock.lock();
        try {
            BlockChain oldBlockChain = mapper.readValue(new File(block_chainJson), BlockChain.class);
            if (!oldBlockChain.equals(blockChain)) {
                writeToFile(blockChain);
            }
        } catch (IOException e) {
            throw new BlockChainChangeToException();
        } finally {
            lock.unlock();
        }
    }
}
