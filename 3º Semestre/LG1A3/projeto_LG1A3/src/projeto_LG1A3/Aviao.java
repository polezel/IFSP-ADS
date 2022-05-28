package projeto_LG1A3;

public class Aviao extends Aeronave {

	//TODO verificiar a possibilidade de utilizar as variaveis fileira e assento
	
	public Passageiro[][] lugares;
	private int fileira;
	private int assento;

	
	public Aviao(String modelo, Passageiro[][] lugares, int fileira, int assento) {
		super(modelo);
		this.lugares =  new Passageiro[this.getFileira()][this.getAssento()];  
		this.fileira = fileira;
		this.assento = assento;
		
	}
	
	//TODO testar
	public Passageiro[][] getPassageiro() {
		return lugares;
	}

	//TODO testar
	public void setPassageiro() {
		
	}

	public int getFileira() {
		return fileira;
	}

	public int getAssento() {
		return assento;
	}
	
	
}
