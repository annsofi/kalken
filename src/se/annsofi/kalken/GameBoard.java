package se.annsofi.kalken;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import se.annsofi.kalken.GameBoard.Builder;
public class GameBoard {
	private final JButton btnHelp;
	private final JButton btnAbout;

	private final JLabel lblLevel;
	private final JLabel lblNrpoints;
	private final JLabel lblAnswer;
	private final JLabel lblSum;
	private JLabel lblBig;
	private JLabel lblProgress;
	private JLabel lblTrack;
	private JLabel lblBoard;
	private JLabel lblPoints;
	private JLabel lblKalken;

	private JTextArea txtSum;
	private JRadioButton chkHorse;
	private JRadioButton chkBike;
	private JRadioButton chkHuman;

	private Menu menu;
	private NumberPad numberPad;

	
	
	public JButton getBtnHelp() {
		return btnHelp;
	}

	public JButton getBtnAbout() {
		return btnAbout;
	}

	public JLabel getLblLevel() {
		return lblLevel;
	}

	public JLabel getLblNrpoints() {
		return lblNrpoints;
	}

	public JLabel getLblAnswer() {
		return lblAnswer;
	}

	public JLabel getLblSum() {
		return lblSum;
	}

	public JLabel getLblBig() {
		return lblBig;
	}

	public JLabel getLblProgress() {
		return lblProgress;
	}

	public JLabel getLblTrack() {
		return lblTrack;
	}

	public JLabel getLblBoard() {
		return lblBoard;
	}

	public JLabel getLblPoints() {
		return lblPoints;
	}

	public JLabel getLblKalken() {
		return lblKalken;
	}

	public JTextArea getTxtSum() {
		return txtSum;
	}

	public JRadioButton getChkHorse() {
		return chkHorse;
	}

	public JRadioButton getChkBike() {
		return chkBike;
	}

	public JRadioButton getChkHuman() {
		return chkHuman;
	}

	public Menu getMenu() {
		return menu;
	}

	public NumberPad getNumberPad() {
		return numberPad;
	}

	public static class Builder {
		private JButton btnHelp;
		private JButton btnAbout;
		private JLabel lblLevel;
		private JLabel lblNrpoints;
		private JLabel lblAnswer;
		private JLabel lblSum;
		private JLabel lblBig;
		private JLabel lblProgress;
		private JLabel lblTrack;
		private JLabel lblBoard;
		private JLabel lblPoints;
		private JLabel lblKalken;
		private JTextArea txtSum;
		private JRadioButton chkHorse;
		private JRadioButton chkBike;
		private JRadioButton chkHuman;
		private Menu menu;
		private NumberPad numberPad;

		
		public  Builder(){}
		public Builder btnHelp(JButton btnHelp) {
			this.btnHelp = btnHelp;
			return this;
		}

		public Builder btnAbout(JButton btnAbout) {
			this.btnAbout = btnAbout;
			return this;
		}

		public Builder lblLevel(JLabel lblLevel) {
			this.lblLevel = lblLevel;
			return this;
		}

		public Builder lblNrpoints(JLabel lblNrpoints) {
			this.lblNrpoints = lblNrpoints;
			return this;
		}

		public Builder lblAnswer(JLabel lblAnswer) {
			this.lblAnswer = lblAnswer;
			return this;
		}

		public Builder lblSum(JLabel lblSum) {
			this.lblSum = lblSum;
			return this;
		}

		public Builder lblBig(JLabel lblBig) {
			this.lblBig = lblBig;
			return this;
		}

		public Builder lblProgress(JLabel lblProgress) {
			this.lblProgress = lblProgress;
			return this;
		}

		public Builder lblTrack(JLabel lblTrack) {
			this.lblTrack = lblTrack;
			return this;
		}

		public Builder lblBoard(JLabel lblBoard) {
			this.lblBoard = lblBoard;
			return this;
		}

		public Builder lblPoints(JLabel lblPoints) {
			this.lblPoints = lblPoints;
			return this;
		}

		public Builder lblKalken(JLabel lblKalken) {
			this.lblKalken = lblKalken;
			return this;
		}

		public Builder txtSum(JTextArea txtSum) {
			this.txtSum = txtSum;
			return this;
		}

		public Builder chkHorse(JRadioButton chkHorse) {
			this.chkHorse = chkHorse;
			return this;
		}

		public Builder chkBike(JRadioButton chkBike) {
			this.chkBike = chkBike;
			return this;
		}

		public Builder chkHuman(JRadioButton chkHuman) {
			this.chkHuman = chkHuman;
			return this;
		}

		public Builder menu(Menu menu) {
			this.menu = menu;
			return this;
		}

		public Builder numberPad(NumberPad numberPad) {
			this.numberPad = numberPad;
			return this;
		}

		public GameBoard build() {
			return new GameBoard(this);
		}
	}

	private GameBoard(Builder builder) {
		this.btnHelp = builder.btnHelp;
		this.btnAbout = builder.btnAbout;
		this.lblLevel = builder.lblLevel;
		this.lblNrpoints = builder.lblNrpoints;
		this.lblAnswer = builder.lblAnswer;
		this.lblSum = builder.lblSum;
		this.lblBig = builder.lblBig;
		this.lblProgress = builder.lblProgress;
		this.lblTrack = builder.lblTrack;
		this.lblBoard = builder.lblBoard;
		this.lblPoints = builder.lblPoints;
		this.lblKalken = builder.lblKalken;
		this.txtSum = builder.txtSum;
		this.chkHorse = builder.chkHorse;
		this.chkBike = builder.chkBike;
		this.chkHuman = builder.chkHuman;
		this.menu = builder.menu;
		this.numberPad = builder.numberPad;
	}

}
