
public class Empresa {

	String nome;
	double carga;
	String destino;
	String cnpj = "";

	public Empresa(String nome, double carga, String destino, String cnpj) {

		this.nome = nome;
		this.carga = carga;
		this.destino = destino;
		this.cnpj = cnpj;

	}

	public Empresa(String cnpj) {

		this.cnpj = cnpj;

	}

	public Empresa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public boolean equals(Object obj) {

		Empresa e = (Empresa) obj;

		if (e.getCnpj().equalsIgnoreCase(getCnpj())) {

			return true;

		}

		return false;

	}

	@Override
	public String toString() {
		
		return "CNPJ: " + cnpj + "\nNome da empresa: " + nome + "\nDestino: " + destino + "\nTotal da carga: " + carga
				+ " Kg";
	}

}
