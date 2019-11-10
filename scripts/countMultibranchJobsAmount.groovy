// Get multibranch jobs' amount.

import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject

def jenkins = Jenkins.get()
def jobsName = jenkins.getJobNames()
def conut = 0
for (def jobName in jobsName) {
    if(jenkins.getItemByFullName(jobName).class =~ 'WorkflowMultiBranchProject') {
        conut ++
    }
}
println "Have ${conut} multibranch jobs totally."
