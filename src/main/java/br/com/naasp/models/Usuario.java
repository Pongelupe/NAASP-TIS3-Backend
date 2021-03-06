package br.com.naasp.models;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.naasp.util.CryptographerHelper;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	private String senha;
	private String nome;

	private static class UsuarioKeys {
		public static final String SENHA = "senha";
		public static final String NOME = "nome";
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int id) {
		this.idUsuario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	@Deprecated
	public Usuario() {
	}

	public Usuario(JSONObject json) throws JSONException {
		if (json.has(UsuarioKeys.SENHA))
			senha = json.getString(UsuarioKeys.SENHA);

		if (json.has(UsuarioKeys.NOME))
			nome = json.getString(UsuarioKeys.NOME);
	}

	public void encriptData() {
		try {
			setSenha(CryptographerHelper.encode(senha));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nome=" + nome + "]";
	}

}
