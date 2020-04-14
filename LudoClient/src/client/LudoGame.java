package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class LudoGame extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackgroundGame;
	private JLabel lblBoard;
	private JLabel lblPlayer1;
	private JLabel lblPlayer2;
	private JLabel lblPlayer3;
	private JLabel lblPlayer4;
	private JLabel lblDiceBackPlayerBlue;
	private JLabel lblDiceBackPlayerGreen;
	private JLabel lblDiceBackPlayerYellow;
	private JLabel lblPawnRed1;
	private JLabel lblPawnRed2;
	private JLabel lblPawnRed3;
	private JLabel lblPawnRed4;
	private JLabel lblPawnYellow1;
	private JLabel lblPawnYellow2;
	private JLabel lblPawnYellow3;
	private JLabel lblPawnYellow4;
	private JLabel lblPawnBlue1;
	private JLabel lblPawnBlue2;
	private JLabel lblPawnBlue3;
	private JLabel lblPawnBlue4;
	private JLabel lblPawnGreen1;
	private JLabel lblPawnGreen2;
	private JLabel lblPawnGreen3;
	private JLabel lblPawnGreen4;
	private JLabel lblNamePlayerRed;
	private JLabel lblNamePlayerBlue;
	private JLabel lblNamePlayerGreen;
	private JLabel lblNamePlayerYellow;
	private JLabel lblDicePlayerBlue;
	private JLabel lblDicePlayerGreen;
	private JLabel lblDicePlayerYellow;
	private JLabel lblExit;
	private JLabel lblSettings;
	private JLabel lblDiceBackPlayerRed;
	private JLabel lblDicePlayerRed;
	private JLabel lblChatBack;
	private JLabel lblChatName;
	private JLabel lblDeleteChat;
	private JTextField textFieldChat;
	private JTextArea textAreaChat;
	private JScrollPane scrollPaneChat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LudoGame frame = new LudoGame();
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
	public LudoGame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LudoGame.class.getResource("/Resource/ludo1.png")));
		setTitle("Ludo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1645, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPawnRed1());
		contentPane.add(getLblPawnRed2());
		contentPane.add(getLblPawnRed3());
		contentPane.add(getLblPawnRed4());
		contentPane.add(getLblPawnYellow1());
		contentPane.add(getLblPawnYellow2());
		contentPane.add(getLblPawnYellow3());
		contentPane.add(getLblPawnYellow4());
		contentPane.add(getLblPawnBlue1());
		contentPane.add(getLblPawnBlue2());
		contentPane.add(getLblPawnBlue3());
		contentPane.add(getLblPawnBlue4());
		contentPane.add(getLblPawnGreen1());
		contentPane.add(getLblPawnGreen2());
		contentPane.add(getLblPawnGreen3());
		contentPane.add(getLblPawnGreen4());
		contentPane.add(getLblNamePlayerRed());
		contentPane.add(getLblNamePlayerBlue());
		contentPane.add(getLblNamePlayerGreen());
		contentPane.add(getLblNamePlayerYellow());
		contentPane.add(getLblBoard());
		contentPane.add(getLblPlayer1());
		contentPane.add(getLblPlayer2());
		contentPane.add(getLblPlayer3());
		contentPane.add(getLblPlayer4());
		contentPane.add(getLblDicePlayerRed());
		contentPane.add(getLblDicePlayerBlue());
		contentPane.add(getLblDicePlayerGreen());
		contentPane.add(getLblDicePlayerYellow());
		contentPane.add(getLblDiceBackPlayerBlue());
		contentPane.add(getLblDiceBackPlayerGreen());
		contentPane.add(getLblDiceBackPlayerYellow());
		contentPane.add(getLblDiceBackPlayerRed());
		contentPane.add(getLblExit());
		contentPane.add(getLblSettings());
		contentPane.add(getLblDeleteChat());
		contentPane.add(getTextFieldChat());
		contentPane.add(getScrollPaneChat());
		contentPane.add(getLblChatName());
		contentPane.add(getLblChatBack());
		contentPane.add(getLblBackgroundGame());
	}

	private JLabel getLblBackgroundGame() {
		if (lblBackgroundGame == null) {
			lblBackgroundGame = new JLabel("");
			lblBackgroundGame.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/backgroundGame.png")));
			lblBackgroundGame.setBounds(0, 0, 2400, 2214);
		}
		return lblBackgroundGame;
	}

	private JLabel getLblBoard() {
		if (lblBoard == null) {
			lblBoard = new JLabel("");
			lblBoard.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/board (3) (2).png")));
			lblBoard.setBounds(270, 40, 770, 769);
		}
		return lblBoard;
	}

	public JLabel getLblPlayer1() {
		if (lblPlayer1 == null) {
			lblPlayer1 = new JLabel("");
			lblPlayer1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
			lblPlayer1.setBounds(1064, 87, 220, 60);
		}
		return lblPlayer1;
	}

	public JLabel getLblPlayer2() {
		if (lblPlayer2 == null) {
			lblPlayer2 = new JLabel("");
			lblPlayer2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
			lblPlayer2.setBounds(22, 502, 220, 60);
		}
		return lblPlayer2;
	}

	public JLabel getLblPlayer3() {
		if (lblPlayer3 == null) {
			lblPlayer3 = new JLabel("");
			lblPlayer3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
			lblPlayer3.setBounds(1064, 502, 220, 60);
		}
		return lblPlayer3;
	}

	public JLabel getLblPlayer4() {
		if (lblPlayer4 == null) {
			lblPlayer4 = new JLabel("");
			lblPlayer4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
			lblPlayer4.setBounds(22, 92, 220, 60);
		}
		return lblPlayer4;
	}

	public JLabel getLblDiceBackPlayerBlue() {
		if (lblDiceBackPlayerBlue == null) {
			lblDiceBackPlayerBlue = new JLabel("");
			lblDiceBackPlayerBlue.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDiceDark.png")));
			lblDiceBackPlayerBlue.setBounds(55, 575, 150, 150);
		}
		return lblDiceBackPlayerBlue;
	}

	public JLabel getLblDiceBackPlayerGreen() {
		if (lblDiceBackPlayerGreen == null) {
			lblDiceBackPlayerGreen = new JLabel("");
			lblDiceBackPlayerGreen.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDiceDark.png")));
			lblDiceBackPlayerGreen.setBounds(1100, 575, 150, 150);
		}
		return lblDiceBackPlayerGreen;
	}

	public JLabel getLblDiceBackPlayerYellow() {
		if (lblDiceBackPlayerYellow == null) {
			lblDiceBackPlayerYellow = new JLabel("");
			lblDiceBackPlayerYellow.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDiceDark.png")));
			lblDiceBackPlayerYellow.setBounds(55, 160, 150, 150);
		}
		return lblDiceBackPlayerYellow;
	}

	private JLabel getLblPawnRed1() {
		if (lblPawnRed1 == null) {
			lblPawnRed1 = new JLabel("");
			lblPawnRed1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed1.setBounds(805, 85, 65, 92);
		}
		return lblPawnRed1;
	}

	private JLabel getLblPawnRed2() {
		if (lblPawnRed2 == null) {
			lblPawnRed2 = new JLabel("");
			lblPawnRed2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed2.setBounds(903, 85, 65, 92);
		}
		return lblPawnRed2;
	}

	private JLabel getLblPawnRed3() {
		if (lblPawnRed3 == null) {
			lblPawnRed3 = new JLabel("");
			lblPawnRed3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed3.setBounds(805, 173, 65, 92);
		}
		return lblPawnRed3;
	}

	private JLabel getLblPawnRed4() {
		if (lblPawnRed4 == null) {
			lblPawnRed4 = new JLabel("");
			lblPawnRed4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed4.setBounds(903, 173, 65, 92);
		}
		return lblPawnRed4;
	}

	private JLabel getLblPawnYellow1() {
		if (lblPawnYellow1 == null) {
			lblPawnYellow1 = new JLabel("");
			lblPawnYellow1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow1.setBounds(342, 85, 65, 92);
		}
		return lblPawnYellow1;
	}

	private JLabel getLblPawnYellow2() {
		if (lblPawnYellow2 == null) {
			lblPawnYellow2 = new JLabel("");
			lblPawnYellow2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow2.setBounds(440, 85, 65, 92);
		}
		return lblPawnYellow2;
	}

	private JLabel getLblPawnYellow3() {
		if (lblPawnYellow3 == null) {
			lblPawnYellow3 = new JLabel("");
			lblPawnYellow3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow3.setBounds(342, 173, 65, 92);
		}
		return lblPawnYellow3;
	}

	private JLabel getLblPawnYellow4() {
		if (lblPawnYellow4 == null) {
			lblPawnYellow4 = new JLabel("");
			lblPawnYellow4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow4.setBounds(440, 173, 65, 92);
		}
		return lblPawnYellow4;
	}

	private JLabel getLblPawnBlue1() {
		if (lblPawnBlue1 == null) {
			lblPawnBlue1 = new JLabel("");
			lblPawnBlue1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue1.setBounds(342, 550, 65, 92);
		}
		return lblPawnBlue1;
	}

	private JLabel getLblPawnBlue2() {
		if (lblPawnBlue2 == null) {
			lblPawnBlue2 = new JLabel("");
			lblPawnBlue2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue2.setBounds(440, 550, 65, 92);
		}
		return lblPawnBlue2;
	}

	private JLabel getLblPawnBlue3() {
		if (lblPawnBlue3 == null) {
			lblPawnBlue3 = new JLabel("");
			lblPawnBlue3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue3.setBounds(342, 635, 65, 92);
		}
		return lblPawnBlue3;
	}

	private JLabel getLblPawnBlue4() {
		if (lblPawnBlue4 == null) {
			lblPawnBlue4 = new JLabel("");
			lblPawnBlue4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue4.setBounds(440, 635, 65, 92);
		}
		return lblPawnBlue4;
	}

	private JLabel getLblPawnGreen1() {
		if (lblPawnGreen1 == null) {
			lblPawnGreen1 = new JLabel("");
			lblPawnGreen1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen1.setBounds(805, 550, 65, 92);
		}
		return lblPawnGreen1;
	}

	private JLabel getLblPawnGreen2() {
		if (lblPawnGreen2 == null) {
			lblPawnGreen2 = new JLabel("");
			lblPawnGreen2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen2.setBounds(903, 550, 65, 92);
		}
		return lblPawnGreen2;
	}

	private JLabel getLblPawnGreen3() {
		if (lblPawnGreen3 == null) {
			lblPawnGreen3 = new JLabel("");
			lblPawnGreen3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen3.setBounds(805, 635, 65, 92);
		}
		return lblPawnGreen3;
	}

	private JLabel getLblPawnGreen4() {
		if (lblPawnGreen4 == null) {
			lblPawnGreen4 = new JLabel("");
			lblPawnGreen4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen4.setBounds(903, 635, 65, 92);
		}
		return lblPawnGreen4;
	}

	public JLabel getLblNamePlayerRed() {
		if (lblNamePlayerRed == null) {
			lblNamePlayerRed = new JLabel("playerRed");
			lblNamePlayerRed.setForeground(new Color(255, 255, 0));
			lblNamePlayerRed.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayerRed.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayerRed.setBounds(1090, 104, 161, 29);
		}
		return lblNamePlayerRed;
	}

	public JLabel getLblNamePlayerBlue() {
		if (lblNamePlayerBlue == null) {
			lblNamePlayerBlue = new JLabel("playerBlue");
			lblNamePlayerBlue.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayerBlue.setForeground(Color.YELLOW);
			lblNamePlayerBlue.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayerBlue.setBounds(55, 516, 161, 29);
		}
		return lblNamePlayerBlue;
	}

	public JLabel getLblNamePlayerGreen() {
		if (lblNamePlayerGreen == null) {
			lblNamePlayerGreen = new JLabel("playerGreen");
			lblNamePlayerGreen.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayerGreen.setForeground(Color.YELLOW);
			lblNamePlayerGreen.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayerGreen.setBounds(1097, 518, 161, 29);
		}
		return lblNamePlayerGreen;
	}

	public JLabel getLblNamePlayerYellow() {
		if (lblNamePlayerYellow == null) {
			lblNamePlayerYellow = new JLabel("playerYellow");
			lblNamePlayerYellow.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayerYellow.setForeground(Color.YELLOW);
			lblNamePlayerYellow.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayerYellow.setBounds(55, 106, 161, 29);
		}
		return lblNamePlayerYellow;
	}

	private JLabel getLblDicePlayerBlue() {
		if (lblDicePlayerBlue == null) {
			lblDicePlayerBlue = new JLabel("");
			lblDicePlayerBlue.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayerBlue.setBounds(85, 605, 90, 90);
		}
		return lblDicePlayerBlue;
	}

	private JLabel getLblDicePlayerGreen() {
		if (lblDicePlayerGreen == null) {
			lblDicePlayerGreen = new JLabel("");
			lblDicePlayerGreen.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayerGreen.setBounds(1131, 605, 90, 90);
		}
		return lblDicePlayerGreen;
	}

	private JLabel getLblDicePlayerYellow() {
		if (lblDicePlayerYellow == null) {
			lblDicePlayerYellow = new JLabel("");
			lblDicePlayerYellow.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayerYellow.setBounds(85, 190, 90, 90);
		}
		return lblDicePlayerYellow;
	}

	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("");
			lblExit.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/exit (3).png")));
			lblExit.setBounds(1551, 40, 50, 50);
		}
		return lblExit;
	}

	private JLabel getLblSettings() {
		if (lblSettings == null) {
			lblSettings = new JLabel("");
			lblSettings.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/settings (1).png")));
			lblSettings.setBounds(1482, 40, 50, 50);
		}
		return lblSettings;
	}

	public JLabel getLblDiceBackPlayerRed() {
		if (lblDiceBackPlayerRed == null) {
			lblDiceBackPlayerRed = new JLabel("");
			lblDiceBackPlayerRed.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDiceDark.png")));
			lblDiceBackPlayerRed.setBounds(1100, 160, 150, 150);
		}
		return lblDiceBackPlayerRed;
	}

	private JLabel getLblDicePlayerRed() {
		if (lblDicePlayerRed == null) {
			lblDicePlayerRed = new JLabel("");
			lblDicePlayerRed.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayerRed.setBounds(1131, 190, 90, 90);
		}
		return lblDicePlayerRed;
	}

	private JLabel getLblChatBack() {
		if (lblChatBack == null) {
			lblChatBack = new JLabel("");
			lblChatBack.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/chatFinal.png")));
			lblChatBack.setBounds(1309, 204, 301, 513);
		}
		return lblChatBack;
	}

	private JLabel getLblChatName() {
		if (lblChatName == null) {
			lblChatName = new JLabel("");
			lblChatName.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/chatT.png")));
			lblChatName.setBounds(1414, 160, 91, 49);
		}
		return lblChatName;
	}

	private JLabel getLblDeleteChat() {
		if (lblDeleteChat == null) {
			lblDeleteChat = new JLabel("");
			lblDeleteChat.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/delete (2).png")));
			lblDeleteChat.setBounds(1568, 679, 25, 26);
		}
		return lblDeleteChat;
	}

	private JTextField getTextFieldChat() {
		if (textFieldChat == null) {
			textFieldChat = new JTextField();
			textFieldChat.setForeground(new Color(255, 102, 0));
			textFieldChat.setBackground(new Color(255, 255, 153));
			textFieldChat.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
			textFieldChat.setBounds(1332, 678, 224, 29);
			textFieldChat.setColumns(10);
		}
		return textFieldChat;
	}

	private JTextArea getTextAreaChat() {
		if (textAreaChat == null) {
			textAreaChat = new JTextArea();
			textAreaChat.setBackground(new Color(255, 255, 204));
			textAreaChat.setForeground(new Color(255, 102, 0));
			textAreaChat.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		}
		return textAreaChat;
	}

	private JScrollPane getScrollPaneChat() {
		if (scrollPaneChat == null) {
			scrollPaneChat = new JScrollPane();
			scrollPaneChat.setBounds(1328, 224, 263, 433);
			scrollPaneChat.setViewportView(getTextAreaChat());
		}
		return scrollPaneChat;
	}
}
