package DBO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {
	
	private String nome;
	private String sobrenome;
	private int matricula;
	private String cargo;
	private String senha;
	private String flAtivo;
	private String dtSolic;
	private Escala escala;
	
	public Funcionario(String nome, String sobrenome, int matricula, String cargo, String senha, String flAtivo, String dtSolic, Escala escala) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.matricula = matricula;
		this.cargo = cargo;
		this.senha = senha;
		this.flAtivo = flAtivo;
		this.dtSolic = dtSolic;
		this.escala = escala;
	}
	
	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public void setDtSolic(String dtSolic) {
		this.dtSolic = dtSolic;
	}

	public String getDtSolic() {
		return dtSolic;
	}

	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(String flAprovado) {
		this.flAtivo = flAprovado;
	}

	

}
