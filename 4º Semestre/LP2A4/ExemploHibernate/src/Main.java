import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityTransaction;

import modelo.ContaComum;
import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;
import modelo.repositorio.Repositorio;

public class Main
{	
	public static void main(String[] args)
	{
		PessoaFisicaRepositorio repPF =
			new PessoaFisicaRepositorio();
		
		Repositorio<ContaComum> repCC =
			new Repositorio<ContaComum>();
		
		/* Exemplo de inser��o */
		
		PessoaFisica pf1 = new PessoaFisica();
		pf1.setCep(99999999l);
		pf1.setCpf(99999999999l);
		pf1.setEndereco("Av. Brasil, 999, Sao Paulo - SP");
		pf1.setNascto(new Date(1980-1900,0,1));
		pf1.setNome("Joao da Silva");
		pf1.setRenda(2500.5f);
		pf1.setSituacao((byte)1);
		pf1.setTelefone("(99) 9999-9999");
		
		ContaComum cc1 = ContaComum.abrirConta();
		cc1.setSenha(123456);
		cc1.setSaldo(1000.0);
		
		pf1.getContas().add(cc1);
		
		repCC.criar(cc1);
		repPF.criar(pf1);
		
		/* Exemplo de atualiza��o */
		
		PessoaFisica pf =
			repPF.recuperarPessoaFisicaPorId(2);
		
		if(pf != null)
		{
			SimpleDateFormat df =
				new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("*** ANTES DA ATUALIZA��O ***");
			System.out.println(pf.getId());
			System.out.println(pf.getNome());
			System.out.println(df.format(pf.getNascto()));
			
			pf.setNascto(new Date(1975-1900,3,28));
			
			repPF.atualizar(pf);
			
			System.out.println("*** DEPOIS DA ATUALIZA��O ***");
			System.out.println(pf.getId());
			System.out.println(pf.getNome());
			System.out.println(df.format(pf.getNascto()));
		}
		
		/* Exemplo de exclus�o */
		/*
		PessoaFisica pf =
			repPF.recuperarPessoaFisicaPorId(2);
		
		if(pf != null)
		{
			repPF.excluir(pf);
		}
		*/
		
		/* Exemplos de recupera��o */
		
		Collection<PessoaFisica> lista =
				repPF.recuperarTodasPessoasFisicas();
		
		lista.forEach(
			pfr -> System.out.println(pfr.getNome()));
	}

}