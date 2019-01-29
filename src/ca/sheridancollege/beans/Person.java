package ca.sheridancollege.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name="Person.all", query="from Person")
@NamedQuery(name="Person.byName", query="from Person where firstName = :firstName and lastName=:lastName")
public class Person {

	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	

	
}
