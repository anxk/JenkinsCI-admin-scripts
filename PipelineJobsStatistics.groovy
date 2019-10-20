//
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob


def jenkins = Jenkins.getInstance()
def allJobsName = jenkins.getJobNames()
def allJobs = []
for (def jobName in allJobsName) {
    allJobs.add(jenkins.getItemByFullName(jobName))
}
println "This Jenkins has ${allJobs.size()} jobs totally!"
assert allJobs.size() == allJobsName.size()

def workFlowJobs = allJobs.findAll {it instanceof WorkflowJob}
println "This Jenkins has ${workFlowJobs.size()} pipeline jobs totally!"

def standardWorkFlowJobs = workFlowJobs.findAll {it.getDefinition() instanceof CpsFlowDefinition}
println "This Jenkins has ${standardWorkFlowJobs.size()} non-branch jobs totally!"

def invalidJobs = standardWorkFlowJobs.findAll {inspect(it.getDefinition().getScript())}
println "This Jenkins has ${invalidJobs.size()} invalid pipeline jobs totally!"
def count = 0
invalidJobs.each{println "#${count++}. 访问MTE --> ${it.fullName}"}

println ''

def inspect(String script) {
    if (script =~ 'http://10.9.176.120:8888/') {
        return true
    } else {
        return false
    }
}