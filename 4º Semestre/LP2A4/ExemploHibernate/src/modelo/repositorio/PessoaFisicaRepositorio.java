package modelo.repositorio;

import java.util.Collection;

import modelo.PessoaFisica;

public class PessoaFisicaRepositorio extends Repositorio<PessoaFisica>{
	
	public PessoaFisica recuperarPessoaFisicaPorId(int id) {
		
		PessoaFisica resultado = null;
		
		try{
			resultado = 
				PersistenceConfig
					.getEntityManager()
					.find(PessoaFisica.class, id);
		}
		catch (Exception e){
			System.out.println("Erro ao tentar recuperar a Pessoa F�sica! " +
							   e.getMessage());
		}
		
		
		return resultado;
	}


	@SuppressWarnings("unchecked")
	/*	compilador N�O garante que, NA LINHA 35, a lista ser� exclusivamente
		de <PessoasFisicas>, mas a busca s� trar� objetos deste tipo, o erro 
		pode ser ignorado!														*/
	public Collection<PessoaFisica> recuperarTodasPessoasFisicas(){
		
		Collection<PessoaFisica> resultado = null;
		
		
		try{
			resultado = 
				PersistenceConfig.getEntityManager()
					.createQuery(
						"FROM " + 
						PessoaFisica.class.getName())
					.getResultList();
		}
		catch (Exception e){
			System.out.println("Erro ao tentar recuperar a Pessoa F�sica! " +
							   e.getMessage());
		}
		
		
		return resultado;
	}
}
