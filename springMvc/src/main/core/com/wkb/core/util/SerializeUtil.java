package com.wkb.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * @author huanglt
 *
 */
public class SerializeUtil {

	/**
	 * 序列化对象
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj){
		if(obj == null){
			return null;
		}
		ObjectOutputStream oos=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] bytes=null;
		try {
			oos=new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bytes=baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(oos != null){
					oos.close();
				}
				if(baos != null){
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bytes;
	}
	
	/**
	 * 反序列化对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes){
		if(bytes == null || bytes.length == 0){
			return null;
		}
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		Object obj=null;
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(bais);
			obj=ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois != null){
					ois.close();
				}
				if(bais != null){
					bais.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
