package bean;

public class PontoPositivo {

	private String id;
	private String pontoPositivo;
	private String cor;
	
	public PontoPositivo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PontoPositivo(String id, String pontoPositivo, String cor) {
		super();
		this.id = id;
		this.pontoPositivo = pontoPositivo;
		this.cor = cor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPontoPositivo() {
		return pontoPositivo;
	}
	public void setPontoPositivo(String pontoPositivo) {
		this.pontoPositivo = pontoPositivo;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}



}
