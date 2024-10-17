package org.acumen.training.codes.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.acumen.training.codes.Coin;
import org.acumen.training.codes.VendingMachine;

public class TestVendingMachine {
	private static final Logger LOGGER = LogManager.getLogger(TestVendingMachine.class);

	@Test
	public void testInsertCoins() {
		LOGGER.info("Start testInsertCoins");
		VendingMachine vm = new VendingMachine();

		Coin penny = new Coin("PENNY");
		Coin nickel = new Coin("NICKEL");
		Coin invalidCoin = new Coin("INVALID");

		LOGGER.info("Inserting Penny");
		vm.insert(penny);
		LOGGER.info("Inserting Nickel");
		vm.insert(nickel);
		LOGGER.info("Inserting Invalid Coin");
		vm.insert(invalidCoin);

		LOGGER.info("End testInsertCoins");
	}

	@Test
	public void testVend() throws Exception {
		LOGGER.info("Start testVend");
		VendingMachine vm = new VendingMachine();
		Coin quarter = new Coin("QUARTER");

		vm.insert(quarter);
		vm.insert(quarter);
		vm.insert(quarter); 

		vm.vend(); 
		LOGGER.info("End testVend");
	}

	@Test
	public void testNegativeCredit() {
		LOGGER.info("Start testNegativeCredit");
		VendingMachine vm = new VendingMachine();
		Coin silverDollar = new Coin("SILVERDOLLAR");

		vm.insert(silverDollar); 

		Exception exception = assertThrows(Exception.class, vm::vend);
		LOGGER.error("Exception thrown: " + exception.getMessage());

		LOGGER.info("End testNegativeCredit");
	}

	@Test
	public void testReturnCoins() {
		LOGGER.info("Start testReturnCoins");
		VendingMachine vm = new VendingMachine();
		Coin dime = new Coin("DIME");

		vm.insert(dime);
		vm.returnCoins();
		vm.returnCoins();

		LOGGER.info("End testReturnCoins");
	}
}
