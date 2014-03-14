package lab1Package;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args){
		try{
		Scanner scan=new Scanner(System.in);
		System.out.println("¬ведите число дл€ анализа");
		String str=scan.nextLine();
		Automatic obj=new Automatic();
		obj.action(str);
		System.out.println(obj.isCorrect());
		System.out.println(obj.returnNumber());
		}
		catch(MyException e){
			System.out.println(e);
		}
	}
}
