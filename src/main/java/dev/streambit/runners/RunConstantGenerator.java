package dev.streambit.runners;

import java.nio.file.Path;
import java.nio.file.Paths;

import dev.streambit.controllers.ConstantGenerator;
import dev.streambit.utils.constants.Messages;

public class RunConstantGenerator {

    public static void main(final String[] args) {

        try {
            validateInput(args);

            final Path configPath = Paths.get(args[0]);
            final Path targetPath = Paths.get(args[1]);

            final ConstantGenerator constantGenerator = new ConstantGenerator(configPath, targetPath);

            constantGenerator.init();

        } catch (final IllegalArgumentException iae) {
            System.err.println("Exit Code 1");
        }
    }

    private static void validateInput(final String[] args) {
        if (args == null || args.length == 0) {
            System.out.println(Messages.SOURCE_TARGET_NOT_PROVIDED);
            System.out.println(Messages.MISSING_PATHS_ADDITIONAL_INFO);
            throw new IllegalArgumentException(Messages.SOURCE_TARGET_NOT_PROVIDED);
        }

        if (args.length == 1) {
            System.out.println(Messages.TARGET_NOT_PROVIDED);
            throw new IllegalArgumentException(Messages.TARGET_NOT_PROVIDED);
        }

        if (args[0] == null || args[0].isEmpty()){
            System.out.println(Messages.SOURCE_EMPTY);
            throw new IllegalArgumentException(Messages.SOURCE_EMPTY);
        }
    }
}
