package com.trimc.blogger.commons.utils;

import java.net.Socket;

public final class SocketUtils {

	/* dc:url <http://www.geekality.net/2013/04/30/java-simple-check-to-see-if-a-server-is-listening-on-a-port/> */
	public static boolean serverListening(String host, int port) {
		Socket s = null;
		try {
			s = new Socket(host, port);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (s != null) try {
				s.close();
			} catch (Exception e) {}
		}
	}
}
