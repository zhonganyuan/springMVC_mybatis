package com.wkb.common.util.file;

import java.util.List;

public class FileUtil {
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List result){
		if (result == null || result.isEmpty()) {
			return true;
		}
		return false;
	}
}
