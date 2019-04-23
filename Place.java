package com.mysqldemoproject.open.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="place_id")
	private int placeId;

	@Column(name="place_name")
	private String placeName;

	@Column(name="place_status")
	private String placeStatus;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;

	public Place() {
	}

	public int getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceStatus() {
		return this.placeStatus;
	}

	public void setPlaceStatus(String placeStatus) {
		this.placeStatus = placeStatus;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}