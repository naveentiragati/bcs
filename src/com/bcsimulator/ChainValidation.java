package com.bcsimulator;

public class ChainValidation {

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[Sharables.Difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < BCSimulator.blockchain.size(); i++) {
            currentBlock = BCSimulator.blockchain.get(i);
            previousBlock = BCSimulator.blockchain.get(i-1);
            //compare the current hash and calculated hash:
            if(!currentBlock.EncryptedHash.equals(currentBlock.calculateEncryptedHash()) ){
                System.out.println("Current Hashes are not equal");
                return false;
            }
            //compare previous hash and current  hash
            if(!previousBlock.EncryptedHash.equals(currentBlock.previousBlockHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.EncryptedHash.substring( 0, Sharables.Difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }

        }
        return true;
    }
}
/**
 * Block Validation is implemented in different methods in various simulators available online.
 * I used the one which suits to or simulation.
 */