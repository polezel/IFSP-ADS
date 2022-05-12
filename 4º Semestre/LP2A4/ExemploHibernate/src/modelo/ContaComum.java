package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;


@Entity 
@Table(name = "contasComums")								//nomeia a tabela
@Inheritance(strategy = InheritanceType.JOINED)				//torna a tabela uma heranca e abre a configuracao para as tabelas das classes filhas
public class ContaComum {

	@Id														//seta como ID ou PK do banco
	protected long numero;
	
	@Column(name = "data_abertura", nullable = false)		//seta o nome e torna NOT NULL
	@Temporal(TemporalType.TIMESTAMP)						//comfigura o date como um timestamp
	protected Date abertura;
	
	@Column(name = "data_abertura", nullable = false)		//seta o nome e torna NOT NULL
	@Temporal(TemporalType.TIMESTAMP)						//comfigura o date como um timestamp
	
	protected Date fechamento;
	protected byte situacao;
	protected int senha;	
	protected double saldo;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)				//ao apagar a conta o REMOVE apagas todos seus movimentos vinculados
	protected Collection<Movimento> movimentos;
	
	
	public ContaComum()
	{
		this.situacao = 1;
		this.saldo = 0.0;
		this.movimentos = new Collection<Movimento>();
	}
	
	public static ContaComum abrirConta() 
	{	
		long numero = gerarNumeroConta();
		ContaComum cc = new ContaComum(numero, new Date());
			
		return cc;
	}
	

	private static long gerarNumeroConta() 
	{
		Random rd = new Random();
		long numero = rd.nextLong();
		
		if(numero<-1){
			numero = (-1)*(numero+1);
		}else if(numero == -1){
			numero = 1;
		}else if(numero ==0) {
			numero = 1;
		}	
		return numero;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	
	public Collection<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(Collection<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Collection<Pessoa> getTitulares() {
		return titulares;
	}

	public void setTitulares(Collection<Pessoa> titulares) {
		this.titulares = titulares;
	}

	

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	public byte getSituacao() {
		return situacao;
	}

	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getNumero() {
		return numero;
	}

	public Date getAbertura() {
		return abertura;
	}
	
	
}
