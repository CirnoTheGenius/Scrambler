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
		setTitle("Message Scramler!");
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
		resault.setText(scramblemsg(msg.getText()));
	}

	public String scramblemsg(String s) {
		String[] msg = s.split(" ");
		String fm = "";
		for (String word : msg) {
			try {
				if(word.length() == 1 || word.length() == 2){
					if(fm.isEmpty()){
						fm = word;
					} else {
						fm = fm + " " + word;
					}
					continue;
				}
				
				String nw = "Failed to convert";
				ArrayList<Character> chars = new ArrayList<Character>(s.length());
				String b = word.substring(0, 1);
				String e = word.substring(word.length()-1, word.length());
				String w = word.substring(1, word.length() - 1);
				char[] middle = w.toCharArray();
				Random r = new Random();
				nw = b;
				
				for(int zi=0; zi < middle.length; zi++){
					chars.add(middle[zi]);
				}
				while(nw.length() < s.length() && chars.size() > 0){
					int n = r.nextInt(chars.size());
					if(Character.valueOf(chars.get(n)).toString() == e){
						chars.remove(n);
					}
					nw = nw + chars.get(n);
					chars.remove(n);
				}
				nw = nw + e;
				if(fm.isEmpty()){
					fm = nw;
				} else {
					fm = fm + " " + nw;
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return fm;
	}
}
