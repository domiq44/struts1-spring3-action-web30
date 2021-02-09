package org.sid.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtils {

	private static final Logger LOG = LoggerFactory.getLogger(NumberUtils.class);

	private NumberUtils() {
		//
	}

	public static int toInt(String value, int defaultValue) {
		int result = defaultValue;
		try {
			result = Integer.parseInt(value);
		} catch (final Exception e) {
			LOG.error("Error converting String '{}' to Integer, returning default value '{}'", value, defaultValue);
		}
		return result;
	}
}
