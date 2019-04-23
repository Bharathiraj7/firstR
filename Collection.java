package com.mysqldemoproject.open.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the collection database table.
 * 
 */
@Entity
@NamedQuery(name="Collection.findAll", query="SELECT c FROM Collection c")
public class Collection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coll_id")
	private int collId;

	private String coll_sharCode;

	public Collection() {
	}

	public int getCollId() {
		return this.collId;
	}

	public void setCollId(int collId) {
		this.collId = collId;
	}

	public String getColl_sharCode() {
		return this.coll_sharCode;
	}

	public void setColl_sharCode(String coll_sharCode) {
		this.coll_sharCode = coll_sharCode;
	}

}