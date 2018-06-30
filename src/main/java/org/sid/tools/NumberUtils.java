package org.sid.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtils {

	private static final Logger LOG = LoggerFactory.getLogger(NumberUtils.class);

	public static int toInt(String value, int defaultValue) {
		int result = defaultValue;
		try {
			result = Integer.parseInt(value);
		} catch (Exception e) {
			LOG.error("Error converting String '" + value + "' to Integer, returning default value '" + defaultValue + "'");
		}
		return result;
	}
}
