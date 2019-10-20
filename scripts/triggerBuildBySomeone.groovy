// Trigger a build in a user in jenkins's user database.
import hudson.model.Cause.UserIdCause
import hudson.model.Cause
import jenkins.model.Jenkins


public static void main(String[] args) {
    String userId = 'xiaoming'
    String jobName = 'test'
    int quietPeriod = 10

    Cause userIdCause = new UserIdCause(userId)
    if (!(userIdCause.getUserName() ==~ 'anonymous|unknown')) {
        CauseAction action = new CauseAction(userIdCause)
        jenkins = Jenkins.get()
        jenkins.getItemByFullName(jobName)
            .scheduleBuild2(quietPeriod, action)
    }
}
