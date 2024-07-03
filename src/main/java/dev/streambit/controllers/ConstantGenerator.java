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

        StringBuilder sb = new StringBuilder();
        sb.append("public class MyConfigConstants {\n");
        
        config.getKeys().forEachRemaining(
                key -> sb.append(String.format("    static final String %s = \"%s\";%n", key.toUpperCase(), key)));
        sb.append("}");

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/test/resources/output/MyConfigConstants.java"),
                StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
