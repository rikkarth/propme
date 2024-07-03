package dev.streambit.controllers;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConstantGenerator {

    private final Path configPath;

    public ConstantGenerator(final Path configPath) {
        this.configPath = configPath;
    }

    public void init() {
        final Configuration config = getConfiguration();

        final StringBuilder sourceCode = getSourceCode(config);

        writeSourceCodeToFile(sourceCode);
    }

    private StringBuilder getSourceCode(final Configuration config) {
        final StringBuilder sourceCode = new StringBuilder();
        
        sourceCode.append("public class MyConfigConstants {\n");

        config.getKeys().forEachRemaining(key -> sourceCode.append(getLine(key)));

        sourceCode.append("}");
        return sourceCode;
    }

    private void writeSourceCodeToFile(final StringBuilder sb) {
        //implement target paths
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/test/resources/output/MyConfigConstants.java"),
                StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

            bw.write(sb.toString());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private String getLine(final String key) {
        final String variable = formatVariable(key);

        return String.format("    static final String %s = \"%s\";%n", variable, key);
    }

    private String formatVariable(final String key) {
        //TODO implement formatting
        return key.toUpperCase();
    }

    private Configuration getConfiguration() {
        try {
            final Configurations configs = new Configurations();
            return configs.properties(this.configPath.toString());
        } catch (final ConfigurationException ce) {
            System.err.println(String.format("Unable to retrieve configuration at: %s", configPath));
            System.err.println("Exited with status code 1");
            System.exit(1);
            return null;
        }
    }

}
