// Statics of jobs.
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob


def jenkins = Jenkins.get()
def allJobsName = jenkins.getJobNames()
def allJobs = []
for (def jobName in allJobsName) {
    allJobs.add(jenkins.getItemByFullName(jobName))
}

def workFlowJobs = allJobs.findAll {
    it instanceof WorkflowJob
}

def standardWorkFlowJobs = workFlowJobs.findAll {
    it.getDefinition() instanceof CpsFlowDefinition
}

// show the result
println "This Jenkins has ${allJobs.size()} jobs totally!"
println "This Jenkins has ${workFlowJobs.size()} pipeline jobs totally!"
println "This Jenkins has ${standardWorkFlowJobs.size()} non-branch jobs totally!"
