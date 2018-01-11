package br.com.nexfe.constantes;

public enum ConstantesExclusao {
	
	EXCLUIDO("S"),
	NAO_EXCLUIDO ("N");
	
	private String nome;
	
	private ConstantesExclusao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
