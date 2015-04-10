package com.trimc.blogger.commons.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.trimc.blogger.commons.LogManager;

public final class LogUtils {

	public static LogManager	logger	= new LogManager(LogUtils.class);

	public static String toLogString(Object obj) {
		StringBuilder sb = new StringBuilder();

		try {

			Class<?> c = obj.getClass();
			List<Method> list = new ArrayList<Method>();
			Method[] methods = c.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++)
				if (methods[i].getName().startsWith("get")) list.add(methods[i]);

			Iterator<Method> iter = list.iterator();
			while (iter.hasNext()) {
				Method method = iter.next();

				String name = StringUtils.substringAfter(method.getName(), "get");
				Object value = method.invoke(obj);

				sb.append(String.format(name + " = " + value, name, value));
				if (iter.hasNext()) sb.append(", ");
			}

		} catch (Exception e) {
			logger.error(e);
		}

		return sb.toString();
	}
}
