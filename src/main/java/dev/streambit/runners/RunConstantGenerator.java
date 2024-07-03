package dev.streambit.runners;

import java.nio.file.Path;
import java.nio.file.Paths;

import dev.streambit.controllers.ConstantGenerator;

public class RunConstantGenerator {

    public static void main(String[] args) {

        final Path configPath = Paths.get(args[0]);

        final ConstantGenerator constantGenerator = new ConstantGenerator(configPath);

        constantGenerator.init();
    }

}
