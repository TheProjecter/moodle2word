import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;


public class AuditorConvertir implements ActionListener {
	private ConverterPanel padre;
	private File fichero;
	
	public AuditorConvertir(ConverterPanel padre) {
		this.padre = padre;
		this.fichero = padre.getFile();
	}
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser selectorSalida = new JFileChooser();
		selectorSalida.showSaveDialog(padre);
		padre.reiniciarInterfaz();
	}
}
