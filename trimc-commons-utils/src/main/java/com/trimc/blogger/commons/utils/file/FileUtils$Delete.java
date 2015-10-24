package com.trimc.blogger.commons.utils.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.trimc.blogger.commons.LogManager;

public class FileUtils$Delete {

	public static LogManager logger = new LogManager(FileUtils.class);

	protected static void delete(File f) {
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
}
