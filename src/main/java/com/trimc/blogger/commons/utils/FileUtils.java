package com.trimc.blogger.commons.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;

public final class FileUtils {

	public static LogManager	logger	= new LogManager(FileUtils.class);

	public static void delete(File f) {
		Path dir = Paths.get(f.getAbsolutePath());
		try {

			Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					if (exc == null) {
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					} else throw exc;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println("Deleting file: " + file);
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Collection<File> getDescendantFilesInFolder(File foldername, String ext) throws BusinessException {
		return getDescendantFilesInFolder(foldername.getAbsolutePath(), ext);
	}

	public static Collection<File> getDescendantFilesInFolder(String foldername, String ext) throws BusinessException {
		File f = new File(foldername);
		ArrayList<File> files = new ArrayList<File>();

		try {

			getFiles(f, files, ext, null);

		} catch (Exception e) {
			logger.error(e);
			throw new BusinessException(e);
		}

		return files;
	}

	public static String getExtension(File file) {
		if (file.getName().contains(".")) return StringUtils.substringAfterLast(file.getName(), ".");
		return null;
	}

	private static void getFiles(File parentFile, ArrayList<File> files, String fileExtension, String folder) throws Exception {
		File[] fileList = parentFile.listFiles();
		if (null == fileList) return;

		for (int p = 0; p < fileList.length; p++) {

			if (fileList[p].isDirectory()) {

				if (null == folder) getFiles(fileList[p], files, fileExtension, folder);

				else {
					String formatPath = fileList[p].getPath().replaceAll("\\\\", "/");
					if (formatPath.endsWith("/" + folder) == false) getFiles(fileList[p], files, fileExtension, folder);
				}
			}

			else {

				String fileName = fileList[p].getName();

				/* no filter */
				if (fileExtension == null || fileExtension.compareTo("*") == 0) files.add(fileList[p]);

				/* filter extension */
				else if (fileName.toLowerCase().endsWith("." + fileExtension.toLowerCase())) files.add(fileList[p]);

				/* filter empty extension */
				else if (fileExtension.compareTo("") == 0 && fileName.contains(".") == false) files.add(fileList[p]);
			}
		}
	}

	public static List<File> getFiles(List<String> paths) {
		List<File> list = new ArrayList<File>();

		for (String path : paths) {
			File file = new File(path);
			if (file.isDirectory()) {
				for (File f : getFilesFromPath(file.getAbsolutePath())) {
					list.add(f);
				}
			} else if (file.exists()) {
				list.add(file);
			}

			else {
				logger.error("File Not Found (%s)", file.getAbsolutePath());
			}
		}

		return list;
	}

	private static void getFilesFromPath(List<File> list, File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				getFilesFromPath(list, child);
			}
		} else {
			list.add(file);
		}
	}

	public static List<File> getFilesFromPath(String path) {
		List<File> list = new ArrayList<File>();

		File file = new File(path);
		if (file.exists()) {
			getFilesFromPath(list, file);
		}

		return list;
	}

	public static String getName(File file) {
		if (!file.getName().contains(".")) return file.getName();
		return StringUtils.substringBeforeLast(file.getName(), ".").trim();
	}

	public static Collection<File> toCollection(File... files) {
		List<File> list = new ArrayList<File>();

		for (File file : files)
			list.add(file);

		return list;
	}

	public static File toFile(Collection<String> list, String filename, boolean append, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toString(list, System.lineSeparator()), filename, append, codepage);
	}

	public static File toFile(Collection<String> list, String filename, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toString(list, System.lineSeparator()), filename, codepage);
	}

	public static File toFile(InputStream inputStream, String filename, boolean append, Codepage codepage) throws BusinessException {
		File file = new File(filename);

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

	public static File toFile(InputStream inputStream, String fileName, Codepage codepage) throws BusinessException {
		return toFile(inputStream, fileName, false, codepage);
	}

	public static File toFile(String str, String fileName, boolean append, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), fileName, append, codepage);
	}

	public static File toFile(String str, String fileName, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), fileName, codepage);
	}

	public static File toFile(StringBuffer sb, String fileName, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), fileName, append, codepage);
	}

	public static File toFile(StringBuffer sb, String filename, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), filename, codepage);
	}

	public static File toFile(StringBuilder sb, String fileName, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), fileName, append, codepage);
	}

	public static File toFile(StringBuilder sb, String filename, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), filename, codepage);
	}

	public static List<File> toList(File... files) {
		List<File> list = new ArrayList<File>();

		for (File file : files) {
			list.add(file);
		}

		return list;
	}

	public static Collection<String> toList(File file, Codepage codepage) throws BusinessException {
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

	public static Collection<String> toList(String file, Codepage codepage) throws BusinessException {
		return toList(new File(file), codepage);
	}

	public static String toString(File file, Codepage codepage) throws BusinessException {
		return StringUtils.toString(toList(file, codepage), " ");
	}
}
