package se.annsofi.kalken;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NumberPad {
	private List<JButton> numberButtons;
	private JLabel lblKalken;

	
	
	public List<JButton> getNumberButtons() {
		return numberButtons;
	}

	public JLabel getLblKalken() {
		return lblKalken;
	}

	public static class Builder {
		private List<JButton> numberButtons;
		private JLabel lblKalken;

		public Builder numberButtons(List<JButton> numberButtons) {
			this.numberButtons = numberButtons;
			return this;
		}

		public Builder lblKalken(JLabel lblKalken) {
			this.lblKalken = lblKalken;
			return this;
		}

		public NumberPad build() {
			return new NumberPad(this);
		}
	}

	private NumberPad(Builder builder) {
		this.numberButtons = builder.numberButtons;
		this.lblKalken = builder.lblKalken;
	}
}
