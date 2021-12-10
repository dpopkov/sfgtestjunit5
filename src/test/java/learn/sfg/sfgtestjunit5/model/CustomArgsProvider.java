package learn.sfg.sfgtestjunit5.model;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("FL", 1011, 11),
                Arguments.of("OH", 2022, 22),
                Arguments.of("MI", 3033, 33)
        );
    }
}
