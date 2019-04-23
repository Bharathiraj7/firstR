package com.mysqldemoproject.open.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the excel_data database table.
 * 
 */
@Entity
@Table(name="excel_data")
public class ExcelData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int excelDat_id;

	private BigDecimal excelDat_amount;

	private String excelDat_code;

	@Temporal(TemporalType.DATE)
	private Date excelDat_date;

	private String excelDat_status;

	public ExcelData() {
	}

	public int getExcelDat_id() {
		return this.excelDat_id;
	}

	public void setExcelDat_id(int excelDat_id) {
		this.excelDat_id = excelDat_id;
	}

	public BigDecimal getExcelDat_amount() {
		return this.excelDat_amount;
	}

	public void setExcelDat_amount(BigDecimal excelDat_amount) {
		this.excelDat_amount = excelDat_amount;
	}

	public String getExcelDat_code() {
		return this.excelDat_code;
	}

	public void setExcelDat_code(String excelDat_code) {
		this.excelDat_code = excelDat_code;
	}

	public Date getExcelDat_date() {
		return this.excelDat_date;
	}

	public void setExcelDat_date(Date excelDat_date) {
		this.excelDat_date = excelDat_date;
	}

	public String getExcelDat_status() {
		return this.excelDat_status;
	}

	public void setExcelDat_status(String excelDat_status) {
		this.excelDat_status = excelDat_status;
	}

}