package br.com.naasp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idPaciente;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosGerais dadosGerais;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosPessoal dadosPessoais;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosFamiliar dadosFamiliar;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosMorada dadosMorada;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosSaude dadosSaude;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosParoquias dadosParoquia;

	private static class PacienteKeys {

		private static final String DADOS_GERAIS = "dadosGerais";
		private static final String DADOS_PESSOAIS = "dadosPessoais";
		private static final String DADOS_FAMILIARES = "dadosFamiliares";
		private static final String DADOS_MORADIA = "dadosMoradia";
		private static final String DADOS_SAUDE = "dadosSaude";
		private static final String DADOS_PAROQUIA = "dadosParoquia";
	}

	public int getId() {
		return idPaciente;
	}

	public DadosPessoal getDadosPessoais() {
		return this.dadosPessoais;
	}

	public DadosMorada getDadosMorada() {
		return this.dadosMorada;
	}

	public DadosSaude getDadosSaude() {
		return this.dadosSaude;
	}

	public DadosParoquias getDadosParoquia() {
		return this.dadosParoquia;
	}

	private void setDadosGerais(JSONObject jsonObject) throws JSONException {
		this.dadosGerais = new DadosGerais(jsonObject);
	}

	private void setDadosPessoais(JSONObject jsonObject) throws JSONException {
		this.dadosPessoais = new DadosPessoal(jsonObject);
	}

	private void setDadosMorada(JSONObject jsonObject) throws JSONException {
		this.dadosMorada = new DadosMorada(jsonObject);
	}

	private void setDadosFamilar(JSONObject jsonObject) throws JSONException {
		this.dadosFamiliar = new DadosFamiliar(jsonObject);
	}

	private void setDadosSaude(JSONObject jsonObject) throws JSONException {
		this.dadosSaude = new DadosSaude(jsonObject);
	}

	private void setDadosParoquia(JSONObject jsonObject) throws JSONException {
		this.dadosParoquia = new DadosParoquias(jsonObject);
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", dadosGerais=" + dadosGerais + ", dadosPessoais="
				+ dadosPessoais + ", dadosFamiliar=" + dadosFamiliar + ", dadosMorada=" + dadosMorada + ", dadosSaude="
				+ dadosSaude + ", dadosParoquia=" + dadosParoquia + "]";
	}

	public Paciente(DadosGerais dadosGerais, DadosPessoal dadosPessoais, DadosFamiliar dadosFamiliar,
			DadosMorada dadosMorada, DadosSaude dadosSaude, DadosParoquias dadosParoquia) {
		super();
		this.dadosGerais = dadosGerais;
		this.dadosPessoais = dadosPessoais;
		this.dadosFamiliar = dadosFamiliar;
		this.dadosMorada = dadosMorada;
		this.dadosSaude = dadosSaude;
		this.dadosParoquia = dadosParoquia;
	}

	public Paciente() {
	}

	public Paciente(JSONObject json) throws JSONException {

		if (json.has(PacienteKeys.DADOS_GERAIS))
			setDadosGerais(json.getJSONObject(PacienteKeys.DADOS_GERAIS));

		if (json.has(PacienteKeys.DADOS_PESSOAIS))
			setDadosPessoais(json.getJSONObject(PacienteKeys.DADOS_PESSOAIS));

		// if (json.has(PacienteKeys.DADOS_FAMILIARES))
		// setDadosFamiliares(json.getJSONArray(PacienteKeys.DADOS_FAMILIARES));
		if (json.has(PacienteKeys.DADOS_FAMILIARES))
			setDadosFamilar(json.getJSONObject(PacienteKeys.DADOS_FAMILIARES));

		if (json.has(PacienteKeys.DADOS_MORADIA))
			setDadosMorada(json.getJSONObject(PacienteKeys.DADOS_MORADIA));

		if (json.has(PacienteKeys.DADOS_SAUDE))
			setDadosSaude(json.getJSONObject(PacienteKeys.DADOS_SAUDE));

		if (json.has(PacienteKeys.DADOS_PAROQUIA))
			setDadosParoquia(json.getJSONObject(PacienteKeys.DADOS_PAROQUIA));
	}

	// TODO
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		return json;
	}

	public static class PacienteBuilder {

		private DadosGerais dadosGerais;
		private DadosPessoal dadosPessoais;
		private DadosFamiliar dadosFamiliar;
		private DadosMorada dadosMorada;
		private DadosSaude dadosSaude;
		private DadosParoquias dadosParoquias;

		public PacienteBuilder addDadosGerais(DadosGerais dadosGerais) {
			this.dadosGerais = dadosGerais;
			return this;
		}

		public PacienteBuilder addDadosPessoais(DadosPessoal dadosPessoais) {
			this.dadosPessoais = dadosPessoais;
			return this;
		}

		public PacienteBuilder addDadosFamiliar(DadosFamiliar dadosFamiliar) {
			this.dadosFamiliar = dadosFamiliar;
			return this;
		}

		public PacienteBuilder addDadosMorada(DadosMorada dadosMorada) {
			this.dadosMorada = dadosMorada;
			return this;
		}

		public PacienteBuilder addDadosSaude(DadosSaude dadosSaude) {
			this.dadosSaude = dadosSaude;
			return this;
		}

		public PacienteBuilder addDadosParoquias(DadosParoquias dadosParoquias) {
			this.dadosParoquias = dadosParoquias;
			return this;
		}

		public Paciente build() {
			return new Paciente(dadosGerais, dadosPessoais, dadosFamiliar, dadosMorada, dadosSaude, dadosParoquias);
		}

	}

}
