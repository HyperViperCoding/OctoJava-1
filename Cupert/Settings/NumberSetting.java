package Cupert.Settings;

public class NumberSetting extends setting {
	public double value, minimum, maximum, increment;

	public NumberSetting(String name, double value, double minimum, double maximum, double increment) {
		this.value = value;
		this.name = name;
		this.minimum = minimum;
		this.maximum = maximum;
		this.increment = increment;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		double presicion = 1/ increment;
		this.value = Math.round(Math.max(minimum ,Math.min(maximum, value))* presicion) / presicion;
	}
	public void increment(boolean positive) {
		setValue(getValue() + (positive ? 1 : - 1) * increment);
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}
}
