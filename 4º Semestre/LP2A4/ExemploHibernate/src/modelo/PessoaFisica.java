package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoasfisicas")					//nomeia a tabela
@PrimaryKeyJoinColumn(name = "id")				//linka a tabela mae com a tabela filha com base na chave ID
public class PessoaFisica extends Pessoa	
{
	@Column(nullable = false)					//seta como NOT NULL
	private long cpf;
		
	@Temporal(TemporalType.DATE)				//seta o template utilizado para o DATE
	private Date nascto;
	
	public long getCpf()
	{
		return cpf;
	}
	
	public void setCpf(long cpf)
	{
		this.cpf = cpf;
	}
	
	public Date getNascto()
	{
		return nascto;
	}
	
	public void setNascto(Date nascto)
	{
		this.nascto = nascto;
	}
}
