package br.fiap.aluno;

public class Aluno {
	
	private int rm;
	private double media;
	
	public Aluno(int rm, double media) {
		super();
		this.rm = rm;
		this.media = media;
	}
	
	public int getRm() {
		return rm;
	}
	public void setRm(int rm) {
		this.rm = rm;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	
}
