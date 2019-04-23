package com.mysqldemoproject.open.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="member_info")
@NamedQuery(name="ShareDetail.findAll", query="SELECT m FROM ShareDetail m")
public class ShareDetail {

	/**
	 * The persistent class for the member_info database table.
	 * 
	 */
	

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int memInfo_id;

//		@Column(name="memInfo_age")
		private int memInfo_age;

//		@Column(name="memInfo_contno")
		private String memInfo_contno;

//		@Column(name="memInfo_fathname")
		private String memInfo_fathname;

//		@Column(name="memInfo_fname")
		private String memInfo_fname;

//		@Column(name="memInfo_occup")
		private String memInfo_occup;

//		@Column(name="memInfo_status")
		private String memInfo_status;

		public ShareDetail() {
		}

		public int getMemInfo_id() {
			return this.memInfo_id;
		}

		public void setMemInfo_id(int memInfo_id) {
			this.memInfo_id = memInfo_id;
		}

		public int getMemInfo_age() {
			return this.memInfo_age;
		}

		public void setMemInfo_age(int memInfo_age) {
			this.memInfo_age = memInfo_age;
		}

		public String getMemInfo_contno() {
			return this.memInfo_contno;
		}

		public void setMemInfo_contno(String memInfo_contno) {
			this.memInfo_contno = memInfo_contno;
		}

		public String getMemInfo_fathname() {
			return this.memInfo_fathname;
		}

		public void setMemInfo_fathname(String memInfo_fathname) {
			this.memInfo_fathname = memInfo_fathname;
		}

		public String getMemInfo_fname() {
			return this.memInfo_fname;
		}

		public void setMemInfo_fname(String memInfo_fname) {
			this.memInfo_fname = memInfo_fname;
		}

		public String getMemInfo_occup() {
			return this.memInfo_occup;
		}

		public void setMemInfo_occup(String memInfo_occup) {
			this.memInfo_occup = memInfo_occup;
		}

		public String getMemInfo_status() {
			return this.memInfo_status;
		}

		public void setMemInfo_status(String memInfo_status) {
			this.memInfo_status = memInfo_status;
		}


	
}
