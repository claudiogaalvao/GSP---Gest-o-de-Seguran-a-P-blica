package DBO;

import java.util.List;

public class Escala {
	
	private String diasDaSemana;
	private String hrInicio;
	private String hrFim;
	
	public Escala() {
		this.diasDaSemana = "SEG,QUA,SEX";
		this.hrInicio = "16:00";
		this.hrFim = "23:00";
	}

	public String getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(String diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
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
