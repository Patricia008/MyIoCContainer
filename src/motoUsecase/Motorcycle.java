package motoUsecase;

public class Motorcycle {
	
	private final int engineCapacity;
	private final int maxPower;
	private final String engine;
	
	public Motorcycle(int engineCapacity, int maxPower, String engine) {
		this.engineCapacity = engineCapacity;
		this.maxPower = maxPower;
		this.engine = engine;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public String getEngine() {
		return engine;
	}
	
	@Override
	public String toString() {
		return "\nMoto: engineCapacity " + this.getEngineCapacity() + ", maxPower: " + this.getMaxPower() + ", engine: " + this.getEngine();
	}
	
}
