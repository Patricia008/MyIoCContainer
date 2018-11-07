package motoUsecase;

import java.util.List;
import java.util.stream.Collectors;

public class A2MotorcyclesImpl implements A2Motorcycles {

	@Override
	public List<Motorcycle> suitableForA2(List<Motorcycle> motos) {
		return motos
				.stream()
				.filter(m -> m.getMaxPower() < 35)
				.collect(Collectors.toList());
	}

}
