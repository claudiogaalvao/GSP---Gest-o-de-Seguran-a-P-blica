package DBO;

public class Evento {
	
	private String nomeEvento;
	private String dataInicio;
	private String dataFim;
	private String hrInicio;
	private String hrFim;
	
	public Evento() {
		
	}
	
	public Evento(String nomeEvento, String dataInicio, String dataFim, String hrInicio, String hrFim) {
		this.nomeEvento = nomeEvento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.hrInicio = hrInicio;
		this.hrFim = hrFim;
	}
	
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getHrInicio() {
		return hrInicio;
	}
	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}
	public String getHrFim() {
		return hrFim;
	}
	public void setHrFim(String hrFim) {
		this.hrFim = hrFim;
	}
	

}
