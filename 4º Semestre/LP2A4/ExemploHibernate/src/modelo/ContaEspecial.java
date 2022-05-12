package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contasEspeciais")	
@PrimaryKeyJoinColumn (name = numero)
public class ContaEspecial extends ContaComum 
{
	private double limite;
	
	public ContaEspecial(long numero, Date abertura) {
		super(numero, abertura);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	
}
