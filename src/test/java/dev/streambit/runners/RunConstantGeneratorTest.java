package dev.streambit.runners;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RunConstantGeneratorTest {

    private static final String SOURCE_CONFIG = "src/test/resources/config.properties";
    private static final String TARGET_OUTPUT_PATH = "src/test/resources/output";
    private static final String TARGET_OUTPUT_FILE_PATH = TARGET_OUTPUT_PATH + "/MyConfigConstants.java";
    private static final File TARGET_OUTPUT_FILE = new File(TARGET_OUTPUT_FILE_PATH);

    @AfterEach
    void cleanUp() {
        new File(TARGET_OUTPUT_FILE_PATH).delete();
    }

    @Test
    void testMain() {
        RunConstantGenerator.main(new String[] { SOURCE_CONFIG, TARGET_OUTPUT_PATH });

        assertTrue(TARGET_OUTPUT_FILE.exists());
    }

    @Test
    void givenNoArgs_testMain() {
        RunConstantGenerator.main(null);

        assertFalse(TARGET_OUTPUT_FILE.exists());
    }

    @Test
    void givenOneArg_testMain() {
        RunConstantGenerator.main(new String[] { SOURCE_CONFIG });

        assertFalse(TARGET_OUTPUT_FILE.exists());
    }

    @Test
    void givenEmptySource_testMain() {
        RunConstantGenerator.main(new String[] { "", "src/test/resources/config.properties" });

        assertFalse(TARGET_OUTPUT_FILE.exists());
    }
}
