package modelo.repositorio;

import java.sql.PreparedStatement;

import modelo.PessoaFisica;

public class PessoaFisicaDAO extends PessoaDAO
{
	public int criarPessoaFisica(PessoaFisica pessoaFisica)
	{		
		int id = 0;
		
		try
		{
			id = super.criarPessoa(pessoaFisica);
			
			if(id > 0)
			{
				pessoaFisica.setId(id);
				
				String stmt = "insert into pessoasfisicas (id, cpf, nascto) " +
						"values (?, ?, ?)";
				
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				
				pStmt.setInt(1, pessoaFisica.getId());
				pStmt.setLong(2, pessoaFisica.getCpf());
				
				java.sql.Date nasctoSql = new java.sql.Date(pessoaFisica.getNascto().getDate());
				pStmt.setDate(3, nasctoSql);
				
				pStmt.execute();
				
				super.fecharConexao();
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar inserir uma nova pessoa física! " +
					e.getMessage());
		}
		
		return id;
	}
}
