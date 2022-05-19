package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contaspoupancas")
@PrimaryKeyJoinColumn(name = "numero")
public class ContaPoupanca extends ContaComum
{
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date aniversario;

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
}
