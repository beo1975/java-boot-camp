package com.java.bootcamp.projects.simpleproject.tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ShapeInputArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(Arguments.of("km", Double.MAX_VALUE), Arguments.of("nm", Double.MIN_VALUE),
				Arguments.of("dm", 0), Arguments.of("", 0.3834), Arguments.of(" ", 0.11e8), Arguments.of(" m ", 12),
				Arguments.of("mm", 5.));
	}
}
