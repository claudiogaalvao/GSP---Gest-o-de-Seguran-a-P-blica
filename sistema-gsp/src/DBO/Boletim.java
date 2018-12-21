package DBO;

public class Boletim {
	
	private String nome;
	private String idade;
	private String sexo;
	private String logradouro;
	private String hrDenuncia;
	private String instrucao;
	private String crime;
	
	public Boletim(String nome, String idade, String sexo, String logradouro, String hrDenuncia, String instrucao, String crime) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.hrDenuncia = hrDenuncia;
		this.instrucao = instrucao;
		this.crime = crime;
	}
	
	public Boletim() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getHrDenuncia() {
		return hrDenuncia;
	}
	public void setHrDenuncia(String hrDenuncia) {
		this.hrDenuncia = hrDenuncia;
	}
	public String getInstrucao() {
		return instrucao;
	}
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	
	

}
