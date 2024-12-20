package entity;

import di.DependencyInjection;

import java.util.ArrayList;

public class Blockchain {

    // function compares hashes to confirm validity
    public static Boolean isChainValid(ArrayList<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash().equals(DependencyInjection.getBlockchain().calculateHash(
                    currentBlock.prevHash(),
                    currentBlock.data(),
                    currentBlock.timestamp()
            ))) {
                return false;
            }

            if (!previousBlock.hash().equals(currentBlock.prevHash()))
                return false;
        }
        return true;
    }


    public String calculateHash (
            final String previousHash,
            final String data,
            final long timestamp
    ) {
        return DependencyInjection.getHashingService().encryptHash(
                previousHash + timestamp + data
        );
    }
}


