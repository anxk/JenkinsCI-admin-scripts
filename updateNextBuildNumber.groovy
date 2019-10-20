// Update the next build number and schedule a new build.

def jobName = 'test'
def nextBuildNum = 11
def jenkins = Jenkins.get()
def job = jenkins.getItemByFullName(jobName)
job.updateNextBuildNumber(nextBuildNum)

// schedule a new build with build number 11
job.scheduleBuild2(1)
