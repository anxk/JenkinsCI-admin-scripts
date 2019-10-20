// Force abort a build.

def jobName = "test"
def buildNum = 1

def jenkins = Jenkins.get()
def targetBuild = jenkins.getItemByFullName(jobName).getBuildByNumber(buildNum)

// abort it
targetBuild.finish(hudson.model.Result.ABORTED, new java.io.IOException("Aborting build")); 
