package br.furb.trabalho1_semestres_anteriores.lista;


import java.time.LocalDate;

public class Aluno {
	
	
	private int matricula;
	private String nome;
	private LocalDate anoNascimento;
	private String email;
	
	public Aluno(int i, String string, LocalDate of, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(LocalDate anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
		

}
