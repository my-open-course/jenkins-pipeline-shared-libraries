package fun.aipark.devops

import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.Before
import org.junit.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource

/**
 * @author LDC
 */
class MathArithmeticTest extends DeclarativePipelineTest {

    @Before
    @Override
    void setUp() {
        scriptRoots += 'jenkinsJobs'
        scriptExtension = 'Jenkinsfile'

        def library = library().name('jenkins-pipeline-shared-libraries')
                .defaultVersion('<notNeeded>')
                .allowOverride(true)
                .implicit(true)
                .targetPath('<notNeeded>')
                .retriever(projectSource())
                .build()
        helper.registerSharedLibrary(library)

        super.setUp()
    }

    @Test
    void groovy_should_execute_without_errors() {
        def script = loadScript('vars/mathArithmetic.groovy')
        println("Result: " + script.add(1, 3))
        printCallStack()
        assertJobStatusSuccess()
    }

    @Test
    void jenkinsfile_should_execute_without_errors() {
        runScript("SharedLibrary.Jenkinsfile")
        assertJobStatusSuccess()
        printCallStack()
    }
}
