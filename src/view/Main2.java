package view;
import java.util.concurrent.Semaphore;

import controller.Metodos2;

public class Main2 {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < 5; i++) {
			int prato = (int)(( Math.random() * 100) + 1);
			Thread entrega = new Metodos2(prato , semaforo);
			entrega.start();
		}
	}

}
