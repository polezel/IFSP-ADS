package modelo;

public class PessoaJuridica extends Pessoa
{
	private long cnpj;
	protected String nomeFantasia;
	
	public long getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(long cnpj)
	{
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	

}
