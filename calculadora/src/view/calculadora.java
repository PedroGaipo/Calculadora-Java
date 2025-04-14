//https://youtu.be/RTsnAIJXNVI?si=AXp8QApXj0B60Wci VÍDEO USADO PARA A CRIAÇÃO DESSE CÓDIGO

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class calculadora extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDisplay;
	private Color corBotao;
	private Color corFundo;
	private Color corTexto;
	private Color corLinha;
	private int x;
	private int y;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora(); 
					frame.setVisible(true);					//Deixa a calculadora visível
					frame.setLocationRelativeTo(frame);		//Define onde a calculadora vai aparecer inicialmente 
					frame.setUndecorated(true);				//Era pra esconder a barra de minimizar, maximizar e fechar a janela mas por algum motivo nao funcionou
					frame.setOpacity((float)0.80);			//muda a opacidade da calculadora
					frame.setTitle("Calculadora");			//muda o título da janela
				} catch (Exception e) {						//
					e.printStackTrace();
				}
			}
		});
	}


	public calculadora() {
		corBotao = new Color( 70, 71, 74 ); 
		corFundo = Color.DARK_GRAY;
		corTexto = new Color( 53, 53, 53 );
		corLinha = new Color( 53, 53, 53 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a calculadora quando clicamos no "X" de fechar
		setBounds(100, 100, 335, 530);
		contentPane = new JPanel();					   //método de painel do java
		contentPane.setBackground(corFundo);
		contentPane.setBorder(null);
		setContentPane(contentPane);					//contentPane serve como uma camada do JFrame. Ele vai servir para colocarmos os textos e os botões e é mais fácil de organizar
		contentPane.setLayout(null);
		
		movimentarTela();
		
		JButton btnFechar=criarBotao ("X", 280, 0, 40, 30);//criei um botão personalizado que iria fechar a calculadora mas como não consegui tirar a aba da janela ficaram 2 botões de fechar
		btnFechar.addActionListener(this);				//add.ActionListener vai fazer com que quando o usuário interagir com esse botão ele seja ativado
		contentPane.add(btnFechar);	
		
		textFieldDisplay=new JTextField();					//Display onde vão ficar os números que o usuário escolher
		textFieldDisplay.setBorder(null);					//borda do display nula
		textFieldDisplay.setEditable(false);				//será editável
		textFieldDisplay.setFont(new Font("Tahoma", Font.PLAIN, 48));//fonte dos números e tamanho
		textFieldDisplay.setHorizontalAlignment(SwingConstants.RIGHT);//alinhado a direita
		textFieldDisplay.setForeground(Color.white);				//cor branca
		textFieldDisplay.setText("0");								//inicialmente aparecerá o texto "0"
		textFieldDisplay.setBounds(0, 32, 320, 60);					//posição do display na calculadora
		textFieldDisplay.setBackground(corFundo);					//cor do displaay (no caso é a cor da variável corFundo que é preta)
		contentPane.add(textFieldDisplay);							
		textFieldDisplay.setColumns(10);							//define o tanto de colunas que podem ser colocadas
		
		
		
		JButton btnApagar=criarBotao ("C", 0, 90, 240, 80);			//botões criados para o usuário clicar
		btnApagar.addActionListener(this);							//actionListener vai identificar que o usuário clicou no botão
		contentPane.add(btnApagar);									//quando o usuário clicar no botão o mesmo será identificado graças ao contentPane.add
		
		JButton btnMulti=criarBotao ("*", 240, 330, 80, 80);
		btnMulti.addActionListener(this);
		contentPane.add(btnMulti);
		
		JButton btnDivi=criarBotao ("/", 240, 90, 80, 80);
		btnDivi.addActionListener(this);
		contentPane.add(btnDivi);
		
		JButton btnSoma=criarBotao ("+", 240, 170, 80, 80);
		btnSoma.addActionListener(this);
		contentPane.add(btnSoma);
		
		JButton btnSubt=criarBotao ("-", 240, 250, 80, 80);
		btnSubt.addActionListener(this);
		contentPane.add(btnSubt);
		
		JButton btnIgual=criarBotao ("=", 240, 410, 80, 80);
		btnIgual.addActionListener(this);
		contentPane.add(btnIgual);
		
		JButton btnZero=criarBotao ("1", 0, 170, 80, 80);
		btnZero.addActionListener(this);
		contentPane.add(btnZero);
		
		JButton btnUm=criarBotao ("2", 80, 170, 80, 80);
		btnUm.addActionListener(this);
		contentPane.add(btnUm);
		
		JButton btnDois=criarBotao ("3", 160, 170, 80, 80);
		btnDois.addActionListener(this);
		contentPane.add(btnDois);
		
		JButton btnTres=criarBotao ("4", 0, 250, 80, 80);
		btnTres.addActionListener(this);
		contentPane.add(btnTres);
		
		JButton btnQuatro=criarBotao ("5", 80, 250, 80, 80);
		btnQuatro.addActionListener(this);
		contentPane.add(btnQuatro);
		
		JButton btnCinco=criarBotao ("6", 160, 250, 80, 80);
		btnCinco.addActionListener(this);
		contentPane.add(btnCinco);
		
		JButton btnSeis=criarBotao ("7", 0, 330, 80, 80);
		btnSeis.addActionListener(this);
		contentPane.add(btnSeis);
		
		JButton btnSete=criarBotao ("8", 80, 330, 80, 80);
		btnSete.addActionListener(this);
		contentPane.add(btnSete);
		
		JButton btnOito=criarBotao ("9", 160, 330, 80, 80);
		btnOito.addActionListener(this);
		contentPane.add(btnOito);
		
		JButton btnNove=criarBotao ("0", 0, 410, 240, 80);
		btnNove.addActionListener(this);
		contentPane.add(btnNove);
		
		JPanel panelBotoesNumericos = new JPanel();					//início da criação do painel da calculadora
		panelBotoesNumericos.setBounds(0, 170, 240, 320);			
		panelBotoesNumericos.setLayout(new GridLayout(4,3));
		panelBotoesNumericos.setBorder(null);
		panelBotoesNumericos.setBackground(corFundo);
		panelBotoesNumericos.setForeground(corTexto);
		panelBotoesNumericos.setFont(new Font("Tahoma", Font.PLAIN, 48));
		panelBotoesNumericos.setOpaque(true);
		
		String[] botoesNumericos= {"1", "2", "3", "4", "5", "6", "7", "8", "9"};	//definindo os números que poderão ser apertados pelo usuário
		
		for(String botao: botoesNumericos) {		
			JButton btn=new JButton(botao);											//para cada número será definido um botão
			btn.addActionListener(this);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			btn.setFont(new Font("Tahoma", Font.PLAIN, 36));
			btn.setForeground(corTexto);
			btn.setFocusPainted(false);
			btn.setBackground(corBotao);
			btn.setBorder(new LineBorder(corLinha, 2));
			panelBotoesNumericos.add(btn);											//os botões foram adicionados ao painel de botões da calculadora
			
		}
		contentPane.add(panelBotoesNumericos);										
		for (Component component: contentPane.getComponents()) {					//todos os componentes do contentPane serão percorridos com a finalidadde de alterar a cor dos botões quando passar o mouse em cima
			if(component instanceof JButton) {					//nessa linha o programa vai testar e ver se a instancia do componente é um botão(JButton)
				JButton btn=(JButton)component;					//se a instancia for um botão o componente se transforma em um botão
				alternarCorBotao(btn);							//após confirmar que é um botão a variável alternarCorBotao será usada e o botão vai mudar de cor
			}
		}
	}

	private void alternarCorBotao(JButton jButton) {			//código para alterar a cor do botão quando o mouse passar em cima
		jButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {			//método para definir se o mouse entrou no botão
				jButton.setBackground(Color.DARK_GRAY);			//se ele entrou o botão vai mudar para a cor cinza escuro
			}
			
			public void mouseExited(MouseEvent e) {				//metodo para definir se o mouse saiu do botão
				jButton.setBackground(corBotao);				//se ele saiu o botão vai voltar para a cor original do botão
			}	
		});
	}
	
	private JButton criarBotao(String textoBotao, int x, int y, int width, int height) {//aqui os botões são criados e nele terá que ser especificado seu texto. a altura e comprimento, além do x e do y que são suas posições na calculadora
		JButton jButton=new JButton(textoBotao);
		jButton.setHorizontalAlignment(SwingConstants.CENTER);
		jButton.setFont(new Font("Tahoma", Font.PLAIN, textoBotao.equalsIgnoreCase("X") ? 20:36));//aqui o tamanho da fonte do botão de fechar é especificadamente diferente(no caso: equalsIgnoreCase("X")E é falado que seu tamanho será 20 ao invés de 36
		jButton.setForeground(corTexto);
		jButton.setFocusPainted(false);
		jButton.setBackground(corBotao);
		jButton.setBorder(new LineBorder(corLinha, 2));
		jButton.setBounds(x, y, width, height);
		
		return jButton;
	}

	
	private void movimentarTela() {		//um método para poder movimentar a tela caso não tivesse a barra de título que minimiza e fecha mas que eu não consegui tirar
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - x, e.getYOnScreen()-y);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //vai identificar qual botão foi clicado pelo usuário
				x=e.getX();
				y=e.getY();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {		
		String comando= e.getActionCommand();		//variável comando para receber o botão que foi clicado
		
		if("=".equals(comando)) {
			
			String expressao = textFieldDisplay.getText();
			double resultado = verificarExpressao(expressao); //método para identificar o resultado da expressão
			textFieldDisplay.setText(Double.toString(resultado));	//o resultado vai ser transformado em string com o comando Double.toString
		}else if("c".equalsIgnoreCase(comando)){		//se o botão de limpar display("C") for apertado o display vai mostrar "0"
			textFieldDisplay.setText("0");
		}else if("x".equalsIgnoreCase(comando)) {		//se o botão que fecha a calculadora ("X") for clicado a calculadora será interrompida junto com o comando
			dispose();
		} else {
			String textoDisplay = textFieldDisplay.getText();	//aqui será pego o texto que vai ser selecionado e que estará no display
			char lastChar = textoDisplay.charAt(textoDisplay.length()-1);		//o comando .charAt vai pegar o último número(pois foi colocado o -1 para especificar que será o último)
			
			if (isOperador(lastChar) && isOperador(comando.charAt(comando.length()-1))){	//vai verificar se o último texto e se o comando que o usuário acabou de clicar é um operador
				//o if acima serve para que não ocorra uma repetição de operadores e que não tenha conflitos durante a equação na calculadora. Por exemplo quando vai ser feito a conta 2 + 2 mas sem querer o usuário clicou no sinal de subtração - antes de escrever o segundo dois, o operador de soma será apagado e o de subtração entrará no lugar
				textoDisplay = textoDisplay.substring(0, textoDisplay.length()-1);
				textFieldDisplay.setText(textoDisplay+comando);
			}else {//caso não seja um operador e sim um botão
				if(textFieldDisplay.getText().equalsIgnoreCase("0")) {//verifica se o texto da calculadora é 0 e se for o texto vai ficar vazio como na linha abaixo("")
				textFieldDisplay.setText("");
				}
					textFieldDisplay.setText(textFieldDisplay.getText()+comando);
				
			}
		}
	}
	private boolean isOperador(char operador) {		//método que identifica se o texto é um operador
		return operador == '+' || operador == '-' || operador == '*' || operador== '/';		//para ser um operador precisa ser +, -, *,/
	}

	private double verificarExpressao(String expressao) {
		try {
			//remove os espaços em branco e os caracteres invalidos
			expressao = expressao.replaceAll("\\s+","");
			if(expressao.isEmpty()) {//verifica se a expressão é vazia e se for já retorna o 0
				return 0;
			}
			Pattern pattern=Pattern.compile("[+\\-*/]");// expressão regular não vista em sala. O Pattern vai buscar no texto os caracteres +,-,* e /
			Matcher matcher = pattern.matcher(expressao);//vai fazer o com que os caracteres encontrados pelo Pattern sejam transformados em expressão
			String[] partesExpressao = pattern.split(expressao);//esse string vai dividir a expressão em partes separadas pelos operadores
			
			double resultado = Double.parseDouble(partesExpressao[0]);//converte as partes em números e operadores 
			int i=1;
			
			//realiza as operações sequencialmente
			while(matcher.find()) {//vai percorrer as informações para conseguir fazer os calculos
				String operador = matcher.group();
				double valor =Double.parseDouble(partesExpressao[i++]);
				//as operações vão ser feitas de acordo com o operador encontrado
				switch(operador) {
				case"+":
					resultado+=valor;
					break;
				case"-":
					resultado-=valor;
					break;
				case"*":
					resultado*=valor;
					break;
				case"/":
					resultado/=valor;
					break;
					
				}
			}
			return resultado;
		}catch(NumberFormatException | ArithmeticException e) {//NumberFormatException vai transformar as strings que estão em formatos de texto valores numéricos e ArithmeticException serve para o java entender que é uma expressão aritmética
			return 0;
		}
	}
}
