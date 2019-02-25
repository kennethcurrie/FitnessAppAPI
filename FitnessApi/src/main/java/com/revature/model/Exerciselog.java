package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "exerciselog")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonFilter("depth_4")
public class Exerciselog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exerciselogid")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "exerciseid")
	private Exercise exerciseId;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private AppUser user;

	@Column(name = "units")
	private double units;

	@Column(name = "note")
	private String note;

	@Column(name = "occourred")
	private Date occourred;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Exercise getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Exercise exerciseId) {
		this.exerciseId = exerciseId;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOccourred() {
		return occourred;
	}

	public void setOccourred(Date occourred) {
		this.occourred = occourred;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exerciseId == null) ? 0 : exerciseId.hashCode());
		result = prime * result + id;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((occourred == null) ? 0 : occourred.hashCode());
		long temp;
		temp = Double.doubleToLongBits(units);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exerciselog other = (Exerciselog) obj;
		if (exerciseId == null) {
			if (other.exerciseId != null)
				return false;
		} else if (!exerciseId.equals(other.exerciseId))
			return false;
		if (id != other.id)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (occourred == null) {
			if (other.occourred != null)
				return false;
		} else if (!occourred.equals(other.occourred))
			return false;
		if (Double.doubleToLongBits(units) != Double.doubleToLongBits(other.units))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Exerciselog [id=" + id + ", exerciseId=" + exerciseId + ", user=" + user + ", units=" + units
				+ ", note=" + note + ", occourred=" + occourred + "]";
	}

}
