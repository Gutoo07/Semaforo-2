package controller;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

public class Metodos2 extends Thread {
	private int prato;
	private Semaphore semaforo;
	private double progresso;
	private double porcentagem;
	
		public Metodos2(int prato , Semaphore semaforo) {
			this.prato = prato;
			this.semaforo = semaforo;
		}
		public void run() {
			if (prato % 2 == 0) {
				System.out.println("Lasanha a Bolonhesa #" + prato + " comecou a cozinhar:");
				int tempo = (int) ((Math.random()*601) + 600);
				cozinhando(prato , tempo);
			} else {
				System.out.println("Sopa de Cebola #" + prato + " comecou a cozinhar:");
				double tempo = (int) ((Math.random()*301) + 500);
				cozinhando(prato , tempo);
			}
		}
		private void cozinhando(int prato, double tempo) {
			while (progresso < tempo) {
				progresso += 100;
				if (progresso > tempo) {
					double resto = progresso - tempo;
					progresso = progresso - resto;
				} 
				porcentagem = (progresso/tempo)*100;
				System.out.println("Prato " + prato + ": " + (Math.round(porcentagem)) + "%");
				try {
					sleep(300); //0.1s ainda estava muito rapido pra enxergar, na minha opiniao
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				try {
					semaforo.acquire();
					entregando(prato);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
		
		private void entregando(int prato) {
			System.err.println("Prato " + prato + " esta sendo entregue.");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
}

