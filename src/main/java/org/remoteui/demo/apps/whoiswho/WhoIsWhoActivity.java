/**
 * Created on 21.11.2012
 *
 * © 2012 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.apps.whoiswho;

import java.util.Date;

import org.remoteui.annotation.Activity;
import org.remoteui.protocol.cmd.OpenUriCmd;
import org.remoteui.webapp.WebActivity;

/**
 *
 *
 * @author Daniel Thommes
 */
@Activity(id="whoiswho", layout="who-is-who.layout.mv")
public class WhoIsWhoActivity extends WebActivity {

	public Person person;

	public WhoIsWhoActivity() {

		person = new Person();
		person.setFirstName("Daniel");
		person.setLastName("Thommes");
		person.setCompany("RemoteUI Project");

		Address address = new Address();
		address.setStreet("Nobelstr.");
		address.setStreetNumber("5");
		address.setZipCode("70569");
		address.setTown("Stuttgart");
		address.setCountry("Germany");
		address.setLongitude(48.74200);
		address.setLatitude(9.10076);

		person.setAddress(address);
		person.setDepartment("Research and Development");

		person.setPhone("+4971112345678");
		person.setMobile("+491797389529");
		person.setEmail("daniel@remoteui.org");
		person.setLocationCode("N5");
		person.setContactPerson("Dr. No");
		person.setContactPerson2("Bruce Willis");
		person.setCostUnit("0815");
		person.setUserId("thommes");
		person.setAreaOfWork("Mobile Application Development");

		person.setImageUrl("classpath:/org/remoteui/demo/apps/whoiswho/img/daniel.jpg");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.remoteui.webapp.WebActivity#onStart()
	 */
	@Override
	protected void onStart() {
		person.setLastUpdated(new Date());
		super.onStart();
	}

	public void onCall() {
		sendCommand(new OpenUriCmd("tel:" + person.getPhone()));
	}

	public void onCallMobile() {
		sendCommand(new OpenUriCmd("tel:" + person.getMobile()));
	}

	public void onSms() {
		sendCommand(new OpenUriCmd("sms:" + person.getMobile()));
	}

	public void onEmail() {
		sendCommand(new OpenUriCmd("mailto:" + person.getEmail()));
	}

	public void onLocate() {
		Address address = person.getAddress();
		// "geo:48.74200,9.10076?q=48.74200,9.10076(HdM Stuttgart, Nobelstr. 10, 70569 Stuttgart, Raum 151)"
		String geoUri = "geo:" + address.getLongitude() + ","
				+ address.getLatitude() + "?q=" + +address.getLongitude() + ","
				+ address.getLatitude() + "(" + person.getCompany() + ", "
				+ address.getStreet() + " " + address.getStreetNumber() + ", "
				+ address.getZipCode() + " " + address.getTown() + ")";
		System.out.println(geoUri);
		sendCommand(new OpenUriCmd(geoUri));
	}
}
