package entities;

public class PessoaJuridica extends Contribuinte {

	private Integer numeroDeFuncionarios;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double impostoFinal() {
		double somaFinal = 0;

		if (getNumeroDeFuncionarios() < 10) {
			somaFinal += getRendaAnual() * 0.16;
		} else if (getNumeroDeFuncionarios() >= 10) {
			somaFinal += getRendaAnual() * 0.14;
		}

		return somaFinal;
	}

}
