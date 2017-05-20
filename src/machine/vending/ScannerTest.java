package machine.vending;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args){
		while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextInt());
		sc.close();
	}
	}
}
