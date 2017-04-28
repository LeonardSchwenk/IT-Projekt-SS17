package de.hdm.marketPlace.shared.bo;
import java.util.Date;

public class TenderProfile {
	
	//attributes of class
	
	private Date createDate;
	private Date updateDate;
	private int tenderRef;
	
	//constructor
	
	public TenderProfile(Date createDate, Date updateDate, int tenderRef) {
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.tenderRef  = tenderRef;
	}

	//Setter and Getter of all attributes
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getTenderRef() {
		return tenderRef;
	}

	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	
	
	
	

}
