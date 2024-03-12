package bean;

public class PontoSerMelhorado {

	private String id;
	private String pontoSerMelhorado;
	private String cor;
	
	public PontoSerMelhorado() {
		super();
	}
	
	public PontoSerMelhorado(String id, String pontoSerMelhorado, String cor) {
		super();
		
		this.id = id;
		this.pontoSerMelhorado = pontoSerMelhorado;
		this.cor = cor; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getpontoSerMelhorado() {
		return pontoSerMelhorado;
	}
	public void setpontoSerMelhorado(String pontoSerMelhorado) {
		this.pontoSerMelhorado = pontoSerMelhorado;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}
