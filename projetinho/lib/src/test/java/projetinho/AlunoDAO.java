package projetinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
	// Consulta
	public List<Aluno>list(){
		//Prepara a lista que vai retornar a lista de alunos após a consulta no banco de dados
		List<Aluno> alunos = new ArrayList<>();
		try(Connection conn = ConnectionJDBCjava.getConnection()) {
			PreparedStatement psrt = conn.prepareStatement("SELECT * FROM aluno");
			//Objeto que contém os dados de uma determinada consulta no BD
			ResultSet rs = psrt.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getInt("idade"),
						rs.getString("estado")
						
				);
				alunos.add(aluno);
				
			}
		}catch(Exception e){
			System.out.println("Não funciona" + e.getMessage());
		}
		return alunos;
	}
	//Consulta por ID:
	public Aluno getById(int id) {
		//Preparar o objeto Aluno para receber os valores do banco de dados
		Aluno aluno = new Aluno();
		try(Connection conn = ConnectionJDBCjava.getConnection()){
			String sql = "SELECT * FROM aluno WHERE id = ?";
			PreparedStatement sInt = conn.prepareStatement(sql);
			sInt.setInt(1, id);
			ResultSet rs = sInt.executeQuery();
			if(rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setEstado(rs.getString("estado"));
			}
			System.out.println("Consulta por filtro foi bem sucedida");
		}catch(SQLException e) {
			System.out.println("Listagem de alunos falhou ");
			e.printStackTrace();
		}
		return aluno;
	}
	// Inserir
	public void creat(Aluno aluno) {
		try(Connection conn = ConnectionJDBCjava.getConnection()){
			String sql = "INSERT INTO aluno(nome,idade,estado) VALUES(?,?,?)";
			PreparedStatement sInt = conn.prepareStatement(sql);
			sInt.setString(1, aluno.getNome());
			sInt.setInt(2, aluno.getIdade());
			sInt.setString(3, aluno.getEstado());
			// Executa a inserção
			int rawsAffected = sInt.executeUpdate() ;
			System.out.println("Inserção bem sucedida.Foi adicionado " + rawsAffected + " a lista");
			
		}catch(SQLException e) {
			System.out.println("Inserção falhou");
			e.printStackTrace();
		}
	}
	// Deletar
	public void deletar(int id) {
		try(Connection conn = ConnectionJDBCjava.getConnection()){
			String sql = "DELETE  FROM aluno WHERE id = ?";
			PreparedStatement sInt = conn.prepareStatement(sql);
			sInt.setInt(1, id);
			
			int rawsAffected = sInt.executeUpdate() ;
			System.out.println("Deleção bem sucedida.Foi removido " + rawsAffected + " da lista");
			
		}catch(SQLException e) {
			System.out.println("Deleção falhou");
			e.printStackTrace();
		}
	}
	//Atualizar
	
	public void update(Aluno aluno) {
		try(Connection conn = ConnectionJDBCjava.getConnection()){
			String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";
			PreparedStatement sInt = conn.prepareStatement(sql);
			
			sInt.setString(1,aluno.getNome());
			sInt.setInt(2,aluno.getIdade());
			sInt.setString(3,aluno.getEstado());
			sInt.setInt(4,aluno.getId());
			int rawsAffected = sInt.executeUpdate() ;
			System.out.println("Atualização foi bem sucedida.Foi atualizado " + rawsAffected + " na lista");
			
		}catch(SQLException e ) {
			System.out.println("Atualização falhou");
			e.printStackTrace();
		}
	}
	
}
