package com.att.lemonade.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.MonitoringMail;

public class TestHostAdd {
	private static AplicationConfigurationManager ACM=AplicationConfigurationManager.getInstance();

	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {

		MonitoringMail mail = new MonitoringMail();
		String messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
				+ ":91909/job/DataDrivenLiveProject/Extent_Reports/";
		System.out.println(messageBody);
		
		mail.sendMail(ACM.getMailServer(), ACM.getMailFrom(), ACM.getMailTO(), ACM.getMailSubject(), messageBody);

	}

}
