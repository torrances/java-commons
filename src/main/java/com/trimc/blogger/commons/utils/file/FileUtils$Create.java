package com.trimc.blogger.commons.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;
import com.trimc.blogger.commons.utils.Stopwatch;
import com.trimc.blogger.commons.utils.string.StringUtils;

public class FileUtils$Create {

	public static LogManager logger = new LogManager(FileUtils.class);

	protected static void mergeIntoSingleFile(String foldername, String ext, Codepage codepage, File output, boolean enableLogging) throws BusinessException {
		StringBuilder sb = new StringBuilder();

		Stopwatch master = new Stopwatch();
		Collection<File> files = FileUtils.getDescendantFilesInFolder(foldername, ext);

		int counter = 1;
		final String TOTAL = StringUtils.format(files.size());

		for (File file : files) {
			if (enableLogging) logger.debug("Processing File (name = %s, %s - %s, elapsed-time = %s)", FileUtils.getName(file), StringUtils.format(counter++), TOTAL, master.getTotalTime());

			for (String line : FileUtils.toList(file, codepage)) {
				sb.append(line);
				sb.append(System.lineSeparator());

				if (sb.length() > 50000) {
					FileUtils.toFile(sb, output, true, codepage);
					sb = new StringBuilder();
				}
			}
		}

		FileUtils.toFile(sb, output, true, codepage);
		logger.debug("Created Merged File (path = %s, total-merged-files = %s, total-time = %s)", output.getAbsolutePath(), TOTAL, master.getTotalTime());
	}

	protected static File toFile(InputStream inputStream, File file, boolean append, Codepage codepage) throws BusinessException {

		try {

			if (!file.exists()) {
				File dir = file.getParentFile();
				if (!dir.exists()) {
					dir.mkdirs();
				}

				file.createNewFile();
			}

			Reader r = new BufferedReader((new InputStreamReader(inputStream, codepage.toString())));
			Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, append), codepage.toString()));

			char[] buffer = new char[4096];
			int len;
			while ((len = r.read(buffer)) != -1) {
				w.write(buffer, 0, len);
			}

			r.close();
			w.flush();
			w.close();

		} catch (IOException e) {
			throw new BusinessException(e);
		}

		return file;
	}
}
