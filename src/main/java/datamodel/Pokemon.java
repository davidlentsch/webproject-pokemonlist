package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
  CREATE TABLE PokemonManager (
  id INT NOT NULL AUTO_INCREMENT,    
  pokemonName VARCHAR(80) NOT NULL,   
  nickname VARCHAR(80) NOT NULL,
  favDescription VARCHAR(500) NOT NULL,
  emailAddress VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "PokemonManager")
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="ID")
	private int id;
	
	@Column(name="pokemonName")
	private String pokemonName;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="favDescription")
	private String favDescription;
	
	@Column(name="emailAddress")
	private String emailAddress;
	

	public Pokemon(int id, String pokemonName, String nickname, String favDescription, String emailAddress) {
		super();
		this.id = id;
		this.pokemonName = pokemonName;
		this.nickname = nickname;
		this.favDescription = favDescription;
		this.emailAddress = emailAddress;
	}
	
	public Pokemon(String pokemonName, String nickname, String favDescription, String emailAddress) {
		super();
		this.pokemonName = pokemonName;
		this.nickname = nickname;
		this.favDescription = favDescription;
		this.emailAddress = emailAddress;
	}
	
	public Pokemon() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFavDescription() {
		return favDescription;
	}

	public void setFavDescription(String favDescription) {
		this.favDescription = favDescription;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	};
	
	
}
