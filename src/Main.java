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
				
		//GUI ȭ�� ���� 
		Gui gui =new Gui(totalList);
		
		//ȭ�鿡 �ʿ��� ��ҵ��� ����
		gui.start();
		
			
	
	}
}


