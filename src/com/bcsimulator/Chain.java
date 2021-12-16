package com.bcsimulator;

public class Chain {
    public static void appendChain(Block newBlock) {
        newBlock.mineBlock(Sharables.Difficulty); // mining simulated here
        BCSimulator.blockchain.add(newBlock);

    }
}
