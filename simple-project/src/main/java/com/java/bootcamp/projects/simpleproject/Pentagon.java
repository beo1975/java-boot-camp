package com.java.bootcamp.projects.simpleproject;

public class Pentagon extends Shape {

	private final double sideLength;

	public Pentagon(double sideLength, String unit) {
		super(unit);
		this.sideLength = sideLength;
	}

	@Override
	public double getArea() {
		// compute and return area
		return (5 * sideLength * sideLength) / (4 * Math.tan(Math.toRadians(36)));
	}

	@Override
	public double getCircumference() {
		return 5 * sideLength;
	}

	/**
	 * @return the sideLength
	 */
	public double getSideLength() {
		return sideLength;
	}

	@Override
	public Type getType() {
		return Type.PENTAGON;
	}
}
