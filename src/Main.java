import java.util.ArrayList;

import util.Random;
import common.Sentence;
import execl.ExelData;
import frame.Gui;


public class Main {
	public static ArrayList<Sentence> totalList ;
	
	public static void main(String[] args){
				
		//Exel access
		ExelData data= new ExelData();
		totalList = data.loadData();
		
		
		Gui gui =  new Gui(totalList);
//		gui.setList();
		gui.settingChoice(totalList);		
		
		//list�� ������ �������� ���� 
		Random ran = new Random();
		ran.makeRandomList(totalList);
			
	
	}
}


