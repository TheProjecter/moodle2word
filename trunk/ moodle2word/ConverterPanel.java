import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ConverterPanel extends JPanel {
	
	private JButton selectorEntrada;
	private JLabel selectedPath;
	private File selectedFile;
	private JComboBox<String> tipoInforme;
	private JButton convertir;
	
	public ConverterPanel() {
		selectorEntrada = new JButton("Explorar");
		selectedPath = new JLabel("<No se ha seleccionado ningun fichero de entrada>");
		selectorEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser selector = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma-Separated Values (.csv)", "csv");
				selector.setFileFilter(filter);
				int opc = selector.showOpenDialog(ConverterPanel.this);
				if(opc == JFileChooser.APPROVE_OPTION) {
					selectedFile = selector.getSelectedFile();
					selectedPath.setText(selectedFile.getName());
					convertir.setEnabled(true);
				}
			}
		});
		tipoInforme = new JComboBox<String>(MInforme.TIPOS);
		convertir = new JButton("Convertir");
		convertir.addActionListener(new AuditorConvertir(this));
		convertir.setEnabled(false);
		
		JLabel label1 = new JLabel("Selecciona el fichero de entrada:");
		JLabel label2 = new JLabel("Selecciona el tipo de informe a convertir:");
		
		GroupLayout dist = new GroupLayout(this);
		dist.setAutoCreateContainerGaps(true);
		dist.setAutoCreateGaps(true);
		this.setLayout(dist);
		dist.setVerticalGroup(dist.createSequentialGroup().addGroup(dist.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(label1).addComponent(selectorEntrada))
				.addComponent(selectedPath).addComponent(label2).addComponent(tipoInforme).addComponent(convertir));
		dist.setHorizontalGroup(dist.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(dist.createSequentialGroup().addComponent(label1).addComponent(selectorEntrada))
				.addComponent(selectedPath).addComponent(label2).addComponent(tipoInforme).addComponent(convertir));

	}
	
	public File getFile() {
		return selectedFile;
	}
	
	public void reiniciarInterfaz() {
		selectedPath.setText("<No se ha seleccionado ningun fichero de entrada>");
		convertir.setEnabled(false);
	}
}
