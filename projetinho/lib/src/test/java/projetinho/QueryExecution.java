package projetinho;

import java.util.List;
import java.util.Scanner;

public class QueryExecution {
 public static void main(String[]args) {
	 int num ;
	 Scanner tec = new Scanner(System.in);
	 
	 while(true){
		 try {
			 System.out.println("Informe \n[0] - Consultar todos \n[1] - Consultar por filtro \n[2] - Inserir \n[3] - Deletar \n[4] - Atualizar");
			 num = tec.nextInt();
			 
			 if(num < 0 || num > 4) {
				 throw new Exception();
			 }
		 }catch(Exception e) {
			 System.out.println("ESCOLHA NÚMEROS DE 0 A 4");
			 continue;
		 }
		break;
	 }
	  AlunoDAO alunoDAO = new AlunoDAO();
	 switch(num) {
	 	case 0:
	 		// Consulta todos
	 		
	 		 List<Aluno> alunos = alunoDAO.list();
	 		 alunos.stream().forEach(System.out::println );
	 		 break;
	 	case 1:
	 		// Consulta com filtro
	 		 
	 		 Aluno alunoParaConsulta = alunoDAO.getById(1);
	 		 System.out.println(alunoParaConsulta);
	 		 break;
	 	case 2:
	 		// Inserção
	 		 Aluno alunoParaInsercao = new Aluno(
	 				 "Esmeralda", 22, "CE"
	 				 
	 		 );
	 		 alunoDAO.creat(alunoParaInsercao);
	 		 break;
	 	case 3:
	 		// Deletar
	 		 
	 		 alunoDAO.deletar(7);
	 		 break;
	 	case 4:
	 		//Atualizar
	 		 
	 		 Aluno alunoParaAtualizar = alunoDAO.getById(3);
	 		 alunoParaAtualizar.setNome("Malu");
	 		 alunoParaAtualizar.setIdade(24);
	 		 alunoParaAtualizar.setEstado("MA");
	 		 alunoDAO.update(alunoParaAtualizar);
	 		 break;

	 }
	 
	 
	  
	 
	 	 
 }
 
}
