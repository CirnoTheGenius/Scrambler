import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

//Just a message scrambler.
//Will work on during free time/when I want to.

@SuppressWarnings("serial")
public class scramble extends JFrame implements ActionListener {
	JTextField msg = new JTextField("String goes here!");
	JButton batton = new JButton("Encrypt!");
	JTextField resault = new JTextField("Resault")
	;
	public String scramblemsg(String s) {
		String nw = "Failed to convert";
		String[] msg = s.split(" ");
		for(int i=0; i < msg.length; i++){
			try {
				String word = msg[i];
				System.out.println(word);
				ArrayList<Character> chars = new ArrayList<Character>(s.length());
				//I'll have to clean this up later...
				String b = word.substring(0, 1);
				System.out.println("The beginning letter is: " + b);
				String e = word.substring(word.length()-1, word.length());
				System.out.println("The ending letter is: " + e);
				String w = word.substring(1, word.length() - 1);
				System.out.println("The middle letters are: " + w);
				char[] middle = w.toCharArray();
				Random r = new Random();
				nw = b;
				for(int zi=0; zi < middle.length; zi++){
					chars.add(middle[zi]);
					System.out.println("The added character was: " + chars.get(zi));
				}
				while(nw.length() < chars.size()+1){
					int n = r.nextInt(chars.size());
					nw = nw + chars.get(n);
					chars.remove(n);
				}
				nw = nw + e;
				System.out.println("The new word is: " + nw);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return nw;
    }
      
       
	public scramble() throws Exception {
		setTitle("Message Scramler!");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	public static void main(String[] args) throws Exception{
			scramble s = new scramble();
			s.validate();
	}
}
