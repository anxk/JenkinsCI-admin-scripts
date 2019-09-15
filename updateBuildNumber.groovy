// Update the next build number and schedule a new build.

def jobName = 'test'
def nextBuildNum = 11
def job = Jenkins.get().getItemByFullName(jobName)
job.updateNextBuildNumber(nextBuildNum)
job.scheduleBuild2(1)
