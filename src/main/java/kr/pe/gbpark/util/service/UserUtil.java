package kr.pe.gbpark.util.service;

import kr.pe.gbpark.util.enums.Browser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserUtil {
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

		if (existIP(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (existIP(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (existIP(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (existIP(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (existIP(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	private static boolean existIP(String ip) {
		return ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip);
	}


	public static String getAgent(HttpServletRequest request) {
		String agent = request.getHeader("User-Agent");
		return agent == null ? "" : agent;
	}

	public static Browser getBrowser(HttpServletRequest request) {
		String agent = getAgent(request);

		if (!agent.isEmpty()) {
			if (agent.contains("Trident")) {
				return Browser.MSIE;
			} else if (agent.contains("Chrome")) {
				return Browser.CHROME;
			} else if (agent.contains("Opera")) {
				return Browser.OPERA;
			} else if (agent.contains("iPhone") && agent.contains("Mobile")) {
				return Browser.IPHONE;
			} else if (agent.contains("Android") && agent.contains("Mobile")) {
				return Browser.ANDROID;
			}
		}

		return Browser.ETC;
	}


}
