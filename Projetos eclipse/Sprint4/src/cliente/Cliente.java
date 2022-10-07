package cliente;

public class Cliente {
	private int cpf;
	private int numero;
	private double saldo;
	
	public Cliente(int cpf, int numero, double saldo) {
		super();
		this.cpf = cpf;
		this.numero = numero;
		this.saldo = saldo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass()))
			return (((Cliente) obj).getNumero() == this.getNumero());
		else return false;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", numero=" + numero + ", saldo=" + saldo + "]";
	}
}
