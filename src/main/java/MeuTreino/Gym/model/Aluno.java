package MeuTreino.Gym.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	
	
	@Id
	@Column(nullable = false)
	private String cpf;
	private String nome;
	private String dt_inicio;
	private String email;
	private String altura;
	private String peso;
	private String roles;
	private String cpf_instrutor;

	public Aluno() {
	}

	public Aluno(String cpf, String nome, String dt_inicio, String email, String altura, String peso, String roles,
			String cpf_instrutor) {
		this.cpf = cpf;
		this.nome = nome;
		this.dt_inicio = dt_inicio;
		this.email = email;
		this.altura = altura;
		this.peso = peso;
		this.roles = roles;
		this.cpf_instrutor = cpf_instrutor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCpf_instrutor() {
		return cpf_instrutor;
	}

	public void setCpf_instrutor(String cpf_instrutor) {
		this.cpf_instrutor = cpf_instrutor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, cpf, cpf_instrutor, dt_inicio, email, nome, peso, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(cpf_instrutor, other.cpf_instrutor) && Objects.equals(dt_inicio, other.dt_inicio)
				&& Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(peso, other.peso) && Objects.equals(roles, other.roles);
	}


}
