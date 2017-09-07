package net.java.javabuild;

import java.io.File;

public class BuilderFolders {
	private BuilderFolders() {
		// Do not instantiate, only constants
	}

	// Following properties are package private to avoid builders (classes annotated with @Builder annotation)
	// using them
	final static String BUILD_SOURCES = "src/build/java/";
	final static String BUILD_RESOURCES = "src/build/resources/";
	final static String GENERATED_SOURCES = "target/builder/main/java/";
	final static String GENERATED_RESOURCES = "target/builder/main/resources/";
	final static String GENERATED_TEST_SOURCES = "target/builder/test/java/";
	final static String GENERATED_TEST_RESOURCES = "target/builder/test/resources/";
	final static String WEBAPP_RESOURCES = "target/builder/main/webapp/";
	final static String SITE = "target/builder/site/";

	// Following methods must only be used by builders.
	public final static String getBuildSources() {
		return dir(BUILD_SOURCES);
	}

	public final static String getBuildResources() {
		return dir(BUILD_RESOURCES);
	}

	public final static String getTestResources() {
		return dir("src/test/resources/");
	}

	public final static String getGeneratedSources() {
		return dir(GENERATED_SOURCES);
	}

	public final static String getGeneratedResources() {
		return dir(GENERATED_RESOURCES);
	}

	public final static String getGeneratedTestSources() {
		return dir(GENERATED_TEST_SOURCES);
	}

	public final static String getGeneratedTestResources() {
		return dir(GENERATED_TEST_RESOURCES);
	}

	public final static String getWebappResources() {
		return dir(WEBAPP_RESOURCES);
	}

	public final static String getSite() {
		return dir(SITE);
	}

	private static String dir(String relativePath) {
		// The current directory is dynamic because a maven project can have multiple modules
		// in different directories
		String currentDirectory = System.getProperty("user.dir");

		return new File(currentDirectory, relativePath).getAbsolutePath();
	}
}
