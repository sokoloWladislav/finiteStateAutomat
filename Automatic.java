package lab1Package;

public class Automatic {
	enum States{State_Start, State_1, State_2, State_3, State_4, State_5, State_6, State_7, State_8, State_broken}
	boolean status;
	String number;
	States state;
	
	public Automatic(){
		state=States.State_1;
		status=false;
	}
	
	public  boolean isCorrect(){
		return status;
	}
	
	public String returnNumber() throws MyException{
		if(status)
			return number;
		else
			throw new MyException("ѕопытка чтени€ недес€тичного числа");
	}
	
	private static void moveState(char temp, States state) throws MyException{
		switch(state)
		{
		case State_Start:
			if(temp=='-')
				state=States.State_8;
			else if(temp=='0')
				state=States.State_1;
			else if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_7;
			else
				state=States.State_broken;
			break;
		case State_1:
			if(temp=='.')
				state=States.State_2;
			else
				state=States.State_broken;
			break;
		case State_2:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_3;
			else
				state=States.State_broken;
			break;
		case State_3:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			else
				state=States.State_broken;
			break;
		case State_4:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_3;
			else
				state=States.State_broken;
			break;
		case State_5:
			if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_4;
			else
				state=States.State_broken;
			break;
		case State_6:
			if(temp=='-')
				state=States.State_5;
			else
				state=States.State_broken;
			break;
		case State_7:
			if(temp=='0' || temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				state=States.State_2;
			else if(temp=='.')
				state=States.State_2;
			else
				state=States.State_broken;
			break;
		case State_8:
			if(temp=='1' || temp=='2' || temp=='3' || temp=='4' || temp=='5' || temp=='6' || temp=='7' || temp=='8' || temp=='9')
				;
			else
				state=States.State_broken;
			break;
		case State_broken:
			throw new MyException("автомат сломан");
		}
	}
	
	public void action(String str) throws MyException{
		int end=str.length();
		number=str;
		for(int i=0; i<end; ++i){
			char temp=str.charAt(i);
			moveState(temp, state);
		}
		if(state==States.State_3 || state==States.State_4)
			status=true;
	}
}
