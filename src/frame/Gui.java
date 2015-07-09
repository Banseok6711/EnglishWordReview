package frame;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import util.Random;
import util.WorkTask;
import util.WorkTask2;
import common.Sentence;
import execl.ExelData;

public class Gui extends JFrame {
	ExelData exel = new ExelData();
	private ArrayList<Sentence> list;
	private ArrayList<Sentence> total_List;
	private String answer_word;
	WorkTask work;

	private static int wordNum = 1;
	int hitNum;
	int falseNum;
	int remainNum;

	JPanel jp_up;
	JPanel jp_center;
	JPanel jp_content_first;
	JPanel jp_content_second;
	JPanel jp_content_third;
	JPanel jp_down;

	JLabel jl_first;
	JLabel jl_second;
	JLabel jl_third;

	// jp_content_first
	JLabel jl_korean;
	JLabel jl_english;
	JTextField jt_korean;
	JTextField jt_english;
	JPanel jp_first_bottom;
	JLabel jl_plus;
	JLabel jl_store;

	// jp_content_second
	JPanel jp_content_second_center;
	JLabel jl_prev_word;
	JLabel jl_cur_word;
	JPanel jp_imsi;
	JLabel crow_down_arrow;
	JPanel jp_second_check;
	JLabel jl_ok_false;
	JLabel jl_next_arrow;
	JLabel jl_check_answer;
	JPanel jp_imsi2;
	JLabel jl_english2;
	JTextField jt_english2;
	JButton jb_play;
	JButton jb_stop;
	JButton jb_reset;
	JLabel jl_pause;
	JLabel jl_timer;
	JLabel jl_time_image;
	JPanel jp_content_second_right;
	JPanel jp_second_right_1;
	JPanel jp_second_right_2;
	JPanel jp_second_right_3;
	JPanel jp_second_right_4;
	JLabel jl_StringhitNum;
	JPanel jp_imsi3;
	JLabel jl_hitNum;
	JLabel jl_StringfalseNum;
	JLabel jl_falseNum;
	JLabel jl_StringRemainWordNum;
	JLabel jl_remainWordNum; // 남은 단어 갯수
	JPanel jp_imsi4;
	Choice choice;

	// jp_content_third
	JPanel jp_content_third_center;
	JPanel jp_third_1;
	// JLabel jl3_play;
	JButton jb3_play;
	JRadioButton jr3_speed1;
	JRadioButton jr3_speed2;
	JRadioButton jr3_speed3;
	JPanel jp_third_2;
	JLabel jl3_korean;
	JLabel jl3_english;
	JPanel jp_third_3;
	JLabel jl3_currentIndex;
	JLabel jl3_total;

	JPanel jp_content_third_right;

