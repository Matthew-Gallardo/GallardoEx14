package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.acumen.training.codes.CheckStr;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestCheckStr {

    private CheckStr checkStr;

    @BeforeEach
    public void setUp() {
    	checkStr = new CheckStr();
    }

    @Test
    public void testBinariseLogging() {
        // Run the method to generate logs
    	checkStr.binarise(5);
        
        // Check if the log file contains the expected log message
        File logFile = new File("/logs/checkstr.log");
        assertTrue(logFile.exists(), "Log file should exist.");

        // Read the last few lines of the log file to assert the correct log message
        try {
            List<String> logLines = Files.readAllLines(Paths.get(logFile.getPath()));
            String lastLogMessage = logLines.get(logLines.size() - 1);
            assertTrue(lastLogMessage.contains("binarise() method executed"));
        } catch (Exception e) {
            fail("Failed to read log file: " + e.getMessage());
        }
    }

    @Test
    public void testTotalLogging() {
    
    	checkStr.total("test");

        
        File logFile = new File("/logs/checkstr.log");
        assertTrue(logFile.exists(), "Log file should exist.");

       
        try {
            List<String> logLines = Files.readAllLines(Paths.get(logFile.getPath()));
            String lastLogMessage = logLines.get(logLines.size() - 1);
            assertTrue(lastLogMessage.contains("total() method executed"));
        } catch (Exception e) {
            fail("Failed to read log file: " + e.getMessage());
        }
    }

    @Test
    public void testConvertLogging() {
       
    	checkStr.convert("test");

       
        File logFile = new File("src/test/resources/logs/checkstr.log");
        assertTrue(logFile.exists(), "Log file should exist.");

        
        try {
            List<String> logLines = Files.readAllLines(Paths.get(logFile.getPath()));
            String lastLogMessage = logLines.get(logLines.size() - 1);
            assertTrue(lastLogMessage.contains("convert() method executed"));
        } catch (Exception e) {
            fail("Failed to read log file: " + e.getMessage());
        }
    }
}
