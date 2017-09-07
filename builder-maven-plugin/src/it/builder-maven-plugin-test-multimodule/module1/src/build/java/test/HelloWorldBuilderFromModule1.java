package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.java.javabuild.Builder;
import net.java.javabuild.Execute;
import net.java.javabuild.Phase;

/**
 * A builder that writes a message in the log at various phases of the build
 * cycle.
 */
@Builder
public class HelloWorldBuilderFromModule1 {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(HelloWorldBuilderFromModule1.class);

	@Execute(phase = Phase.GENERATE_SOURCES)
	public void sayHello() {
		LOGGER.info("Hello world from generate-sources phase! (module1)");
	}

	@Execute(phase = Phase.INSTALL)
	public void sayHelloFromInstallPhase() {
		LOGGER.info("Hello world from install phase! (module1)");
	}
}
