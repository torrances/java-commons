package com.trimc.blogger.commons.utils.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;

public class FileUtils$Get {

	public static LogManager logger = new LogManager(FileUtils.class);

	protected static Collection<File> getDescendantFilesInFolder(File foldername, String ext) throws BusinessException {
		return getDescendantFilesInFolder(foldername.getAbsolutePath(), ext);
	}

	protected static Collection<File> getDescendantFilesInFolder(String foldername, String ext) throws BusinessException {
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
				if (fileName.equals(".DS_Store")) continue; // TODO: build up a list of exclusions

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
}
