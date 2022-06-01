package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logLevelTest (){
        logger.trace("Trace Massage: начало теста ...");
        logger.debug("Debug Massage: ...");
        logger.info("Info Massage: ...");
        logger.warn("Warning Massage:  ...");
        logger.error("Error Massage:  ...");
        logger.fatal("Fatal Massage: конец теста ...");
    }

    }

