package dev.streambit.runners;

import org.junit.jupiter.api.Test;

class RunConstantGeneratorTest {

    @Test
    void testMain() {
        RunConstantGenerator.main(new String[] { "src/test/resources/config.properties" });
    }
}
