package com.zhangjiawei;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author zjw
 *
 */
public class StreamUtils {
	
	/**
	 * 
	 * @param n
	 * @param streams
	 * @throws IOException
	 */
	public static void closeStream(Closeable ... streams) throws IOException {
		
		for (int i = 0; i < streams.length; i++) {
			streams[i].close();
		}
		
	}

}
