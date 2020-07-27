package com.java.bootcamp.projects.simpleproject.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.java.bootcamp.projects.simpleproject.Circle;
import com.java.bootcamp.projects.simpleproject.Pentagon;
import com.java.bootcamp.projects.simpleproject.Shape;
import com.java.bootcamp.projects.simpleproject.Square;
import com.java.bootcamp.projects.simpleproject.Type;

class ShapesTest {

	@ParameterizedTest
	@ValueSource(doubles = { 0.0333, 1, 3e7, 5., 15, Double.MAX_VALUE })
	void testCircle(double circleDiameter) {
		// Initialize unit
		String unit = "mm";

		// Test Circle implementation of Shape
		Shape circleShape = new Circle(circleDiameter, unit);
		assertEquals(Type.CIRCLE, circleShape.getType());
		assertEquals(unit, circleShape.getUnit());
		assertEquals((Math.PI * ((circleDiameter / 2) * (circleDiameter / 2))), circleShape.getArea());
		assertEquals((2 * Math.PI * (circleDiameter / 2)), circleShape.getCircumference());

		Circle circle = (Circle) circleShape;
		assertEquals(circle.getDiameter(), circleDiameter);
		assertEquals(circle.getRadius(), circleDiameter / 2);
	}

	@ParameterizedTest
	@CsvSource(value = { "mm:12", "cm:9e12", "m:0.297" }, delimiter = ':')
	void testSquare(String unit, double sideLength) {
		// Test Square implementation of Shape
		Shape squareShape = new Square(sideLength, unit);
		assertEquals(Type.SQUARE, squareShape.getType());
		assertEquals(unit, squareShape.getUnit());
		assertEquals(sideLength * sideLength, squareShape.getArea());
		assertEquals(4 * sideLength, squareShape.getCircumference());

		Square square = (Square) squareShape;
		assertEquals(square.getSideLength(), sideLength);
	}

	@ParameterizedTest
    @ArgumentsSource(ShapeInputArgumentsProvider.class)
	void testPentagon(String unit, double sideLength) {
		// Test Pentagon implementation of Shape
		Shape squareShape = new Pentagon(sideLength, unit);
		assertEquals(Type.PENTAGON, squareShape.getType());
		assertEquals(unit, squareShape.getUnit());
		assertEquals((5 * sideLength * sideLength) / (4 * Math.tan(Math.toRadians(36))), squareShape.getArea());
		assertEquals(5 * sideLength, squareShape.getCircumference());

		Pentagon square = (Pentagon) squareShape;
		assertEquals(square.getSideLength(), sideLength);
	}
}
