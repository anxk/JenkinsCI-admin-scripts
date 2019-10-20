import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject
def jobs = Jenkins.get().getJobNames()
def workflowJobsConut = 0
for (def job in jobs) {
    if(Jenkins.get().getItemByFullName(job).class =~ 'WorkflowMultiBranchProject') {
        workflowJobsConut ++
            }
}
println workflowJobsConut