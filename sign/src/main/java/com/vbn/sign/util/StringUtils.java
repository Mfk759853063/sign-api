package com.vbn.sign.util;

import java.util.UUID;

public class StringUtils {

	/** 
	* 产生一个32位的GUID 
	* @return 
	*/ 
	public static String newGUID() { 
		UUID uuid = UUID.randomUUID(); 
		return uuid.toString(); 
	}
}
