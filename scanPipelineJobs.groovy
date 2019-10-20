import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob


def jenkins = Jenkins.get()
def allJobNames = jenkins.getJobNames()
def allJobs = []
for (def jobName in allJobNames) {
    allJobs.add(jenkins.getItemByFullName(jobName))
}

def workFlowJobs = allJobs.findAll {it instanceof WorkflowJob} // not multibranch pipeline job
def standardWorkFlowJobs = workFlowJobs.findAll {!(it.getDefinition() instanceof CpsFlowDefinition)}
def targetJobs = standardWorkFlowJobs.findAll {inspect(it.getConfigFile().asString())}

all = []
for (def i in targetJobs) {
    if (i.fullName ==~ '(.*CI_2.*)|(.*feature.*)|(.*release.*)|(.*master.*)|(.*main.*)|(.*ci_test.*)') {
        temp = i.fullName.getAt(0..i.fullName.lastIndexOf('/'))
    }
    else {
        temp = i.fullName
    }
    if (!all.contains(temp)) {
        all.add(temp)
    }
}

def count = 0
all.each {println "${count} --> $it";count++}


def inspect(String script) {
    if (script =~ 'gerrit.zte.com.cn') {
        return true
    } else {
        return false
    }
}