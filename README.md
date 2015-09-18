# A maven plugin to use custom java code inside your maven build

With this plugin, you can put some java code in a source folder "src/build/java". The code will be executed during the maven build. Use annotations to bind the build classes to the maven lifecycle phases.

## Quickstart

The plugin requires minimum maven 3.1 

To test the plugin, de a "mvn install" on the projects in this order:

   1. javabuild-api
   1. javabuild-maven-plugin

Then to use the plugin in your project:

   1. declare the plugin in the project's pom.xml
   1. add dependency to javabuild-api
   1. create a folder "src/build/java"
   1. create classes and use the annotations
   
```xml
	<build>
		<plugins>
			<plugin>
				<groupId>test</groupId>
				<artifactId>javabuild-maven-plugin</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<extensions>true</extensions>
				<!-- For m2eclipse to detect the source folder -->
				<executions>
					<execution>
						<id>add-source</id>
						<goals>
							<goal>add-source</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	<dependencies>
		<dependency>
			<groupId>test</groupId>
			<artifactId>javabuild-api</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
```

```java
@Builder
public class MyCustomBuilder {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(MyCustomBuilder.class);

	@Execute(phase = Phase.GENERATE_SOURCES)
	public void sayHello() {
		LOGGER.info("Hello world");
	}
```

## Conventions

In your build classes, you can generate java sources, test sources, resources, add files to a webapp (for war projects) and add pages to the project's site. You just have to place the files in the following folders:

   * build classes: "src/build/java/"
   * build ressources: "src/build/resources/"
   * generated sources: "target/javabuild/main/java/"
   * generated ressources: "target/javabuild/main/resources/"
   * generated test sources: "target/javabuild/test/java/"
   * generated test resources: "target/javabuild/test/resources/"
   * additional files to include in the war file (for war projects): "target/javabuild/main/webapp/"
   * additional html pages to deploy in the project's site: "target/javabuild/site/"

For examples, look at project "javabuild-maven-plugin-test".

## Contents of this Git repository

   * javabuild-api: annotations to be used in your build classes
   * javabuild-maven-plugin: maven plugin/extension to be declared in the project's pom.xml
   * javabuild-maven-plugin-test: an example project
   