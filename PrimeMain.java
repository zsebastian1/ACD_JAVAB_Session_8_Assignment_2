package AssignmentSession8;

import java.util.Scanner;

	class PrimeThread extends Thread{
		int num;
		boolean isPrime = false;
		public PrimeThread(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			if (num < 2) {
				System.out.println ("Prime Thread: not prime.");
				return;
			} else if (num == 2) {
				System.out.println ("Prime Thread: prime!");
				return;
			}
			int sqrt = (int)Math.sqrt(num);
			
			for (int i = 2; i <= sqrt; i++) {
				if (num % i == 0) {
					System.out.println("Prime Thread: not prime.");
					return;
				}
			}
			System.out.println("Prime Thread: prime!");
		}
	}

	class PrimeRunnable implements Runnable{
		
		int num;
		boolean isPrime = false;
		
		public PrimeRunnable(int num) {
			this.num = num;
		}
		@Override
		public void run() {

			if (num < 2) {
				System.out.println ("Runnable Thread: not prime.");
				return;
			} else if (num == 2) {
				System.out.println ("Runnable Thread: prime!");
				return;
			}
			int sqrt = (int)Math.sqrt(num);
			
			for (int i = 2; i <= sqrt; i++) {
				if (num % i == 0) {
					System.out.println("Runnable Thread: not prime.");
					return;
				}
			}
			System.out.println("Runnable Thread: prime!");
		}
		
	}

	public class PrimeMain {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			PrimeThread pt;
			Thread pr;
			int num;
			try {
				System.out.print("Enter a number to test: ");
				num = sc.nextInt();
				pt = new PrimeThread(num);
				pr = new Thread(new PrimeRunnable(num));
				pt.start();
				pr.start();
				
			} catch (Exception e) {
				System.out.println("Your input must be a number greater than 0. Try again.");
			} finally {
				sc.close();
			}
		}

}
