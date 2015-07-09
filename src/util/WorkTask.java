package util;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class WorkTask extends TimerTask{

	public Timer timer =new Timer();
	
	private int num;
	private int pauseNum;
	JLabel jl_timer;
	
	public WorkTask(JLabel jl_timer) {
		this.jl_timer = jl_timer;
	}

	@Override
	public void run() {
			
		num++;
		jl_timer.setText(pauseNum+num+"");			
	}
	
}
	

	

