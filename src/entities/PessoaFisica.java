package entities;

public class PessoaFisica extends Contribuinte {

	private Double gastosComSaude;

	public PessoaFisica() {
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double impostoFinal() {
		double somaFinal = 0;
		
		if (getRendaAnual() < 20000) {
			somaFinal += getRendaAnual() * 0.15;
		} else if (getRendaAnual() >= 20000) {
			somaFinal += getRendaAnual() * 0.25;
		}
		
		if (getGastosComSaude() != 0) {
			somaFinal -= getGastosComSaude() * 0.5;
		}
			return somaFinal;
	}

}
