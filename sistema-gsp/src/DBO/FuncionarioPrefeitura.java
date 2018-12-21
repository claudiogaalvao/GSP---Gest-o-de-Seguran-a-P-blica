package DBO;

public class FuncionarioPrefeitura {
	
	private String nome;
	private String matricula;
	private String cargo;
	
	public FuncionarioPrefeitura(String nome, String matricula, String cargo) {
		this.nome = nome;
		this.matricula = matricula;
		this.cargo = cargo;
	}
	
	public FuncionarioPrefeitura() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
