package motoUsecase;

import java.util.List;

import iocContainer.api.IocContainer;
import iocContainer.impl.HomemadeContextFromFile;

public class Main {

	public static void main(String[] args) {
	
		HomemadeContextFromFile ctx = new HomemadeContextFromFile("src/motoUsecase/appContext.xml");
		
		IocContainer iocContainer = ctx.getIocContainer();
		System.out.println("Context properties:\n" + iocContainer.getRegisteredProperties());
		MotoClassifier motoClassifier;
		try {
			motoClassifier = (MotoClassifier) iocContainer.resolve(MotoClassifier.class);
			List<Motorcycle> a2motorcycles = motoClassifier.getA2Motos();
			System.out.println(a2motorcycles.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
