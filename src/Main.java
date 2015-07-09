import java.util.ArrayList;

import util.Random;
import common.Sentence;
import execl.ExelData;
import frame.Gui;


public class Main {
	
	
	public static void main(String[] args){
				
		//Exel access
		ExelData data= new ExelData();
		ArrayList<Sentence> totalList = data.loadData();
				
		//GUI 화면 띄우기 
		Gui gui =new Gui(totalList);
		
		//화면에 필요한 요소들을 세팅
		gui.start();
		
			
	
	}
}


