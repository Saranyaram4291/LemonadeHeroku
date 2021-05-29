package com.att.lemonade.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.log4testng.Logger;

import com.att.lemonade.base.TestCaseSessionDataManger;

public class PDFReader {
	private static final Logger log = Logger.getLogger(CommonFunctions.class);
	String pdfContent = "";
	private String testCaseUniqueKey = null;

	public PDFReader(String pdfFile, String testCaseUniqueKey) {
		InputStream targetStream = null;
		BufferedInputStream bStream = null;
		PDDocument pdDocument = null;
		this.testCaseUniqueKey = testCaseUniqueKey;
		try {
			pdfFile = System.getProperty("user.dir") + File.separator + "target" + File.separator + pdfFile;
			log.info("PDF file to parse:" + pdfFile);
			File initialFile = new File(pdfFile);
			targetStream = new FileInputStream(initialFile);
			bStream = new BufferedInputStream(targetStream);
			pdDocument = PDDocument.load(bStream);
			pdfContent = new PDFTextStripper().getText(pdDocument);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Failed to read PDF file" + pdfFile, new Throwable("PDF PARSING FAILED"));
		} finally {
			try {
				if (targetStream != null)
					targetStream.close();
				if (bStream != null)
					bStream.close();
				if (pdDocument != null)
					pdDocument.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

/*	public void setPDFDataToSession() {

		String companyName = StringUtils.substringBetween(pdfContent, "Company Name", "ROME");
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.COMPANY_NAME, companyName.trim());

		String budgetoryOrFirm = StringUtils.substringBetween(pdfContent, "Budgetary / Firm", "Custom Price List Name");
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.BUDGETROY_OR_FIRM, budgetoryOrFirm.trim());

		String requestIdFirst = StringUtils.substringBetween(pdfContent, "Request ID",
				"Date Rate Letter Initially Created");
		int index = requestIdFirst.indexOf("Request ID");
		int strLength = requestIdFirst.length();
		String requestId = requestIdFirst.substring(index + 12);
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.REQUEST_ID, requestId.trim());

		// String requestOwner = StringUtils.substringBetween(pdfContent,
		// "Request Owner", "Commitment Type");
		// TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
		// ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT, "requestOwner",
		// requestOwner.trim());

		// String contractTerm = StringUtils.substringBetween(pdfContent,
		// "Contract Term", "Version");
		// TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
		// ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT, "contractTerm",
		// contractTerm.trim());

		// String version = StringUtils.substringBetween(pdfContent, "Version",
		// "Date Rate Letter Last Modified");
		// TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
		// ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT, "version",
		// version.trim());

		// String billedRevenue = StringUtils.substringBetween(pdfContent,
		// "Billed Revenue (Annualized)", "Revision");
		// TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
		// ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT, "billedRevenue",
		// billedRevenue.trim());

		String commitmentType = StringUtils.substringBetween(pdfContent, "Commitment Type", "Sales Channel");
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.COMMITMENT_TYPE, commitmentType.trim());

		String salesChannel = StringUtils.substringBetween(pdfContent, "Sales Channel", "Pricing Manager ATTUID");
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.SALES_CHANNEL, salesChannel.trim());

		String businessUnit = StringUtils.substringBetween(pdfContent, "Business Unit", "Pricing Manager");
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.BUSINESS_UNIT, businessUnit.trim());

		// String salesScvp = StringUtils.substringBetween(pdfContent, "Sales
		// SCVP/RVP", "Sales Lead");
		// TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
		// ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT, "salesScvp",
		// salesScvp.trim());

		String MRCandNRC = StringUtils.substringBetween(pdfContent, "Total Price", "Quantity");
		// hm.put("MRCandNRC", MRCandNRC.trim());

		String a[] = MRCandNRC.split("\\n");
		System.out.println(a);
		String mrc = a[6];
		String nrc = a[8];
		if (mrc.contains("$") || mrc.contains(",")) {
			mrc = mrc.replace("$", "");
			mrc = mrc.replace(",", "");
		}

		if (nrc.contains("$") || nrc.contains(",")) {
			nrc = nrc.replace("$", "");
			nrc = nrc.replace(",", "");
		}

		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.TOTAL_MRC, mrc.trim());
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT,
				ConstantFile.TOTAL_NRC, nrc.trim());
	}*/

}
