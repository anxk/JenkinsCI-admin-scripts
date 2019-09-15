import com.cloudbees.workflow.flownode.FlowNodeUtil
import org.jenkinsci.plugins.workflow.job.WorkflowRun


// Replace buildNum and jobName with yours.
def buildNum = 1
def jobName = 'test'

def build = Jenkins.get().getItem(jobName).builds.find {
	it.toString() =~ "#${buildNum}"
}
def id = build.getExternalizableId()
// invalidate the build cache of the Stage View
FlowNodeUtil.CacheExtension.all().get(0).getRunCache().invalidate(id)
