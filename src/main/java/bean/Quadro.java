package bean;

public class Quadro {
	private String quadroId;
	private String quadro;

	public Quadro() {
		super();
	}
	
	public Quadro(String quadro, String quadroId) {
		super();
		this.quadro = quadro;
		this.quadroId= quadroId;
	}
	
	public String getQuadro() {
		return quadro;
	}

	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}

	public String getQuadroId() {
		return quadroId;
	}

	public void setQuadroId(String quadroId) {
		this.quadroId = quadroId;
	}
	
	
}
