import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//Just a message scrambler.
//Will work on during free time/when I want to.

@SuppressWarnings("serial")
public class scramble extends JFrame implements ActionListener {
	public static void main(String[] args) throws Exception{
		scramble s = new scramble();
		s.validate();
	}

	JButton batton = new JButton("Scramble!");
	JTextField msg = new JTextField("String goes here!");
	JTextField resault = new JTextField("Resault");

	public scramble() throws Exception {
		setTitle("Message Scrambler!");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 2));
		getContentPane().add(msg);
		getContentPane().add(batton);
		getContentPane().add(resault);
		batton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		resault.setText(scrambleSentence(msg.getText()));
	}

	public String scrambleSentence(String s){
		String fm = "";
		String[] msg = s.split(" ");
		for(int i=0; i < msg.length; i++){
			if(fm.isEmpty()){
				if(msg[i].length() == 1 || msg[i].length() == 2){
					fm = msg[i];
				} else {
					fm = scrambleWord(msg[i]);
				}
			} else {
				if(msg[i].length() == 1 || msg[i].length() == 2){
					fm = fm.trim() + " " + msg[i];
				} else {
					fm = fm + " " + scrambleWord(msg[i]);
				}
			}
		}
		return fm;
	}

	public String scrambleWord(String s) {
		String nw = "";
		if(!(s.length() == 1 || s.length() == 2)){
			ArrayList<Character> chars = new ArrayList<Character>();
			String b = s.substring(0, 1);
			String e = s.substring(s.length()-1, s.length());
			String w = s.substring(1, s.length() - 1);
			char[] middle = w.toCharArray();
			Random r = new Random();
			for(int i=0; i < middle.length; i++){
				chars.add(middle[i]);
			}
			while(nw.length() < s.length() && chars.size() > 0){
				int n = r.nextInt(chars.size());
				nw = nw + chars.get(n);
				chars.remove(n);
			}
			nw = b + nw + e;
		}
		return nw;
	}
}
