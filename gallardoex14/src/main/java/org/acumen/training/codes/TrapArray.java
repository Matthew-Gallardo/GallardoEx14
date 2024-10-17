package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TrapArray {
    private static final Logger logger = LogManager.getLogger(TrapArray.class);

    public void arrayTransact() {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] array = null;

            // Log when the loop starts
            logger.info("TrapArray starts. ({})", java.time.LocalDate.now());

            // Getting array size
            while (array == null) {
                try {
                    System.out.println("Enter the Array Size: ");
                    String sizeInput = scanner.next();
                    if (!isValidInteger(sizeInput)) {
                        logger.error("Invalid array size: [Non-integer input] ({})", java.time.LocalDate.now());
                        throw new LetterSizeException("Invalid size");
                    }
                    int size = Integer.parseInt(sizeInput);
                    if (size < 0) {
                        logger.error("Invalid array size: [Negative size: {}] ({})", size, java.time.LocalDate.now());
                        throw new InvalidSizeException("Array size cannot be negative");
                    }
                    array = new int[size];
                    logger.info("Array of {} integers created. ({})", size, java.time.LocalDate.now());
                } catch (LetterSizeException | InvalidSizeException e) {
                    logger.error(e.getMessage() + " ({})", java.time.LocalDate.now());
                }
            }

            // Filling the array
            for (int i = 0; i < array.length; i++) {
                while (true) {
                    try {
                    	System.out.println("Enter the value: ");
                        String elementInput = scanner.next();
                        if (isValidCharacter(elementInput)) {
                            logger.error("Invalid element value: [Character input] ({})", java.time.LocalDate.now());
                            throw new ElementCharException("Invalid element value: [character]");
                        }
                        if (isValidDecimal(elementInput)) {
                            logger.error("Invalid element value: [Floating-point input] ({})", java.time.LocalDate.now());
                            throw new ElementDecimalException("Invalid element value: [floating-point]");
                        }
                        array[i] = Integer.parseInt(elementInput);
                        break;
                    } catch (ElementCharException | ElementDecimalException e) {
                        logger.error(e.getMessage() + " ({})", java.time.LocalDate.now());
                    } catch (NumberFormatException e) {
                        logger.error("Invalid element value: [String input] ({})", java.time.LocalDate.now());
                    }
                }
            }

            // Selection of index
            while (true) {
                try {
                	System.out.println("Enter the Index that you want to view: ");
                    String indexInput = scanner.next();
                    if (indexInput.equalsIgnoreCase("E")) {
                        break;
                    }
                    if (!isValidInteger(indexInput)) {
                        logger.error("Invalid index input: [Non-integer: {}] ({})", indexInput, java.time.LocalDate.now());
                        throw new BadIndexException("Invalid index: " + indexInput);
                    }
                    int index = Integer.parseInt(indexInput);
                    if (index < 0 || index >= array.length) {
                        logger.error("Bad Index: [Out of bounds: {}] ({})", index, java.time.LocalDate.now());
                        throw new BadIndexException("Bad Index");
                    }
                    logger.info("The Value in index {} is {} ({})", index, array[index], java.time.LocalDate.now());
                } catch (BadIndexException e) {
                    logger.error(e.getMessage() + " ({})", java.time.LocalDate.now());
                }
            }
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException occurred: " + e.getMessage() + " ({})", java.time.LocalDate.now());
        }
        logger.warn("Goodbye ({})", java.time.LocalDate.now());
    }

    // Helper Methods
    private boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidCharacter(String input) {
        return input.matches("[a-zA-Z]");
    }

    private boolean isValidDecimal(String input) {
        return input.matches("[0-9]+\\.[0-9]+");
    }
}
