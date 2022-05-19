package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoasjuridicas")								//nomeia a tabela
@PrimaryKeyJoinColumn(name = "id")								//linka a tabela mae com a tabela filha com base na chave ID
public class PessoaJuridica extends Pessoa
{
	@Column(nullable = false)									//seta como NOT NULL
	private long cnpj;
	
	@Column(length = 255, name = "nome_fantasia")				//seta o maximo de char para a coluna e cria um nome pesonalizado
	private String nomeFantasia;
	
	public long getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(long cnpj)
	{
		this.cnpj = cnpj;
	}
	
	public String getNomeFantasia()
	{
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}
}
