package se.annsofi.kalken;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
	private JMenuBar mnuBar;
	private JMenu mnuIcon, mnuFile;

	private ImageIcon imgHuman, imgBike, imgHorse;
	private JMenuItem itmExit, itmRestart;

	private Menu(Builder builder) {
		this.mnuBar = builder.mnuBar;
		this.mnuIcon = builder.mnuIcon;
		this.mnuFile = builder.mnuFile;
		this.imgHuman = builder.imgHuman;
		this.imgBike = builder.imgBike;
		this.imgHorse = builder.imgHorse;
		this.itmExit = builder.itmExit;
		this.itmRestart = builder.itmRestart;
	}
	
	public JMenuBar getMnuBar() {
		return mnuBar;
	}

	public JMenu getMnuIcon() {
		return mnuIcon;
	}

	public JMenu getMnuFile() {
		return mnuFile;
	}

	public ImageIcon getImgHuman() {
		return imgHuman;
	}

	public ImageIcon getImgBike() {
		return imgBike;
	}

	public ImageIcon getImgHorse() {
		return imgHorse;
	}

	public JMenuItem getItmExit() {
		return itmExit;
	}

	public JMenuItem getItmRestart() {
		return itmRestart;
	}

	public static class Builder {
		private JMenuBar mnuBar;
		private JMenu mnuIcon;
		private JMenu mnuFile;
		private ImageIcon imgHuman;
		private ImageIcon imgBike;
		private ImageIcon imgHorse;
		private JMenuItem itmExit;
		private JMenuItem itmRestart;

		public Builder mnuBar(JMenuBar mnuBar) {
			this.mnuBar = mnuBar;
			return this;
		}

		public Builder mnuIcon(JMenu mnuIcon) {
			this.mnuIcon = mnuIcon;
			return this;
		}

		public Builder mnuFile(JMenu mnuFile) {
			this.mnuFile = mnuFile;
			return this;
		}

		public Builder imgHuman(ImageIcon imgHuman) {
			this.imgHuman = imgHuman;
			return this;
		}

		public Builder imgBike(ImageIcon imgBike) {
			this.imgBike = imgBike;
			return this;
		}

		public Builder imgHorse(ImageIcon imgHorse) {
			this.imgHorse = imgHorse;
			return this;
		}

		public Builder itmExit(JMenuItem itmExit) {
			this.itmExit = itmExit;
			return this;
		}

		public Builder itmRestart(JMenuItem itmRestart) {
			this.itmRestart = itmRestart;
			return this;
		}

		public Menu build() {
			return new Menu(this);
		}
	}

}
