package modelo.repositorio;

import java.sql.PreparedStatement;
import modelo.PessoaJuridica;

public class PessoaJuridicaDAO extends PessoaDAO
{
	public int criarPessoaJuridica(PessoaJuridica PessoaJuridica)
	{		
		int id = 0;
		
		try
		{
			id = super.criarPessoa(PessoaJuridica);
			
			if(id > 0)
			{
				PessoaJuridica.setId(id);
				
				String stmt = "insert into pessoasjuridicas (id, cnpj, nomeFantasia) " +
						"values (?, ?, ?)";
				
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				
				pStmt.setInt(1, PessoaJuridica.getId());
				pStmt.setLong(2, PessoaJuridica.getCnpj());
				pStmt.setString(3, PessoaJuridica.getNomeFantasia());
				
				
				pStmt.execute();
				
				super.fecharConexao();
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar inserir uma nova pessoa jurídica! " +
					e.getMessage());
		}
		
		return id;
	}
}
