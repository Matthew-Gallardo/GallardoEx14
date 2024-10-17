package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendingMachine {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachine.class);
    
   
    @SuppressWarnings("unused")
	private int totValue;
    private int currValue;
    private boolean enabled;
    private static final int COST = 75;

    public VendingMachine() {
        LOGGER.info("Start VendingMachine constructor");
        totValue = 0;
        currValue = 0;
        enabled = false;
        LOGGER.info("End VendingMachine constructor");
    }

    public void insert(Coin coin) {
    	LOGGER.info("Start insert method with coin: " + coin);
        int value = coin.getValue();
        if (value == 0) {
        	LOGGER.error("Illegal value: coin is invalid");
        } else {
            currValue += value;
            LOGGER.info("Current value = " + currValue);
            if (currValue >= COST) {
                enabled = true;
                LOGGER.info("Sufficient credit");
            }
        }
        LOGGER.info("End insert method");
    }

    public void returnCoins() {
    	LOGGER.info("Start returnCoins method");
        if (currValue == 0) {
        	LOGGER.error("No coins to return");
        } else {
        	LOGGER.info("Take your coins");
            currValue = 0;
            enabled = false;
        }
        LOGGER.info("End returnCoins method");
    }

    public void vend() throws Exception {
    	LOGGER.info("Start vend method");
        if (enabled) {
        	LOGGER.info("Get your drink");
            totValue += COST;
            currValue -= COST;
            if (currValue == 0)
                enabled = false;
            LOGGER.info("Current value = " + currValue);
        } else {
        	LOGGER.warn("Not enough credit: add " + (COST - currValue));
        }
        if (currValue < 0) {
        	LOGGER.error("Error: negative credit!");
            throw new Exception("Error: negative credit!");
        }
        LOGGER.info("End vend method");
    }
}
