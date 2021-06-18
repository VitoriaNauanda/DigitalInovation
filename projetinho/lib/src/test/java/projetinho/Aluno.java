package projetinho;

public class Aluno {
	int id;
	String nome;
	int idade;
	String estado;
	
	public Aluno(int id, String nome, int idade, String estado) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}
	public Aluno() {
		
	}
	public Aluno(String nome, int idade, String estado) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}
	
	public void setId(int id) {
		 this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public String getEstado() {
		return estado;
	}
}
