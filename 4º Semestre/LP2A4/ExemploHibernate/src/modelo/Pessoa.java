package modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity															//criacao automatica da tabela dentro do banco de dados
@Table(name = "pessoas")										//nomeia a tabela
@Inheritance(strategy = InheritanceType.JOINED)					//torna a tabela uma heranca e abre a configuracao para as tabelas das classes filhas
public abstract class Pessoa
{
	@Id															//transforma em chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(length = 255, nullable = false)						//faz com que a coluna nome seja criada como NOT NULL e com o máximo de 255 caracteres 
	protected String nome;
	
	@Column(length = 255)										//faz com que a coluna endereco seja criada com o m�ximo de 255 caracteres 
	protected String endereco;
	
	protected long cep;
	
	@Column(length = 19)
	protected String telefone;
	
	protected float renda;
	
	protected byte situacao;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	//ManyToMany === seta como n->n		
	//cascade === configura o vinculo dos dados interligados
	//fetch === traz ou nao todos atributos correlatos na colecao (nesse caso nao)
	protected Collection<ContaComum> contas;
	//Collection === Arraylist generico
	
	public Pessoa()
	{
		this.situacao = 1;
		this.contas = new ArrayList<ContaComum>();
	}
	
	/* GETTERS AND SETTERS */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public byte getSituacao() {
		return situacao;
	}

	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}

	public Collection<ContaComum> getContas() {
		return contas;
	}

	public void setContas(Collection<ContaComum> contas) {
		this.contas = contas;
	}
}