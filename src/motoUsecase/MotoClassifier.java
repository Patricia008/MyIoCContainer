package motoUsecase;

import java.util.ArrayList;
import java.util.List;

public class MotoClassifier {

	private A2Motorcycles a2Motorcycles;
	private final List<Motorcycle> motorcycles = new ArrayList<>();
	
	public MotoClassifier(Object a2Motorcycles) {

		this.a2Motorcycles = (A2Motorcycles) a2Motorcycles;
		
		motorcycles.add(new Motorcycle(600, 70, "Four stroke"));
		motorcycles.add(new Motorcycle(150, 20, "Two stroke"));
		motorcycles.add(new Motorcycle(399, 30, "Four stroke"));
	}
	
	public List<Motorcycle> getA2Motos() {
		return a2Motorcycles.suitableForA2(this.motorcycles);
	}
	
}
