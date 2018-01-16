package br.com.nexfe.constantes;

public enum ConstantesStatus {
	
	SEM_PREVISAO("Sem previsão"), 
	AGUARDANDO_PAGAMENTO("Aguardando pagamento"), 
	PAGO_EM_DIA("Pago em dia"),
	PAGO_COM_ATRASO("Pago com atraso"),
	ATIVO("Ativo"),
	INATIVO("Inativo");

	private String nome;

	private ConstantesStatus(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
