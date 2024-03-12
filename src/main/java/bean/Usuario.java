package bean;

public class Usuario {

	private String usuarioId;
	private String email;
	private String senha;
	private Integer validaUsuario;
	
	public Usuario(String usuarioId, String email, String senha, Integer validaUsuario) {
		super();
		this.usuarioId = usuarioId;
		this.email = email;
		this.senha = senha;
		this.validaUsuario = validaUsuario;
	}
	
	public Usuario() {
		super();
	}

	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getValidaUsuario() {
		return validaUsuario;
	}
	public void setValidaUsuario(Integer validaUsuario) {
		this.validaUsuario = validaUsuario;
	}
	
	
	
}
