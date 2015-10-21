package com.trimc.blogger.commons.utils.file;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;
import com.trimc.blogger.commons.utils.string.StringUtils;

public final class FileUtils {

	public static LogManager logger = new LogManager(FileUtils.class);

	public static void delete(File f) {
		FileUtils$Delete.delete(f);
	}

	public static Collection<File> getDescendantFilesInFolder(File foldername, String ext) throws BusinessException {
		return getDescendantFilesInFolder(foldername.getAbsolutePath(), ext);
	}

	public static Collection<File> getDescendantFilesInFolder(String foldername, String ext) throws BusinessException {
		return FileUtils$Get.getDescendantFilesInFolder(foldername, ext);
	}

	public static String getExtension(File file) {
		if (file.getName().contains(".")) return StringUtils.substringAfterLast(file.getName(), ".");
		return null;
	}

	public static List<File> getFiles(List<String> paths) {
		return FileUtils$Get.getFiles(paths);
	}

	public static List<File> getFiles(String... paths) {
		return getFiles(Arrays.asList(paths));
	}

	public static List<File> getFilesFromPath(String path) {
		return FileUtils$Get.getFilesFromPath(path);
	}

	public static String getName(File file) {
		if (!file.getName().contains(".")) return file.getName();
		return StringUtils.substringBeforeLast(file.getName(), ".").trim();
	}

	public static void mergeIntoSingleFile(String foldername, String ext, Codepage codepage, File output) throws BusinessException {
		mergeIntoSingleFile(foldername, ext, codepage, output, true);
	}

	public static void mergeIntoSingleFile(String foldername, String ext, Codepage codepage, File output, boolean enableLogging) throws BusinessException {
		FileUtils$Create.mergeIntoSingleFile(foldername, ext, codepage, output, enableLogging);
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

	public static File toFile(InputStream inputStream, File file, boolean append, Codepage codepage) throws BusinessException {
		return FileUtils$Create.toFile(inputStream, file, append, codepage);
	}

	public static File toFile(InputStream inputStream, File file, Codepage codepage) throws BusinessException {
		return toFile(inputStream, file, false, codepage);
	}

	public static File toFile(InputStream inputStream, String file, boolean append, Codepage codepage) throws BusinessException {
		return FileUtils$Create.toFile(inputStream, new File(file), append, codepage);
	}

	public static File toFile(InputStream inputStream, String file, Codepage codepage) throws BusinessException {
		return toFile(inputStream, file, false, codepage);
	}

	public static File toFile(String str, File file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), file, append, codepage);
	}

	public static File toFile(String str, File file, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), file, codepage);
	}

	public static File toFile(String str, String file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), file, append, codepage);
	}

	public static File toFile(String str, String file, Codepage codepage) throws BusinessException {
		return toFile(StringUtils.toInputStream(str, codepage), file, codepage);
	}

	public static File toFile(StringBuffer sb, File file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, append, codepage);
	}

	public static File toFile(StringBuffer sb, File file, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, codepage);
	}

	public static File toFile(StringBuffer sb, String file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, append, codepage);
	}

	public static File toFile(StringBuffer sb, String file, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, codepage);
	}

	public static File toFile(StringBuilder sb, File file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, append, codepage);
	}

	public static File toFile(StringBuilder sb, File file, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, codepage);
	}

	public static File toFile(StringBuilder sb, String file, boolean append, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, append, codepage);
	}

	public static File toFile(StringBuilder sb, String file, Codepage codepage) throws BusinessException {
		return toFile(sb.toString(), file, codepage);
	}

	public static List<File> toList(File... files) {
		return FileUtils$Read.toList(files);
	}

	public static Collection<String> toList(File file, Codepage codepage) throws BusinessException {
		return FileUtils$Read.toList(file, codepage);
	}

	public static Collection<String> toList(String file, Codepage codepage) throws BusinessException {
		return toList(new File(file), codepage);
	}

	public static String toString(File file, Codepage codepage) throws BusinessException {
		return toString(file, codepage, " ");
	}

	public static String toString(File file, Codepage codepage, String delimiter) throws BusinessException {
		return StringUtils.toString(toList(file, codepage), delimiter);
	}
}
