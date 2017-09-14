package br.com.naasp.models;

public class DadosParoquias {

	private String paroquiaBairro;
	private String descricaoAtividade;
	private String pastoralInserido;
	private String pastoralAcompanhado;
	private String atividadeOutrasInst;

	public String getParoquiaBairro() {
		return paroquiaBairro;
	}

	public void setParoquiaBairro(String paroquiaBairro) {
		this.paroquiaBairro = paroquiaBairro;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public String getPastoralInserido() {
		return pastoralInserido;
	}

	public void setPastoralInserido(String pastoralInserido) {
		this.pastoralInserido = pastoralInserido;
	}

	public String getPastoralAcompanhado() {
		return pastoralAcompanhado;
	}

	public void setPastoralAcompanhado(String pastoralAcompanhado) {
		this.pastoralAcompanhado = pastoralAcompanhado;
	}

	public String getAtividadeOutrasInst() {
		return atividadeOutrasInst;
	}

	public void setAtividadeOutrasInst(String atividadeOutrasInst) {
		this.atividadeOutrasInst = atividadeOutrasInst;
	}

	@Override
	public String toString() {
		return "DadosParoquias [paroquiaBairro=" + paroquiaBairro + ", descricaoAtividade=" + descricaoAtividade
				+ ", pastoralInserido=" + pastoralInserido + ", pastoralAcompanhado=" + pastoralAcompanhado
				+ ", atividadeOutrasInst=" + atividadeOutrasInst + "]";
	}

}
