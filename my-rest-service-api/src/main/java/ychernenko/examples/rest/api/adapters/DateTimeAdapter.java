package ychernenko.examples.rest.api.adapters;

import java.util.*;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, Date> {

	@Override
	public String marshal(Date dt) throws Exception {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return DatatypeConverter.printDateTime(cal);
	}

	@Override
	public Date unmarshal(String s) throws Exception {
		return DatatypeConverter.parseDateTime(s).getTime();
	}
}
