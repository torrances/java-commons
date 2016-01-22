package com.trimc.blogger.commons.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;

public class FileUtils$Read {

	public static LogManager logger = new LogManager(FileUtils.class);

	protected static List<File> toList(File... files) {
		List<File> list = new ArrayList<File>();

		for (File file : files) {
			list.add(file);
		}

		return list;
	}
	
	protected static int numberOfLines(File file) throws BusinessException {
		int ctr = 0;

		try {

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				@SuppressWarnings("unused") String line;
				while ((line = br.readLine()) != null) {
					ctr++;
				}
			}

		} catch (IOException e) {
			throw new BusinessException("Unable to count lines in file (path = %s)", file.getAbsolutePath());
		}

		return ctr;
	}

	protected static Collection<String> toList(File file, Codepage codepage) throws BusinessException {
		List<String> lines = new ArrayList<String>();

		try {

			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, codepage.toString());
			BufferedReader br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			br.close();
			isr.close();
			fis.close();

		} catch (IOException e) {
			throw new BusinessException(e);
		}

		return lines;
	}
}
