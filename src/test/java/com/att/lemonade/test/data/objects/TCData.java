package com.att.lemonade.test.data.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TCData {
	public String username;
	public String password;
	public String successMessage;
	public String runmode;

	public String description;
	public String accountName;
	public String subAcctId;
	public String svidName;
	public String NoOfOpptys;
	public String priorYearTBRMinValue;
	
	public String priorYearTBRMaxValue;
	public String accountStatus;
	public String SVID;
	public String DomSubAcct;
	public String SICCode;
	public String SICDescription;
	public String nAICSCode;
	public String nAICSDescription;
	
	public String FNIndicator;
	public String fiberEligible;
	public String ownerName;
	public String percentageFiber;
	public String primaryPhone;
	public String primaryStreet;
	public String primaryCity;
	public String primaryState;
	public String primaryZip;
	public String primaryCountry;
	public String attuid;

	
	public String globalSearch;

	
	public String recordCount;
	public String responseTime;
	
	public String firstName;
	public String lastName;
	public String title;
	public String department;
	public String managementLevel;
	public String filterOnEmailAndPhone;
	public String columnDisplayVisible;
	
	

	public String getColumnDisplayVisible() {
		return columnDisplayVisible;
	}

	public void setColumnDisplayVisible(String columnDisplayVisible) {
		this.columnDisplayVisible = columnDisplayVisible;
	}

	public String DUNSNumber;


	public String getAttuid() {
		return attuid;
	}

	public void setAttuid(String attuid) {
		this.attuid = attuid;
	}
	
	public String getPriorYearTBRMinValue() {
		return priorYearTBRMinValue;
	}

	public void setPriorYearTBRMinValue(String priorYearTBRMinValue) {
		this.priorYearTBRMinValue = priorYearTBRMinValue;
		
	}

	public String getPriorYearTBRMaxValue() {
		return priorYearTBRMaxValue;
	}

	public void setPriorYearTBRMaxValue(String priorYearTBRMaxValue) {
		this.priorYearTBRMaxValue = priorYearTBRMaxValue;
	}


	
	public String getPrimaryCountry() {
		return primaryCountry;
	}

	public void setPrimaryCountry(String primaryCountry) {
		this.primaryCountry = primaryCountry;
	}
	public String getDUNSNumber() {
		return DUNSNumber;
	}

	public void setDUNSNumber(String dUNSNumber) {
		DUNSNumber = dUNSNumber;
	}

	public String getDomSubAcct() {
		return DomSubAcct;
	}

	public void setDomSubAcct(String domSubAcct) {
		DomSubAcct = domSubAcct;
	}

	public String getSICCode() {
		return SICCode;
	}

	public void setSICCode(String sICCode) {
		SICCode = sICCode;
	}

	public String getSICDescription() {
		return SICDescription;
	}

	public void setSICDescription(String sICDescription) {
		SICDescription = sICDescription;
	}

	public String getnAICSCode() {
		return nAICSCode;
	}

	public void setnAICSCode(String nAICSCode) {
		nAICSCode = nAICSCode;
	}

	public String getnAICSDescription() {
		return nAICSDescription;
	}

	public void setnAICSDescription(String nAICSDescription) {
		nAICSDescription = nAICSDescription;
	}

	
	
	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getSVID() {
		return SVID;
	}

	public void setSVID(String sVID) {
		SVID = sVID;
	}

	public String getFNIndicator() {
		return FNIndicator;
	}

	public void setFNIndicator(String fNIndicator) {
		FNIndicator = fNIndicator;
	}

	public String getFiberEligible() {
		return fiberEligible;
	}

	public void setFiberEligible(String fiberEligible) {
		this.fiberEligible = fiberEligible;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPercentageFiber() {
		return percentageFiber;
	}

	public void setPercentageFiber(String percentageFiber) {
		this.percentageFiber = percentageFiber;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getPrimaryStreet() {
		return primaryStreet;
	}

	public void setPrimaryStreet(String primaryStreet) {
		this.primaryStreet = primaryStreet;
	}

	public String getPrimaryCity() {
		return primaryCity;
	}

	public void setPrimaryCity(String primaryCity) {
		this.primaryCity = primaryCity;
	}

	public String getPrimaryState() {
		return primaryState;
	}

	public void setPrimaryState(String primaryState) {
		this.primaryState = primaryState;
	}

	public String getPrimaryZip() {
		return primaryZip;
	}

	public void setPrimaryZip(String primaryZip) {
		this.primaryZip = primaryZip;
	}


	
	
	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public void setNoOfOpptys(String noOfOpptys) {
		NoOfOpptys = noOfOpptys;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSubAcctId() {
		return subAcctId;
	}

	public void setSubAcctId(String subAcctId) {
		this.subAcctId = subAcctId;
	}

	public String getSvidName() {
		return svidName;
	}

	public void setSvidName(String svidName) {
		this.svidName = svidName;
	}

	public String getNoOfOpptys() {
		return NoOfOpptys;
	}

	public void setnoOfOpptys(String NoOfOpptys) {
		this.NoOfOpptys = NoOfOpptys;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getRunmode() {
		return runmode;
	}

	public void setRunmode(String runmode) {
		this.runmode = runmode;
	}

	public String getGlobalSearch() {
		return globalSearch;
	}

	public void setGlobalSearch(String globalSearch) {
		this.globalSearch = globalSearch;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getManagementLevel() {
		return managementLevel;
	}

	public void setManagementLevel(String managementLevel) {
		this.managementLevel = managementLevel;
	}

	public String getFilterOnEmailAndPhone() {
		return filterOnEmailAndPhone;
	}

	public void setFilterOnEmailAndPhone(String filterOnEmailAndPhone) {
		this.filterOnEmailAndPhone = filterOnEmailAndPhone;
	}


	
	/**
	 * @author sk7787
	 *
	 */
/*	public ArrayList<Address> getSiteAddresses() throws IOException{
		if(sitesData==null){
			return null;
		}else{
			ArrayList<Address> addressList=new ArrayList<Address>();
			BufferedReader br=new BufferedReader(new StringReader(sitesData));
			int rowCount=0;
			String str=null;
			while((str=br.readLine())!=null){
				if(rowCount==0){
					rowCount++;
					continue;
				}else{
					rowCount++;
				}
				addressList.add(new Address(str));
			}
			return addressList;
		}*/
	}

