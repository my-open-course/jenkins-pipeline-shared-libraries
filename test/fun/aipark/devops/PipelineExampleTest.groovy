package fun.aipark.devops

import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.Before
import org.junit.Test

/**
 * @author LDC
 */
class PipelineExampleTest extends DeclarativePipelineTest {

    @Before
    @Override
    void setUp() {
        scriptRoots += 'jenkinsJobs'
        scriptExtension = 'Jenkinsfile'
        super.setUp()
    }

    @Test
    void jenkinsfile_should_execute_without_errors() {
        runScript("PipelineExample.Jenkinsfile")
        assertJobStatusSuccess()
        printCallStack()
    }
}
