package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckStr {

    private static final Logger logger = LogManager.getLogger(CheckStr.class);

    public CheckStr() {
        logger.info("Instantiating ChekcStr class");
    }

    public String convert(String str) {
        logger.info("Executing convert() with input: {}", str);
        long startTime = System.currentTimeMillis();

        try {
            int totalValue = total(str);
            String binaryValue = binarise(totalValue);
            logger.info("convert() returning value: {}", binaryValue);
            return binaryValue;
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("Finished executing convert() in {} ms", endTime - startTime);
        }
    }

    public int total(String str) {
        logger.info("Executing total() with input: {}", str);
        long startTime = System.currentTimeMillis();

        try {
            if (str == null || str.isEmpty()) {
                logger.warn("Invalid input: empty or null string");
                return 0;
            }
            int totalSum = (int) (str.charAt(0)) + (str.length() == 1 ? 0 : total(str.substring(1)));
            logger.info("total() returning value: {}", totalSum);
            return totalSum;
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("Finished executing total() in {} ms", endTime - startTime);
        }
    }

    public String binarise(int givenstrvalue) {
        logger.info("Executing binarise() with input: {}", givenstrvalue);
        long startTime = System.currentTimeMillis();

        try {
            if (givenstrvalue == 0) {
                return "0";
            }
            String result = givenstrvalue % 2 == 1
                    ? "1" + binarise(givenstrvalue / 2)
                    : "0" + binarise(givenstrvalue / 2);
            logger.info("binarise() returning value: {}", result);
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("Finished executing binarise() in {} ms", endTime - startTime);
        }
    }
}
