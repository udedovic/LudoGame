package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;

public class LudoMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField textName;
	private JLabel lblBackground;
	private JLabel lblColor;
	private static JLabel lblPawnBlue;
	private static JLabel lblPawnRed;
	private static JLabel lblPawnGreen;
	private static JLabel lblPawnYellow;
	private JLabel lblEdge;
	private JLabel lblPlay;
	private JLabel lblServer;
	private JLabel lblSetings;
	private JLabel lblSetingsBackground;
	private JLabel lblServerBackground;

	private int selectedColor;
	
	
	
	public int getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(int selectedColor) {
		this.selectedColor = selectedColor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LudoMain frame = new LudoMain();
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
	public LudoMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LudoMain.class.getResource("/Resource/ludo1.png")));
		setTitle("Ludo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 153, 51), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getTextName());
		contentPane.add(getLblColor());
		contentPane.add(getLblPawnBlue());
		contentPane.add(getLblPawnRed());
		contentPane.add(getLblPawnGreen());
		contentPane.add(getLblPawnYellow());
		contentPane.add(getLblEdge());
		contentPane.add(getLblPlay());
		contentPane.add(getLblServer());
		contentPane.add(getLblSetings());
		contentPane.add(getLblSetingsBackground());
		contentPane.add(getLblServerBackground());
		contentPane.add(getLblBackground());
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblName.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/name.png")));
			lblName.setBounds(147, 13, 144, 66);
		}
		return lblName;
	}
	private JTextField getTextName() {
		if (textName == null) {
			textName = new JTextField();
			textName.setBackground(new Color(255, 255, 153));
			textName.setHorizontalAlignment(SwingConstants.CENTER);
			textName.setForeground(new Color(255, 102, 51));
			textName.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			textName.setBounds(121, 81, 196, 35);
			textName.setColumns(10);
		}
		return textName;
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/background.jpg")));
			lblBackground.setBounds(0, 0, 450, 558);
		}
		return lblBackground;
	}
	private JLabel getLblColor() {
		if (lblColor == null) {
			lblColor = new JLabel("");
			lblColor.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/color.png")));
			lblColor.setBounds(147, 140, 157, 67);
		}
		return lblColor;
	}
	public JLabel getLblPawnBlue() {
		if (lblPawnBlue == null) {
			lblPawnBlue = new JLabel("");
			lblPawnBlue.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					selectedColor = CommandC.BLUE;
				
					ClientExecute.setSendingCode(CommandC.SEND_COLOR);
				}
			});
			lblPawnBlue.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/pawnBlue.png")));
			lblPawnBlue.setBounds(124, 181, 100, 141);
		}
		return lblPawnBlue;
	}
	public JLabel getLblPawnRed() {
		if (lblPawnRed == null) {
			lblPawnRed = new JLabel("");
			lblPawnRed.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					selectedColor = CommandC.RED;
					
					ClientExecute.setSendingCode(CommandC.SEND_COLOR);
					
				}
			});
			lblPawnRed.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/pawnRed.png")));
			lblPawnRed.setBounds(19, 181, 100, 141);
		}
		return lblPawnRed;
	}
	public JLabel getLblPawnGreen() {
		if (lblPawnGreen == null) {
			lblPawnGreen = new JLabel("");
			lblPawnGreen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					selectedColor = CommandC.GREEN;
					
					ClientExecute.setSendingCode(CommandC.SEND_COLOR);
					
				}
			});
			lblPawnGreen.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/pawnGreen.png")));
			lblPawnGreen.setBounds(225, 181, 100, 141);
		}
		return lblPawnGreen;
	}
	public JLabel getLblPawnYellow() {
		if (lblPawnYellow == null) {
			lblPawnYellow = new JLabel("");
			lblPawnYellow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					selectedColor = CommandC.YELLOW;
					
					ClientExecute.setSendingCode(CommandC.SEND_COLOR);
					
				}
			});
			lblPawnYellow.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/pawnYellow.png")));
			lblPawnYellow.setBounds(332, 181, 100, 141);
		}
		return lblPawnYellow;
	}
	private JLabel getLblEdge() {
		if (lblEdge == null) {
			lblEdge = new JLabel("");
			lblEdge.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/edgeFinal.png")));
			lblEdge.setBounds(100, 64, 235, 75);
		}
		return lblEdge;
	}
	private JLabel getLblPlay() {
		if (lblPlay == null) {
			lblPlay = new JLabel("");
			lblPlay.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(textName == null || textName.equals("")) {
						JOptionPane.showMessageDialog(LudoMain.this, "Please enter name", "error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if(RunExecutes.isColorIsSelected() == false) {
						JOptionPane.showMessageDialog(LudoMain.this, "Please select color", "error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Client.game.getPlayerYou().setName(textName.getText());

					ClientExecute.setSendingCode(CommandC.PLAY);

				}
			});
			lblPlay.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/play1.png")));
			lblPlay.setBounds(147, 335, 173, 83);
		}
		return lblPlay;
	}
	private JLabel getLblServer() {
		if (lblServer == null) {
			lblServer = new JLabel("");
			lblServer.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/server.png")));
			lblServer.setBounds(255, 458, 131, 54);
		}
		return lblServer;
	}
	private JLabel getLblSetings() {
		if (lblSetings == null) {
			lblSetings = new JLabel("");
			lblSetings.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/settingsFinal.png")));
			lblSetings.setBounds(46, 458, 160, 53);
		}
		return lblSetings;
	}
	private JLabel getLblSetingsBackground() {
		if (lblSetingsBackground == null) {
			lblSetingsBackground = new JLabel("");
			lblSetingsBackground.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/setingsBackFinal.png")));
			lblSetingsBackground.setBounds(36, 447, 170, 65);
		}
		return lblSetingsBackground;
	}
	private JLabel getLblServerBackground() {
		if (lblServerBackground == null) {
			lblServerBackground = new JLabel("");
			lblServerBackground.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/setingsBackFinal.png")));
			lblServerBackground.setBounds(232, 447, 170, 65);
		}
		return lblServerBackground;
	}
}
