import di.DependencyInjection;
import entity.Block;
import factory.BlockFactory;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {

        DependencyInjection.initialize();

        blockchain.add(BlockFactory.generateBlock("Hi im the first block", "0"));
        System.out.println("Hash for block 1 : " + blockchain.get(0).hash());

        blockchain.add(BlockFactory.generateBlock("Yo im the second block", blockchain.get(blockchain.size()-1).hash()));
        System.out.println("Hash for block 2 : " + blockchain.get(1).hash());


        Block second = blockchain.get(1);
        System.out.println(second.prevHash() + second.timestamp() + second.data());

        blockchain.add(BlockFactory.generateBlock("Hey im the third block", blockchain.get(blockchain.size()-1).hash()));
        System.out.println("Hash for block 3 : " + blockchain.get(2).hash());
    }
}
