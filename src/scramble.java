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
		resault.setText(scramblesentence(msg.getText()));
	}

	public String scramblesentence(String s){
		String fm = "";
		String[] msg = s.split(" ");
		for(int i=0; i < msg.length; i++){
			if(fm.isEmpty()){
				fm = scrambleWord(msg[i]);
			} else {
				fm = fm + " " + scrambleWord(msg[i]);
			}
		}
		return fm;
	}
	
	public String scrambleWord(String s) {
		String nw = "Fail";
		try {
			if(!(s.length() == 1 || s.length() == 2)){
				ArrayList<Character> chars = new ArrayList<Character>(s.length());
				String b = s.substring(0, 1);
				String e = s.substring(s.length()-1, s.length());
				String w = s.substring(1, s.length() - 1);
				char[] middle = w.toCharArray();
				Random r = new Random();
				nw = b;
				for(int zi=0; zi < middle.length; zi++){
					if(!(Character.valueOf(middle[zi]).toString() == e))
						chars.add(middle[zi]);
				}
				while(nw.length() < s.length() && chars.size() > 0){
					int n = r.nextInt(chars.size());
					nw = nw + chars.get(n);
					chars.remove(n);
				}
				nw = nw + e;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return nw;
	}
}
