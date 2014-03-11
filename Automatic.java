package lab1Package;

import java.util.*;

public class Automatic {
	enum States{State_Start, State_1, State_2, State_3, State_4, State_5, State_6, State_7, State_8}
	
	private static void action(char temp, States state){
		switch(state)
		{
		case State_Start:
			if(temp=='e')
				state=States.State_6;
			else if(temp=='-')
				state=States.State_5;
			else if(temp=='0')
				state=States.State_1;
			else if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_6;
		case State_1:
			if(temp=='.')
				state=States.State_2;
			break;
		case State_2:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_3;
			break;
		case State_3:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			break;
		case State_4:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			else if(temp=='.')
				state=States.State_2;
			break;
		case State_5:
			if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			break;
		case State_6:
			if(temp=='-')
				state=States.State_7;
			break;
		case State_7:
			if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_8;
			break;
		case State_8:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			break;
		}
	}
		
	private static boolean control(States state){
		if(state==States.State_3 || state==States.State_7 || state==States.State_8)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("¬ведите число дл€ анализа");
		String str=scan.nextLine();
		States state=States.State_Start;
		int end=str.length();
		char temp;
		for(int i=0; i<end; ++i){
			temp=str.charAt(i);
			action(temp, state);
		}
		boolean a=true;
		a=control(state);
		System.out.println(a);
	}

}
