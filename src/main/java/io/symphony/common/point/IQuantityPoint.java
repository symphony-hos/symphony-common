package io.symphony.common.point;

import javax.measure.Unit;

public interface IQuantityPoint extends IPoint<Double> {

	Unit<?> getUnit();
	
	void setUnit(Unit<?> unit);
	
}
