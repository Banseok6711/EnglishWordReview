package util;

import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

import common.Sentence;

public class WorkTask2 extends TimerTask{
	
	JLabel jl3_korean;
	JLabel jl3_english;
	ArrayList<Sentence> totalList;
	int index =0;
	JLabel currentIndex;
	JButton jb3_play;
	
	public WorkTask2(JLabel jl3_korean, JLabel jl3_english , ArrayList<Sentence> totalList , JLabel currentIndex , JButton jb3_play) {
		this.jl3_korean = jl3_korean;
		this.jl3_english = jl3_english;
		this.totalList = totalList;
		this.currentIndex =currentIndex; 
		this.jb3_play = jb3_play;
	}



	@Override
	public void run() {
		if(index==totalList.size()-1){
			cancel();
			jb3_play.setEnabled(true);
		}
		jl3_english.setText(totalList.get(index).getEnglish());
		jl3_korean.setText(totalList.get(index).getKorean());
		currentIndex.setText(index+1+"");
		index++;
		
		
		
	}

}
