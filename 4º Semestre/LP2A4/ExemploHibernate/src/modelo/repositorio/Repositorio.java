package modelo.repositorio;

import javax.persistence.EntityTransaction;

public class Repositorio<T> {
	
	public boolean criar (T entidade) {
		
		boolean resultado = true;
				
		EntityTransaction transaction =
				PersistenceConfig.getEntityManager().getTransaction();
		
		try{
			transaction.begin();
			PersistenceConfig.getEntityManager().persist(entidade);
			transaction.commit();
		}
		catch(Exception e){
			System.out.print("Erro ao tentar criar a nova entidade." 
							+e.getMessage());
			transaction.rollback();
			resultado = false;
		}
		return resultado;
	}

	
	public boolean atualizar (T entidade) {
		
		boolean resultado = true;
				
		EntityTransaction transaction =
				PersistenceConfig.getEntityManager().getTransaction();
		
		try{
			transaction.begin();
			PersistenceConfig.getEntityManager().merge(entidade);
			transaction.commit();
		}
		catch(Exception e){
			System.out.print("Erro ao tentar atualizar a entidade." 
							+e.getMessage());
			transaction.rollback();
			resultado = false;
		}
		return resultado;
	}

	
	public boolean excluir (T entidade) {
		
		boolean resultado = true;
		
		EntityTransaction transaction =
				PersistenceConfig.getEntityManager().getTransaction();
		
		try{
			transaction.begin();
			PersistenceConfig.getEntityManager().remove(entidade);
			transaction.commit();
		}
		catch(Exception e){
			System.out.print("Erro ao tentar excluir a entidade." 
							+e.getMessage());
			transaction.rollback();
			resultado = false;
		}
		return resultado;
	}
}
