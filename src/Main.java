import di.DependencyInjection;
import entity.Block;
import factory.BlockFactory;
import service.chain.BlockchainService;
import service.mining.MiningService;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {

        DependencyInjection.initialize();

        Block genesisBlock = BlockFactory.generateBlock("Hi I'm the first block", "0");
        genesisBlock = MiningService.mineBlock(genesisBlock, 5);
        blockchain.add(genesisBlock);


        Block secondBlock = BlockFactory.generateBlock("Yo I'm the second block", genesisBlock.hash());
        secondBlock = MiningService.mineBlock(secondBlock, 5);
        blockchain.add(secondBlock);

        Block thirdBlock = BlockFactory.generateBlock("Hey I'm the third block", secondBlock.hash());
        thirdBlock = MiningService.mineBlock(thirdBlock, 4);
        blockchain.add(thirdBlock);

        boolean isChainValid = BlockchainService.isChainValid(blockchain);
        System.out.println("Blockchain is valid: " + isChainValid);
    }
}
