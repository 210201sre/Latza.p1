package com.revature.latza.util;

import java.util.UUID;

import org.slf4j.MDC;

public class MyLoggingUtil {
	public static void startMDC() {
		String key = UUID.randomUUID().toString();
		MDC.put("RequestKey", key);
	}
}
