/**
*Classe que será responsavel por escolher o algoritmo a ser
*utilizado e depois exibir o resultado da ordenação. 
*/
package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import base.Order;

public class WindowMain extends JPanel implements ActionListener{
	//Variaveis
	private static final long serialVersionUID = 1L;
	//Paineis
	private JPanel JPButtons;	//Painel para os butões
	private JPanel JPCenter;	//Painel Central
	private JPanel JPCamp;		//Painel para seleção de chave
	private JPanel JPOptions;	//Painel para as opções de algoritmos
	private JPanel JPObject;	//Painel para entrada da string para ordenada
	private JPanel JPResult;	//Painel para saida da string já ordenada
	//Labels
	private JLabel JLCamp;
	private JLabel JLCamps[] = {new JLabel("Campo 1:"), new JLabel("Campo 2:")};
	private JLabel JLResult;
	private JLabel JLNumSize;
	private JLabel JLSize;
	private JLabel JLString;
	private JLabel JLTitle;
	//TextFields
	private JTextField JTCamp1;
	private JTextField JTCamp2;
	private JTextField JTNumSize;
	private JTextField JTSize;
	//CheckBoxes
	private JCheckBox JCOp1;
	private JCheckBox JCOp2;
	//Buttons
	private JButton JBAdd;
	private JButton JBGo;
	private JButton JBClear;
	private JButton JBStart;
	//Combobox
	private JComboBox<String> JCBOptions;
	private String options[] = {"Selecione","InsertionSort","SelecionSort","QuickSort","MergeSort","HeapSort"};  
	
	public WindowMain() {
		//Inicializando os jpanels
		JPButtons = new JPanel();
		JPCenter = new JPanel();
		JPCamp = new JPanel();
		JPOptions = new JPanel();
		JPObject = new JPanel();
		JPResult = new JPanel();
		//Inicializando jlabels
		JLCamp = new JLabel("Campo chave: ");
		JLResult = new JLabel();
		JLNumSize = new JLabel("Gerar:");
		JLSize = new JLabel("c/ tamanho:");
		JLString = new JLabel();
		JLTitle = new JLabel("Algoritmo de Ordenação:	");
		//Inicializando os jtextfields
		JTCamp1 = new JTextField(10);
		JTCamp2 = new JTextField(10);
		JTNumSize = new JTextField(7);
		JTSize = new JTextField(4);
		//Inicializando os jbuttons
		JBAdd = new JButton("+");
		JBGo = new JButton("*");
		JBClear = new JButton("Limpar");
		JBStart = new JButton("Iniciar");
		//Inicializando os jcheckboxes
		JCOp1 = new JCheckBox("1", true);
		JCOp2 = new JCheckBox("2", false);
		//Carregando a combobox
		JCBOptions = new JComboBox<String>(options);
		
		//Setando os paineis 
		JPCenter.setLayout(new GridLayout(0, 1));	//Painel central
		JPCenter.add(JPObject);
		JPCenter.add(JPResult);
		JPCenter.add(JPCamp);
		
		JPCamp.setLayout(new FlowLayout());	//Painel de selecao do campo de comparação
		JPCamp.add(JLCamp);
		JPCamp.add(JCOp1);
		JPCamp.add(JCOp2);
		
		JPButtons.setLayout(new GridLayout(0, 2));	//Painel dos butões
		JPButtons.add(JBStart);
		JPButtons.add(JBClear);
		
		JPObject.setLayout(new FlowLayout());	//Painel de entrada de dados
		JPObject.add(JLCamps[0]);
		JPObject.add(JTCamp1);
		JPObject.add(JLCamps[1]);
		JPObject.add(JTCamp2);
		JPObject.add(JBAdd);
		JPObject.add(JLNumSize);
		JPObject.add(JTNumSize);
		JPObject.add(JLSize);
		JPObject.add(JTSize);
		JPObject.add(JBGo);
		
		JPOptions.setLayout(new FlowLayout());	//Painel de seleção do algoritmo
		JPOptions.add(JLTitle);
		JPOptions.add(JCBOptions);
		
		JPResult.setLayout(new GridLayout(0, 1));	//Painel de exibição
		JPResult.add(JLString);
		JPResult.add(JLResult);
		
		this.setLayout(new BorderLayout());	//Painel principal
		this.add(JPOptions,BorderLayout.PAGE_START);
		this.add(JPCenter,BorderLayout.CENTER);
		this.add(JPButtons,BorderLayout.PAGE_END);
		
		//Setando os butões
		JBAdd.addActionListener(this);
		JBGo.addActionListener(this);
		JBStart.addActionListener(this);
		JBClear.addActionListener(this);
		JCOp1.addActionListener(this);
		JCOp2.addActionListener(this);
		
		
	}
	
