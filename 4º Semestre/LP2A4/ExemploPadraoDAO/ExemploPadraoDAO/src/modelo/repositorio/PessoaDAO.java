package modelo.repositorio;

import java.sql.*;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO extends FabricaConexao {
	
	protected int criarPessoa(Pessoa pessoa) {		
		int id = 0;
		
		try {
			String stmt = "insert into pessoas (nome, endereco, cep, telefone, " +
					"renda, situacao) values (?, ?, ?, ?, ?, ?) returning id";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setString(1, pessoa.getNome());
			pStmt.setString(2, pessoa.getEndereco());
			pStmt.setLong(3, pessoa.getCep());
			pStmt.setString(4, pessoa.getTelefone());
			pStmt.setFloat(5, pessoa.getRenda());
			pStmt.setByte(6, pessoa.getSituacao());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar inserir uma nova pessoa! " +
					e.getMessage());
		}
		
		return id;
	}
	
	/* OS MÉTODOS ABAIXO DEVERÃO SER ADAPTADOS */
	
	public ArrayList<Pessoa> recuperarPessoas() {
		ArrayList<Pessoa> resultado = null;
		
		try {
			String stmt = "select id, nome, endereco, cep, telefone, renda, situacao from pessoas";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Pessoa>();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setCep(rs.getLong("cep"));
				p.setTelefone(rs.getString("telefone"));
				p.setRenda(rs.getFloat("renda"));
				p.setSituacao(rs.getByte("situacao"));
				
				resultado.add(p);
			}
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar recuperar as pessoas cadastradas. " + e.getMessage());
		}
		
		return resultado;
	}
	
	public Pessoa recuperarPessoaPorId(int id) {
		Pessoa resultado = null;
		
		try {
			String stmt = "select id, nome, endereco, cep, telefone, renda, " +
					 "situacao from pessoas where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultado = new Pessoa();
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setEndereco(rs.getString("endereco"));
				resultado.setCep(rs.getLong("cep"));
				resultado.setTelefone(rs.getString("telefone"));
				resultado.setRenda(rs.getFloat("renda"));
				resultado.setSituacao(rs.getByte("situacao"));
			}
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar recuperar a pessoa com ID " +
					id + ". " + e.getMessage());
		}
		
		return resultado;
	}
	
	public int editarPessoa(Pessoa pessoa) {
		int resultado = 0;
		
		try {
			String stmt = "update pessoas set nome = ?, endereco = ?, cep = ?, " +
						  "telefone = ?, renda = ?, situacao = ? where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setString(1, pessoa.getNome());
			pStmt.setString(2, pessoa.getEndereco());
			pStmt.setLong(3, pessoa.getCep());
			pStmt.setString(4, pessoa.getTelefone());
			pStmt.setFloat(5, pessoa.getRenda());
			pStmt.setByte(6, pessoa.getSituacao());
			pStmt.setInt(7, pessoa.getId());
			
			resultado = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar atualizar os dados da pessoa! " +
					e.getMessage());
		}
		
		return resultado;
	}
	
	public int removerPessoa(int id)
	{
		int resultado = 0;
		
		try {
			String stmt = "delete from pessoas where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			
			resultado = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar excluir o registro da pessoa! " +
					e.getMessage());
		}
		
		return resultado;
	}
}