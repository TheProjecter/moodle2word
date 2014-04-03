import javax.swing.JFrame;


public class Converter extends JFrame {
	public Converter() {
		this.setContentPane(new ConverterPanel());
		this.setResizable(false);
		this.setLocation(150, 150);
		this.setSize(350, 170);
		this.setVisible(true);
		this.setTitle("Conversor de informes a word");
	}
	
	public static void main(String args[]) {
		Converter converter = new Converter();
	}
}