	//Metodo que verifica se os campos estão vazios
	public boolean notIsVoid(String s){
		if(s.equals("")){
			return false;
		}
		return true;
	}
	
	//Metodo para eliminar caracteres especiais
	public String validateString(String s){
		s.replaceAll(",", ".");
		s.replaceAll(" ", "");
		return s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBAdd){	//Adiciona os campos a string a ser ordenada
			JTCamp1.setText(this.validateString(JTCamp1.getText()));	//Valida a string
			JTCamp2.setText(this.validateString(JTCamp2.getText()));
			if(this.notIsVoid(JTCamp1.getText())&&this.notIsVoid(JTCamp2.getText())){	//Testa se tem algo nos campos
				if(this.notIsVoid(JLString.getText())){
					JLString.setText(JLString.getText()+JTCamp1.getText()+";"+JTCamp2.getText()+"//");	//Adicionar os campos a string juntamente com os demarcadores
				}
				else{
					JLString.setText(JTCamp1.getText()+";"+JTCamp2.getText()+"//");
				}
				JTCamp1.setText("");	//Limpa o preenchimento
				JTCamp2.setText("");
			}
			else{
				JOptionPane.showMessageDialog(null, "Preencha os dois campos!");	//Aviso dos campos vazios
			}
		}
		else if(e.getSource() == JCOp1){	//Alternacia dos campos
			JCOp2.setSelected(false);
		}
		else if(e.getSource() == JCOp2){
			JCOp1.setSelected(false);
		}
		else if(e.getSource() == JBStart){
			if(JCBOptions.getSelectedIndex()!=0){	//Verifica se algum algoritmo foi selecionado
				int modeQuick = -1, camp = 0;
				if(JCBOptions.getSelectedIndex() == 3){	//Verifica se é o algoritmo quicsort que necessita do modo
					while(modeQuick == -1){	//Executa ate a entrada correta
						String sMode = JOptionPane.showInputDialog("Pivo:Digite 0->inicio 1->meio 2->fim");	//Carrega o modo
						if(sMode.equals("0")||sMode.equals("1")||sMode.equals("2")){
							modeQuick = Integer.parseInt(sMode);	//Passa o valor para inteiro
						}
					}
				}
				if(JCOp2.isSelected()){	//Verifica se -e o segundo campo
					camp = 1;
				}
				JLResult.setText(new Order().orderString(JLString.getText(), camp, JCBOptions.getSelectedIndex(), modeQuick)); //Chama e seta o algoritmo de ordenação
			}
			else{
				JOptionPane.showMessageDialog(null, "Selecione o algoritmo!");	//Aviso da seleção do algorimo
			}
		}
		else if(e.getSource() == JBClear){	//Reinicializa os dados
			JTCamp1.setText("");
			JTCamp2.setText("");
			JTNumSize.setText("");
			JTSize.setText("");
			JLString.setText("");
			JLResult.setText("");
			JCBOptions.setSelectedIndex(0);
			JCOp1.setSelected(true);
			JCOp2.setSelected(false);
		}
		else if(e.getSource() == JBGo){	//Gera os campos para a string
			this.getStringLabel();	//Chamada ao metodo gerador
		}
	}
	
	private void getStringLabel(){
		//Variaveis
		boolean ehNumero;	//Para testa se o valor dos campos são inteiros
		int numSize=0, size=0;	//numSize numero de campos adicionador, size tamanho dos campos gerados
		try {
			numSize = Integer.parseInt(JTNumSize.getText());
			size = Integer.parseInt(JTSize.getText());
		    ehNumero = true;
		}catch (NumberFormatException e) {	  
			ehNumero = false;
		}
		if (ehNumero) {	//Caso seja numero
			while(numSize > 0){
				UUID uuid = UUID.randomUUID();
				String myRandom = uuid.toString();
				JLString.setText(JLString.getText()+myRandom.substring(0,size)+";"+myRandom.substring(size,size*2)+"//");
				numSize--;
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Digite apenas numeros!");	//Aviso dos campos geradores
			JLNumSize.setText("");
			JLSize.setText("");
		}
	}
}
