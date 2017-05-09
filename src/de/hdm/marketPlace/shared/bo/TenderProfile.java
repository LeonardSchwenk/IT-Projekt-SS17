package de.hdm.marketPlace.shared.bo;
import java.util.Date;

public class TenderProfile extends BusinessObject{
	
	//attributes of class
	
	private Date createDate;
	private Date updateDate;
	private int tenderRef = 0;
	private int partnerprofileRef = 0;
	private int attributeRef = 0;
	
	
	
	
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

	public int getPartnerprofileRef() {
		return partnerprofileRef;
	}

	public void setPartnerprofileRef(int partnerprofileRef) {
		this.partnerprofileRef = partnerprofileRef;
	}

	public int getAttributeRef() {
		return attributeRef;
	}

	public void setAttributeRef(int attributeRef) {
		this.attributeRef = attributeRef;
	}
	
	
	
	

}
