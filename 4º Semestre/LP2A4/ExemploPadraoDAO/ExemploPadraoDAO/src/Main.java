import java.util.Date;

import modelo.*;
import modelo.repositorio.*;

public class Main
{
	public static void main(String[] args)
	{
		PessoaFisica pf1 = new PessoaFisica();
		
		pf1.setCep(99999999l);
		pf1.setCpf(99999999999l);
		pf1.setEndereco("Av. Brasil, 999, São Paulo - SP");
		pf1.setNascto(new Date(1990,1,1));
		pf1.setNome("José da Silva");
		pf1.setRenda(2500.75f);
		pf1.setTelefone("(99) 9999-9999");
		
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		
		pfDAO.criarPessoaFisica(pf1);
		
		if(pf1.getId() > 0)
		{
			System.out.println("Id da pessoa física cadastrada: " + pf1.getId());
		}
	}
}