	public Gui(ArrayList<Sentence> totalList) {

		jp_up = new JPanel();
		jp_center = new JPanel();
		jp_content_first = new JPanel();
		jp_content_second = new JPanel();
		jp_content_third = new JPanel();
		jp_down = new JPanel();

		// Image 생성
		jl_first = new JLabel(new ImageIcon("images/lable_first2.PNG"));
		jl_second = new JLabel(new ImageIcon("images/lable_second2.PNG"));
		jl_third = new JLabel(new ImageIcon("images/lable_third2.PNG"));
		Font font0 = new Font("SansSerif", Font.BOLD, 20);
		Font font = new Font("SansSerif", Font.BOLD, 30);
		Font font1 = new Font("SansSerif", Font.BOLD, 40);
		Font font2 = new Font("SansSerif", Font.BOLD, 60);
		// jl_first = new JLabel("문장추가");
		// jl_second = new JLabel("복습하기");
		// jl_third = new JLabel("전체 훑어보기");

		jl_first.setFont(font);
		jl_second.setFont(font);
		jl_third.setFont(font);

		jl_korean = new JLabel(new ImageIcon("images/play_1_korean.PNG"));
		jl_english = new JLabel(new ImageIcon("images/play_1_english.PNG"));
		jl_plus = new JLabel(new ImageIcon("images/play_1_plus.png"));
		jl_store = new JLabel(new ImageIcon("images/play_1_store.png"));

		jp_up.setBackground(Color.orange);

		jp_up.add(jl_first);
		jp_up.add(jl_second);
		jp_up.add(jl_third);

		jp_up.setLayout(new GridLayout(1, 3, 30, 30));

		// jp_content_first 화면

		jt_korean = new JTextField(25);
		jt_english = new JTextField(25);
		jp_first_bottom = new JPanel();

		jp_first_bottom.setLayout(new GridLayout(1, 2));
		jp_first_bottom.add(jl_plus);
		jp_first_bottom.add(jl_store);

		jp_content_first.add(jl_korean);
		jp_content_first.add(jt_korean);
		jp_content_first.add(jl_english);
		jp_content_first.add(jt_english);
		jp_content_first.add(jp_first_bottom);

		jt_korean.setFont(font1);
		jt_english.setFont(font1);
		jt_english.setForeground(Color.MAGENTA);

		// jp_content_second_center 화면
		jp_content_second_center = new JPanel();
		jp_content_second_right = new JPanel();
		jp_second_right_1 = new JPanel();
		jp_second_right_2 = new JPanel();
		jp_second_right_3 = new JPanel();
		jp_second_right_4 = new JPanel();

		jl_prev_word = new JLabel("Prev Word");
		jl_cur_word = new JLabel("Current World");
		jp_imsi = new JPanel();
		crow_down_arrow = new JLabel(new ImageIcon("images/down_arrow.png"));
		jp_second_check = new JPanel();
		jl_check_answer = new JLabel(new ImageIcon("images/answer_check.png"));
		jl_next_arrow = new JLabel(new ImageIcon("images/next_arrow.png"));
		jp_imsi2 = new JPanel();
		jl_english2 = new JLabel(new ImageIcon("images/play_1_english.png"));
		jt_english2 = new JTextField(30);
		jl_ok_false = new JLabel();
		// jl_play =new JToggleButton(new
		// ImageIcon("images/play_2_playButton.png"));
		jb_play = new JButton("Play");
		jb_stop = new JButton("Stop");
		jb_reset = new JButton("Reset");
		jl_pause = new JLabel(new ImageIcon("images/play_2_pauseButton.png"));
		jl_time_image = new JLabel(new ImageIcon("images/play_3_time.png"));
		jp_imsi3 = new JPanel();
		jl_timer = new JLabel("0");
		jl_StringhitNum = new JLabel("Hit");
		jl_hitNum = new JLabel("0");
		jl_StringfalseNum = new JLabel("False");
		jl_falseNum = new JLabel("0");
		jl_StringRemainWordNum = new JLabel("Remain");
		jl_remainWordNum = new JLabel("0");
		jp_imsi4 = new JPanel();
		choice = new Choice();

		jl_prev_word.setFont(font);
		jl_cur_word.setFont(font2);
		jt_english2.setFont(font);
		jl_StringhitNum.setFont(font0);
		jl_hitNum.setFont(font);
		jl_StringfalseNum.setFont(font0);
		jl_falseNum.setFont(font);
		jl_StringRemainWordNum.setFont(font0);
		jl_remainWordNum.setFont(font);
		jl_timer.setFont(font2);
		jl_timer.setForeground(Color.red);
		jl_ok_false.setFont(font1);
		jl_ok_false.setForeground(Color.red);

		jl_cur_word.setBorder(new LineBorder(Color.red));
		jl_prev_word.setBorder(new LineBorder(Color.blue));

		jp_content_second_right.setBorder(new LineBorder(Color.magenta, 3));
		jp_content_second_center.setBorder(new LineBorder(Color.orange, 3));

		// jp_content_third_center 화면
		jp_content_third = new JPanel();
		jp_content_third_center = new JPanel();
		jp_content_third_right = new JPanel();

		jp_third_1 = new JPanel();
		// jl3_play =new JLabel(new ImageIcon("images/play_3_playButton.png"));
		jb3_play = new JButton("play");
		jr3_speed1 = new JRadioButton("Fast(1초)");
		jr3_speed2 = new JRadioButton("Normal(2초)");
		jr3_speed3 = new JRadioButton("Slow(3초)");

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(jr3_speed1);
		bGroup.add(jr3_speed2);
		bGroup.add(jr3_speed3);
		jr3_speed2.setSelected(true); // 초기에 Normal 로 체크

		jp_third_2 = new JPanel();
		jp_third_2.setBackground(Color.gray);
		jl3_korean = new JLabel("한글 들어가는 레이블", JLabel.CENTER);
		jl3_english = new JLabel("영어 들어가는 레이블", JLabel.CENTER);
		jl3_currentIndex = new JLabel("0");
		jl3_total = new JLabel("/" + totalList.size());

		jl3_korean.setFont(font2);
		jl3_korean.setForeground(Color.lightGray);
		jl3_english.setFont(font1);
		jl3_english.setForeground(Color.white);
		jl3_currentIndex.setFont(font2);
		jl3_total.setFont(font);

		// jl3_korean.setSize(30, 10);

		jp_third_3 = new JPanel();

		jp_third_1.setSize(new Dimension(800, 900));

		// border
		jp_third_1.setBorder(new LineBorder(Color.orange, 5));
		jp_third_2.setBorder(new LineBorder(Color.blue, 5));

		/* Image size Test */
		// Toolkit tk = Toolkit.getDefaultToolkit();
		// Image img =tk.getImage("images/play_3_time.png");

		/* LayOut */
		jp_content_first.setLayout(new GridLayout(5, 1, 30, 30));

		jp_content_second.setLayout(new BorderLayout());
		jp_content_second_center.setLayout(new GridLayout(8, 1, 10, 10));
		jp_content_second_right.setLayout(new GridLayout(4, 1, 10, 10));
		jp_imsi.setLayout(new BorderLayout());
		jp_imsi2.setLayout(new BorderLayout());
		jp_imsi3.setLayout(new GridLayout(3, 2, 30, 30));
		jp_imsi4.setLayout(new GridLayout(1, 2, 30, 30));

		jp_content_third.setLayout(new BorderLayout());
		jp_content_third_center.setLayout(new GridLayout(3, 1, 100, 100));
		jp_third_2.setLayout(new GridLayout(2, 1, 30, 30));
		// jp_third_2.setLayout(new FlowLayout());
		jp_third_3.setLayout(new FlowLayout());

		jp_second_right_3.setBorder(new LineBorder(Color.yellow));

		// add
		jp_imsi.add(crow_down_arrow, BorderLayout.WEST);
		jp_imsi2.add(jl_english2, BorderLayout.WEST);

		jp_content_second_center.add(jl_prev_word);
		jp_content_second_center.add(jp_imsi);
		jp_content_second_center.add(jl_cur_word);
		jp_content_second_center.add(jp_imsi2);
		jp_content_second_center.add(jt_english2);
		jp_content_second_center.add(jl_ok_false);
		jp_second_check.add(jl_check_answer);
		jp_second_check.add(jl_next_arrow);
		jp_content_second_center.add(jp_second_check);

		jp_second_right_1.add(jb_play);
		jp_second_right_1.add(jb_stop);
		jp_second_right_1.add(jb_reset);
		jp_second_right_2.add(jl_time_image);
		jp_second_right_2.add(jl_timer);

		jp_imsi3.add(jl_StringhitNum);
		jp_imsi3.add(jl_hitNum);
		jp_imsi3.add(jl_StringfalseNum);
		jp_imsi3.add(jl_falseNum);
		jp_imsi3.add(jl_StringRemainWordNum);
		jp_imsi3.add(jl_remainWordNum);
		jp_second_right_3.add(jp_imsi3);

		// choice.setSize(300, 400);
		choice.setPreferredSize(new Dimension(80, 40));
		jp_imsi4.add(new JLabel("문제수"));
		jp_imsi4.add(choice);
		jp_second_right_4.add(jp_imsi4);

		jp_content_second_right.add(jp_second_right_1);
		jp_content_second_right.add(jp_second_right_4);
		jp_content_second_right.add(jp_second_right_2);
		jp_content_second_right.add(jp_second_right_3);

		jp_content_second.add(jp_content_second_center, BorderLayout.CENTER);
		jp_content_second.add(jp_content_second_right, BorderLayout.EAST);

		// jp_content_third_center 화면
		jp_third_1.add(jb3_play);
		jp_third_1.add(jr3_speed1);
		jp_third_1.add(jr3_speed2);
		jp_third_1.add(jr3_speed3);

		jp_content_third_center.add(jp_third_1);
		jp_content_third_center.setBorder(new LineBorder(Color.magenta, 3));
		jp_content_third_right.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		jp_content_third_right.setPreferredSize(new Dimension(200, 800));
		jp_third_2.add(jl3_korean);
		jp_third_2.add(jl3_english);
		jp_content_third_center.add(jp_third_2);

		jp_third_3.add(jl3_currentIndex);
		jp_third_3.add(jl3_total);

		jp_content_third_center.add(jp_third_3);

		jp_content_third_right.add(new JLabel("총 단어 수 : "));

		jp_content_third.add(jp_content_third_center, BorderLayout.CENTER);
		jp_content_third.add(jp_content_third_right, BorderLayout.EAST);

		jp_content_third.setPreferredSize(new Dimension(1000, 800));

		// jp_center
		// jp_center.add(jp_content_first);
		jp_center.add(jp_content_second);
		/*
		 * jp_center.add(jp_content_second_center , "2");
		 * jp_center.add(jp_content_third , "3");
		 * 
		 * jp_center.setLayout(new CardLayout(10,10));
		 */

		// Background
		// jp_up.setBackground(Color.cyan);
		// jp_center.setBackground(Color.blue);
		// jp_down.setBackground(Color.yellow);

		setLayout(new BorderLayout());
		add(jp_up, BorderLayout.NORTH);
		add(jp_center, BorderLayout.CENTER);
		add(jp_down, BorderLayout.SOUTH);

		setSize(1300, 1000); // width , height

		// Align Center
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		setVisible(true);

		this.total_List = totalList;

		// 문장추가 (1) 화면 이벤트 처리
		jl_first.addMouseListener(new MouseEventClass(1));
		jl_second.addMouseListener(new MouseEventClass(2));
		jl_third.addMouseListener(new MouseEventClass(3));
		jl_plus.addMouseListener(new MouseEventClass(4));
		jl_store.addMouseListener(new MouseEventClass(5));

		// keyEvent 등록
		jt_english2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch(key){
					case KeyEvent.VK_RIGHT:
						nextWordSetting();
						jt_english2.setText("");
//						System.out.println("RIGHT KEY preesed");
						
						break;
				}
				
			}
		});
		
		

		eventSetting2();
		eventSetting3();

	}

	public void settingChoice(ArrayList<Sentence> list) {
		int temp = list.size() / 10;
		for (int i = 1; i <= temp; i++) {
			choice.add(i * 10 + "");
		}
		choice.add(list.size() + "");
	}

	// Event Handler
	public void eventSetting2() {

		// choice setting

		jb_stop.setEnabled(false);

		// final Timer timer =new Timer();
		work = new WorkTask(jl_timer);
		/* Second Page */
		jb_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int settingListSize = Integer.parseInt(choice.getSelectedItem());
				System.out.println("settingSize:" + settingListSize);

				list = new ArrayList<Sentence>();
				for (int i = 0; i < settingListSize; i++) {
					list.add(total_List.get(i));
				}

				jb_play.setEnabled(false);
				jb_stop.setEnabled(true);
				jb_reset.setEnabled(false);

				String preword = list.get(wordNum).getKorean();
				String curword = list.get(wordNum - 1).getKorean();

				jl_prev_word.setText(preword);
				jl_cur_word.setText(curword);

				answer_word = list.get(wordNum - 1).getEnglish();

				wordNum++;
				// 타이머 작동 시키기

				work.timer.schedule(work, 0, 1000);

			}
		});

		jb_stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jb_stop.getText().equals("Stop")) {

					work.timer.cancel();
					// work.timer.purge();

					jb_stop.setEnabled(false);
					jb_reset.setEnabled(true);
					// jb_play.setEnabled(true);

					int totalScore = calc(jl_timer.getText());

					JOptionPane.showMessageDialog(null, "게임 종료!\n" + "hit: "
							+ hitNum + "\n" + "false: " + falseNum + "\n"
							+ "점수: " + totalScore + "\n");

				}

			}

		});

		jb_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hitNum = 0;
				falseNum = 0;
				remainNum = 0;
				wordNum = 1;

				jl_hitNum.setText(hitNum + "");
				jl_falseNum.setText(falseNum + "");
				jl_remainWordNum.setText(remainNum + "");

				new Random().makeRandomList(total_List);

				jb_play.setEnabled(true);

				// 타이머 작동 시키기
				jl_timer.setText("0");
				;
				work = new WorkTask(jl_timer);

			}
		});

		jl_plus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sentence sentence = new Sentence();

				String english = jt_english.getText();
				String korean = jt_korean.getText();

				sentence.setEnglish(english);
				sentence.setKorean(korean);

				exel.addSentence(sentence);
				JOptionPane.showMessageDialog(null, "추가되었습니다");

				jt_english.setText("");
				jt_korean.setText("");

			}
		});

		//
		jl_store.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				exel.storeData();
				JOptionPane.showMessageDialog(null, "엑셀 파일에 저장되었습니다");
			}
		});

		/* Second Page */

		// word Next
		jl_next_arrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextWordSetting();
			}
		});

		jl_check_answer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				sendAnswer();
			}

		});

		// textField 에서 엔터 눌렀을 때도 actionPerfomred 실행
		jt_english2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendAnswer();
			}
		});

	}

	// 3Page event
	public void eventSetting3() {
		jb3_play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jb3_play.setEnabled(false);
				// System.out.println("totalList.size:"+total_List.size());
				int timeInterval = 2000;
				if (jr3_speed1.isSelected()) {
					timeInterval = 1000;
				} else if (jr3_speed2.isSelected()) {
					timeInterval = 2000;
				} else if (jr3_speed3.isSelected()) {
					timeInterval = 3000;
				}

				WorkTask2 work2 = new WorkTask2(jl3_korean, jl3_english,
						total_List, jl3_currentIndex , jb3_play);
				Timer timer = new Timer();
				timer.schedule(work2, 0, timeInterval);

				//

				// WorkTask2 만들기전에 생각한것 (JLabel 업데이트가 안되는 문제점 있음)
				/*
				 * for(int i=0;i<total_List.size();i++){
				 * jl3_korean.setText(total_List.get(i).getKorean());
				 * jl3_english.setText(total_List.get(i).getEnglish());
				 * 
				 * jp_third_2.revalidate();
				 * 
				 * System.out.println("korean:"+jl3_korean.getText());
				 * 
				 * try { Thread.sleep(1000);
				 * 
				 * } catch (InterruptedException e1) { e1.printStackTrace(); } }
				 */
			}
		});

	}

	public void nextWordSetting() {
		String preword = "";
		String curword = "";

		remainNum = list.size() - wordNum + 1;
		// There is no reaminNum , then game is finished
		if (remainNum == 0) {
			jl_remainWordNum.setText("0");
			jb_stop.doClick();
			return;

		}

		if (wordNum == list.size()) {
			curword = list.get(wordNum - 1).getKorean();
		} else if (wordNum < list.size()) { // before: else{
			preword = list.get(wordNum).getKorean();
			curword = list.get(wordNum - 1).getKorean();
		}

		if (wordNum < list.size()) {
			jl_prev_word.setText(preword);
			jl_cur_word.setText(curword);
		} else {
			jl_prev_word.setText("No Next Word...");
			jl_cur_word.setText(curword);
		}
		answer_word = list.get(wordNum - 1).getEnglish();

		jl_remainWordNum.setText(remainNum + "");
		wordNum++;
	}

	/* 정답체크 메소드 */
	public void sendAnswer() {

		// 대문자 소문자 상관 없게 하기
		// jt_english2.getText().toLowerCase() -> 소문자로 변환해서 비교 ( 대소문자 상관없이 정답체크
		// 하기 위해서)

		if (jt_english2.getText().toLowerCase()
				.equals(answer_word.toLowerCase())) {
			jl_ok_false.setText("정답입니다!");
			jt_english2.setText("");
			hitNum++;
			jl_hitNum.setText(hitNum + "");

			nextWordSetting();
		} else {

			jl_ok_false.setText("오답입니다! \n " + "정답: " + answer_word);

			// jt_english2.setText("");
			jt_english2.selectAll();
			falseNum++;
			jl_falseNum.setText(falseNum + "");
		}
	}

	/*
	 * 점수 계산
	 * 
	 * (Hit*3 -false ) * 100 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ- (나누기) finish time
	 */
	public int calc(String finishTime) {
		int finishTimeNum = Integer.parseInt(finishTime);
		int score = (hitNum * 3 - falseNum) * 100 / (finishTimeNum);

		return score;
	}

	class MouseEventClass implements MouseListener {

		public int num;

		public MouseEventClass(int num) {
			this.num = num;

		}

		@Override
		public void mouseClicked(MouseEvent e) {

			if (num == 1) {
				jp_center.remove(jp_content_second);
				jp_center.remove(jp_content_third);
				jp_center.repaint();
				jp_center.add(jp_content_first);
				// jp_content_first.repaint();
				jp_center.revalidate();
			} else if (num == 2) {
				jp_center.remove(jp_content_first);
				jp_center.remove(jp_content_third);
				jp_center.repaint();
				jp_center.add(jp_content_second);
				jp_center.revalidate();
			} else if (num == 3) {
				jp_center.remove(jp_content_first);
				jp_center.remove(jp_content_second);
				jp_center.repaint();
				jp_center.add(jp_content_third);
				jp_center.revalidate();
				// plus 기호
			} else if (num == 4) {

			} else if (num == 5) {

			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

	}

	public ArrayList<Sentence> getList() {
		return list;
	}

	public void setList(ArrayList<Sentence> list) {
		this.list = list;
	}

}
