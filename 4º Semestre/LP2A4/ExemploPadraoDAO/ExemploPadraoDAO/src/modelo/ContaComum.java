package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ContaComum {

	protected final long numero;
	protected final Date abertura;
	protected Date fechamento;
	protected byte situacao;
	protected int senha;
	protected double saldo;
	
	protected ArrayList<Movimento> movimentos;
	protected ArrayList<Pessoa> titulares;
	
	public ContaComum(long numero, Date abertura)
	{
		this.numero = numero;
		this.abertura = abertura;
		this.situacao = 1;
		this.saldo = 0.0;
		this.movimentos = new ArrayList<Movimento>();
		this.titulares = new ArrayList<Pessoa>();
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
