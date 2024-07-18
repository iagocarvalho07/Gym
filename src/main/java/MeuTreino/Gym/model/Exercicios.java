package MeuTreino.Gym.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "exercicios")
public class Exercicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String bodyPart;
	private String equipment;
	private String gifUrl;
	private String name;
	private String target;
	public Exercicios() {
	}
	public Exercicios(UUID id, String bodyPart, String equipment, String gifUrl, String name, String target) {
		this.id = id;
		this.bodyPart = bodyPart;
		this.equipment = equipment;
		this.gifUrl = gifUrl;
		this.name = name;
		this.target = target;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getGifUrl() {
		return gifUrl;
	}
	public void setGifUrl(String gifUrl) {
		this.gifUrl = gifUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bodyPart, equipment, gifUrl, id, name, target);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercicios other = (Exercicios) obj;
		return Objects.equals(bodyPart, other.bodyPart) && Objects.equals(equipment, other.equipment)
				&& Objects.equals(gifUrl, other.gifUrl) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(target, other.target);
	}



}
