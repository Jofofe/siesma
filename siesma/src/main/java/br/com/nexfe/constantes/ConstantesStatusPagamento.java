package br.com.nexfe.constantes;

public enum ConstantesStatusPagamento {
	
	SEM_PREVISAO("Sem previsão"), 
	AGUARDANDO_PAGAMENTO("Aguardando pagamento"), 
	PAGO_EM_DIA("Pago em dia"),
	PAGO_COM_ATRASO("Pago com atraso");

	private String nome;

	private ConstantesStatusPagamento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
