/**
 *
 * @author Naveen Tiragati (Masters Student at UMKC)
 * Project for the Course "An Introduction to Blockchain"
 * Email id: ntdpm@umsystem.edu
 * Version 2.0
 */
package com.bcsimulator;
import java.util.ArrayList;
import java.lang.Thread;
import com.google.gson.GsonBuilder;
import java.util.Scanner;
public class BCSimulator {



    public static void main(String[] args) {

        //RunPowNode();
        RunPosNode(); // under implementation

/**
        ************************FUTURE WORK********************************
 average extrapolated aggregated propagation time of different consensus and compare them

 implementing coin age based selection of deligates insted of randon selection

       for (int n =0 ; n < 1; n++)

         {
            PropagationtimePow();
            PropagationtimePos();

         }
 */



    }
    private static void RunPowNode(){
        //long startTime = System.currentTimeMillis();

        Tasks.printInGreen("----------------------------------------------------------------------------------------------");
        Tasks.printInRed("Running nodes based on Proof of Work...");
        Tasks.printInGreen("----------------------------------------------------------------------------------------------");

        System.out.println("Actual Number of nodes are: "+ " "+Sharables.NoOfNodes);
        Tasks.printInRed("Network Topology being generated!!..");
        Tasks.topology();


        ArrayList<Integer> GraphTopology = new ArrayList<Integer>();
        for (int i = 0; i < Sharables.NoOfNodes; i++) {
            GraphTopology.add(i);

        }
        Tasks.printInRed("The linear Graph Topology(Network topology):\n");

        Tasks.printInGreen(GraphTopology.toString());

        System.out.println("Mining block Genesis... ");
        Chain.appendChain(new Block( "0"));

        for (int i = 1; i < Sharables.NoOfNodes; i++) {
            System.out.println("Mining block "+ i+ " ... ");

            Chain.appendChain(new Block(blockchain.get(blockchain.size()-1).EncryptedHash));

        }

        String blockchainJson = Tasks.getJson(blockchain);

        //Tasks.printInRed("\nThe block chain Data Structure: ");
        //----------chain of transactions--------------------
        //Tasks.printInRed("\nThe block chain history: ");
        //System.out.println(blockchainJson);
        //System.out.println(blockchainJson); // implemented using Google  Gson
        // Gson is used to serialize Java objects to JSON and vice versa!
        Tasks.printInGreen("\nBlockchain is Valid: " + ChainValidation.isChainValid());


    }


    private static void RunPosNode(){

        Tasks.printInGreen("------------------------------------------------------------------------------------------------------");
        Tasks.printInRed("Running nodes based on Deligated Proof of stake...");
        Tasks.printInGreen("----------------------------------------------------------------------------------------------");
        System.out.println("Actual Number of nodes are: "+ " "+Sharables.DposNoOfNodes);
        System.out.println("Deligate Number of nodes are: "+ " "+Sharables.DposDeligatesNodes);
        Tasks.printInRed("Network Topology being generated!!..");
        Tasks.topology();

        //long startTime = System.currentTimeMillis();
        difficultyness();
        ArrayList<Integer> ActualGraph = new ArrayList<Integer>();
        for (int i = 0; i < Sharables.DposNoOfNodes; i++) {
            ActualGraph.add(i);

        }
        System.out.println("The linear Graph:\n");
        System.out.println(ActualGraph.toString());

        ArrayList<Integer> SubGraph = new ArrayList<Integer>();
        for (int j = 0; j < Sharables.DposDeligatesNodes; j++) {
            int Deligate;
            Deligate = Tasks.getRandomNumberInRange(0, ActualGraph.size() - 1);//
            //System.out.println(Deligate);
            SubGraph.add(Deligate);
        }
        System.out.println("The linear SubGraph of elected deligates:\n");
        System.out.println(SubGraph.toString());

        System.out.println("Trying to Mine block Genesis... ");
        Chain.appendChain(new Block( "0"));

        for (int k = 1; k < Sharables.DposDeligatesNodes+1; k++) {
            //------
            System.out.println("Elected Deligated " + " " + SubGraph.get(k-1) + " " + "Trying to Mine a Block: ");
            //System.out.println("Trying to Mine block "+ SubGraph.get(i-1) + " ... ");

            Chain.appendChain(new Block(blockchain.get(blockchain.size()-1).EncryptedHash));

        }
        Tasks.printInGreen("Block mining done for given nodes");
        Tasks.Wait();
        //Tasks.printInGreen("Do you want list of transactions to be printed?");
        //Scanner my_scan = new Scanner(System.in);
        //System.out.println(my_scan);
        //-------
        //----------chain of transactions--------------------
        //----------------------------------------------
        String blockchainJson = Tasks.getJson(blockchain);
        //System.out.println("\nThe block chain: ");
       // System.out.println(blockchainJson);

        Tasks.printInRed("Verifying if the chain is valid...");
        Tasks.Wait();
        System.out.println("\nBlockchain is Valid: " + ChainValidation.isChainValid());


    }
    //------
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void difficultyness(){
        int difficulty = Sharables.Difficulty;
        if (Sharables.EnablePOS){
            Sharables.Difficulty = difficulty /2 ;
        }
        //System.out.println(Sharables.Difficulty);
    }






}
