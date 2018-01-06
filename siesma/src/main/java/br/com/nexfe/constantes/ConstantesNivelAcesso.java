package br.com.nexfe.constantes;

public enum ConstantesNivelAcesso {
	
	ADMINISTRATIVO(1, "Administrativo"),
	DOCENTE (2, "Docente"),
	ALUNO (3, "Aluno"),
	OUTROS (4, "Outros");
	
	private Integer chave;
	
	private String nome;
	
	private ConstantesNivelAcesso(int chave, String nome) {
		this.chave = chave;
		this.nome = nome;
	}

	public Integer getChave() {
		return chave;
	}

	public String getNome() {
		return nome;
	}

}
