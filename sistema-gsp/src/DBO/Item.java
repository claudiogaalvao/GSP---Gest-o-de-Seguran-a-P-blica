package DBO;

public class Item {
	
	private String titulo;
	private String descricao;
	private String quantidade;
	private String dtEntrada;
	private String dtSaida;
	private String tipo;
	private String nrSerie;
	
	public Item(String titulo, String quantidade, String dtEntrada) {
		this.titulo = titulo;
		this.quantidade = quantidade;
		this.dtEntrada = dtEntrada;
	}
	
	public Item(String titulo, String descricao, String quantidade, String dtEntrada, String dtSaida, String tipo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
	}
	
	public Item(String titulo, String descricao, String quantidade, String dtEntrada, String dtSaida, String tipo, String nrSerie) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.nrSerie = nrSerie;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}
	public String getNrSerie() {
		return nrSerie;
	}
	public void setNrSerie(String nrSerie) {
		this.nrSerie = nrSerie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
