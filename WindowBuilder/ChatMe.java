package WindowBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TP1DevWeb.AppClient;
import TP1DevWeb.ClientAppThread;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

public class ChatMe extends JFrame {

	public static JPanel contentPane;
	public static JTextField zonePseudo;
	public static JButton buttonConnecter;
	public static  JLabel lblNewLabel_1;
	public static JTextField zoneMessage;
	public static  JButton buttonEnvoyer;
	public static String messageclt;
	public static String pseudoclt ;
	public static JTextArea ecran =  new JTextArea();;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//AppClient clt1 = new AppClient();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatMe frame = new ChatMe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatMe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatMe.class.getResource("/Ressources/crab.png")));
		
		setBackground(new Color(0, 64, 128));
		setForeground(new Color(128, 64, 64));
		setTitle("ChatMe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 588);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 255));
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Pseudo:");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBackground(new Color(245, 245, 245));
		
		zonePseudo = new JTextField();
		zonePseudo.setColumns(10);
		
		JButton buttonConnecter = new JButton("Se connecter");
		 buttonConnecter.addActionListener(new ActionListener() 
         {
			public void actionPerformed(ActionEvent e) {
				  pseudoclt  = zonePseudo.getText();
			      buttonConnecter.setVisible(false);
			}
		});
		
		lblNewLabel_1 = new JLabel("Entrez votre message");
		lblNewLabel_1.setForeground(new Color(245, 245, 220));
		
		zoneMessage = new JTextField();
		zoneMessage.setHorizontalAlignment(SwingConstants.LEFT);
		zoneMessage.setColumns(10);
		
		buttonEnvoyer = new JButton("Envoyer");
		buttonEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messageclt = zoneMessage.getText();
				zoneMessage.setText("");
				try {
					AppClient.out.writeUTF(messageclt);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(messageclt);
			}
		});
		
		JButton buttonDeconnexion = new JButton("Se deconnecter");
		buttonDeconnexion.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) {
				  try {
					AppClient.out.writeUTF("byebye");
					zoneMessage.setVisible(false);
					buttonEnvoyer.setVisible(false);
					buttonDeconnexion.setVisible(false);
					lblNewLabel_1.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      buttonConnecter.setVisible(false);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(ecran, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
								.addContainerGap())
							.addComponent(zoneMessage, 416, 488, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(zonePseudo, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(buttonConnecter, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(buttonEnvoyer)
								.addContainerGap(417, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(362)
							.addComponent(buttonDeconnexion, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(10))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(zonePseudo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonConnecter)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zoneMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(buttonEnvoyer)
					.addGap(18)
					.addComponent(ecran, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(buttonDeconnexion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}

