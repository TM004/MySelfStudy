/**
 * 
 */
package machine.vending;

import java.util.Scanner;

/**
 * @author TM004
 * 自動販売機のお金の計算処理
 */
public class MachineMain {
	// check配列は1番目1000円，2番目500円,3番目100円,4番目50円,5番目10円の各ストック数を仮確保する。
	static int[] check = new int[5];
	static int number = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputMoney = 0;
		Money ten = new Money(10,5);
		Money fifty = new Money(50,5);
		Money hundred = new Money(100,5);
		Money fiveHundred = new Money(500,5);
		Money thousand = new Money(1000,5);
		Scanner sc;
		
		System.out.println("自動販売機のお金処理です。終了したい時は\"-1\"と入力してください。");
		while(true){
			// 配列初期化
			numberInitializ();
			
			// 入力文字が数字かどうかを判定
			try{
				// System.out.println("でばっぐー１");
				sc = new Scanner(System.in);
				inputMoney = sc.nextInt();

				// 入力文字が-1以下の時だった場合繰り返し
				if(inputMoney <= -2) {
					System.out.println("0以上の数字を入力するか、-1を入力して終了してください。");
					continue;
				}
				if(inputMoney > 10000){
					System.out.println("１００００円以上は入れないでください");
					continue;
				}
			} catch(Exception e) {
				System.out.println("数字を入力してください");
				continue;
			}
			if(inputMoney == -1) break;
			// check関数完成処理
			inputMoney = checkCom( inputMoney, thousand.getParametar());
			// debug(inputMoney);
			inputMoney = checkCom( inputMoney, fiveHundred.getParametar());
			// debug(inputMoney);
			inputMoney = checkCom( inputMoney, hundred.getParametar());
			// debug(inputMoney);
			inputMoney = checkCom( inputMoney, fifty.getParametar());
			// debug(inputMoney);
			inputMoney = checkCom( inputMoney, ten.getParametar());
			// System.out.println("inputMoney処理後 : " + inputMoney );
			
			// 割り切れない数字がでたときの処理（現在は1円を入れた時とかの処理を入れていないため）
			if(inputMoney != 0) {
				System.out.println("10円50円100円500円1000円を組み合わせた数字を入力してください");
				continue;
			}
			// 配列初期化
			numberInitializ();
			
			// ストック数確認
			if( checkStock(thousand.getStock()) & checkStock(fiveHundred.getStock()) & checkStock(hundred.getStock()) & 
					checkStock(fifty.getStock()) & checkStock(ten.getStock()) ) {
				thousand.minusStock( check[0] );
				fiveHundred.minusStock( check[1] );
				hundred.minusStock( check[2] );
				fifty.minusStock( check[3] );
				ten.minusStock( check[4] );
			} else {
				System.out.println("お金のストック数が足りません！");
			}
			
			//本当に処理ができているかどうかのデバッグ
			stockDebug(thousand.getParametar(),thousand.getStock());
			stockDebug(fiveHundred.getParametar(),fiveHundred.getStock());
			stockDebug(hundred.getParametar(),hundred.getStock());
			stockDebug(fifty.getParametar(),fifty.getStock());
			stockDebug(ten.getParametar(),ten.getStock());
		}
			sc.close();
			System.out.println("終了");
	}
	
	// 1000円,500円、100円、50円、10円の処理方法を共通化
	// check配列を完成させる
	private static int checkCom( int inputMoney, int money ){
		// check[0] = inputMoney / thousand.getParametar();
		check[number] = inputMoney / money;
		inputMoney = inputMoney % money; 
		number++;
		return inputMoney;
	}

	// ストック数があるかどうかを確認する
	private static boolean checkStock( int stock ){
		if(stock >= check[number]) {
			number++; return true;
		}
		else return false;
	}
	
	// 配列初期化
	private static void numberInitializ(){
		number = 0;
	}
	
	// お金計算時のデバッグ
	// private static void debug( int money ){
	//	System.out.println( number + "つ目の処理後 : " + money );
	// }
	
	// ストックがあるかどうかのデバッグ
	private static void stockDebug(int parametar, int stock ){
		System.out.println( parametar + "円のストックは" + stock + "個です");
	}
}
