// Inspect pipeline jobs whose script contains some text.
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob

def pattern = '.*gerrit\\.xxx\\.com\\.cn.*'
def jenkins = Jenkins.get()
def allJobNames = jenkins.getJobNames()
def allJobs = []
for (def jobName in allJobNames) {
    allJobs.add(jenkins.getItemByFullName(jobName))
}

// not multibranch pipeline job
def workFlowJobs = allJobs.findAll {
    it instanceof WorkflowJob
}

// not CpsFlowPipeline
def standardWorkFlowJobs = workFlowJobs.findAll {
    !(it.getDefinition() instanceof CpsFlowDefinition)
}

// find jobs whose script contain `pattern`
def targetJobs = standardWorkFlowJobs.findAll {
    inspect(it.getConfigFile().asString(), pattern)
}

// show the scan result
def count = 0
targetJobs.each {
    println "#${count}: $it"
    count++
}

// filter function
def inspect(String script, String pattern) {
    if (script ==~ pattern) {
        return true
    } else {
        return false
    }
}