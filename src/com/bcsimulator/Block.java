package com.bcsimulator;
import java.util.Date;
public class Block {
    public String EncryptedHash; // the has value
    public String previousBlockHash;// storing previous hash in string
    private String data;
    private long timeStamp; //this is number in milliseconds.
    private int nonce; // value to mine a block

//Defining Block Constructor.
public Block(String previousBlockHash ){
    this.previousBlockHash = previousBlockHash;
    this.data = getData();
    this.timeStamp = new Date().getTime();
    this.EncryptedHash = calculateEncryptedHash(); //Making sure we do this after we set the other values.

}

//Calculating the HASH values

    public String calculateEncryptedHash() {
        String calculatedEncryptedhash = ShaHash.applySha256(
                previousBlockHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce)
                + data
        );
        return calculatedEncryptedhash;
    }

    //Calculated new hash based on blocks contents is returend-----------------

    public String getData() {

        //String a = Block.previousBlockHash;
        //if (BCSimulator.GraphTopology.get(0) )
        String blockdata = "Contains Data of all Transactions";
                return blockdata;
    }

    //Increments nonce value until hash target is reached.
    public void mineBlock(int difficulty) {
        String target = Tasks.getDificultyString(difficulty); //a string with difficulty number of zeros is created
        //System.out.println("this is target :" + " " + target);
        while(!EncryptedHash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            //System.out.println("EncryptedHash.substring( 0, difficulty):"+EncryptedHash.substring( 0, difficulty));
            //System.out.println(nonce);
            EncryptedHash = calculateEncryptedHash();
        }
        Tasks.printInGreen("Block Mined!!! : " + EncryptedHash);
    }

}

/**
 * sha256, block mining is taken from different simulators available online
 */
