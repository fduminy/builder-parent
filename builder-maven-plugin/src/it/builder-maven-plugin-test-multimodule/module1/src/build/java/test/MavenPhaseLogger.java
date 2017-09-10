package test;

import net.java.javabuild.Builder;
import net.java.javabuild.Execute;
import net.java.javabuild.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Set;

import static java.nio.file.StandardOpenOption.*;
import static net.java.javabuild.Phase.*;

/**
 * A builder that append phases of the build cycle into a file.
 */
@Builder
public class MavenPhaseLogger {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(MavenPhaseLogger.class);

    private static final Path TARGET_FILE = new File("target/builder/Phases.txt").getAbsoluteFile().toPath();

    @Execute(phase = GENERATE_SOURCES) public void logGenerateSources() throws IOException {
        logPhase(GENERATE_SOURCES);
    }

    @Execute(phase = PROCESS_SOURCES) public void logProcessSources() throws IOException {
        logPhase(PROCESS_SOURCES);
    }

    @Execute(phase = GENERATE_RESOURCES) public void logGenerateResources() throws IOException {
        logPhase(GENERATE_RESOURCES);
    }

    @Execute(phase = PROCESS_RESOURCES) public void logProcessResources() throws IOException {
        logPhase(PROCESS_RESOURCES);
    }

    @Execute(phase = COMPILE) public void logCompile() throws IOException {
        logPhase(COMPILE);
    }

    @Execute(phase = PROCESS_CLASSES) public void logProcessClasses() throws IOException {
        logPhase(PROCESS_CLASSES);
    }

    @Execute(phase = GENERATE_TEST_SOURCES) public void logGenerateTestSources() throws IOException {
        logPhase(GENERATE_TEST_SOURCES);
    }

    @Execute(phase = PROCESS_TEST_SOURCES) public void logProcessTestSources() throws IOException {
        logPhase(PROCESS_TEST_SOURCES);
    }

    @Execute(phase = GENERATE_TEST_RESOURCES) public void logGenerateTestResources() throws IOException {
        logPhase(GENERATE_TEST_RESOURCES);
    }

    @Execute(phase = PROCESS_TEST_RESOURCES) public void logProcessTestResources() throws IOException {
        logPhase(PROCESS_TEST_RESOURCES);
    }

    @Execute(phase = TEST_COMPILE) public void logTestCompile() throws IOException {
        logPhase(TEST_COMPILE);
    }

    @Execute(phase = PROCESS_TEST_CLASSES) public void logProcessTestClasses() throws IOException {
        logPhase(PROCESS_TEST_CLASSES);
    }

    @Execute(phase = TEST) public void logTest() throws IOException {
        logPhase(TEST);
    }

    @Execute(phase = PREPARE_PACKAGE) public void logPreparePackage() throws IOException {
        logPhase(PREPARE_PACKAGE);
    }

    @Execute(phase = PACKAGE) public void logPackage() throws IOException {
        logPhase(PACKAGE);
    }

    @Execute(phase = PRE_INTEGRATION_TEST) public void logPreIntegrationTest() throws IOException {
        logPhase(PRE_INTEGRATION_TEST);
    }

    @Execute(phase = INTEGRATION_TEST) public void logIntegrationTest() throws IOException {
        logPhase(INTEGRATION_TEST);
    }

    @Execute(phase = POST_INTEGRATION_TEST) public void logPostIntegrationTest() throws IOException {
        logPhase(POST_INTEGRATION_TEST);
    }

    @Execute(phase = VERIFY) public void logVerify() throws IOException {
        logPhase(VERIFY);
    }

    @Execute(phase = INSTALL) public void logInstall() throws IOException {
        logPhase(INSTALL);
    }

    @Execute(phase = DEPLOY) public void logDeploy() throws IOException {
        logPhase(DEPLOY);
    }

    @Execute(phase = PRE_SITE) public void logPreSite() throws IOException {
        logPhase(PRE_SITE);
    }

    @Execute(phase = SITE) public void logSite() throws IOException {
        logPhase(SITE);
    }

    @Execute(phase = POST_SITE) public void logPostSite() throws IOException {
        logPhase(POST_SITE);
    }

    @Execute(phase = SITE_DEPLOY) public void logSiteDeploy() throws IOException {
        logPhase(SITE_DEPLOY);
    }

    private Set<Phase> phases = EnumSet.noneOf(Phase.class);

    private void logPhase(Phase phase) throws IOException {
        LOGGER.info("Entered into phase {}", phase);
        if (phases.add(phase)) {
            Files.createDirectories(TARGET_FILE.getParent());
            String line = phase.toString() + System.getProperty("line.separator");
            Files.write(TARGET_FILE, line.getBytes(), CREATE, WRITE, APPEND);
        }
    }
}
