package com.java.bootcamp.projects.simpleproject;

import java.util.Objects;

public abstract class Shape {

	private final String unit;

	public Shape(String unit) {
		Objects.requireNonNull(unit);
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public Type getType() {
		return Type.SHAPE;
	}

	public abstract double getArea();

	public abstract double getCircumference();

}
