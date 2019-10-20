import hudson.model.Cause.UserIdCause
import hudson.model.Cause
import jenkins.model.Jenkins

public static void main(String[] args) {
    String userId = '10221022'
    String jobName = 'G5_NR_V3/DailyCI/VersionCI_VNF/master'
    int quietPeriod = 10

    Cause userIdCause = new UserIdCause(userId)
    if (!(userIdCause.getUserName() ==~    'anonymous|unknown')) {
        CauseAction action = new CauseAction(userIdCause)
        jenkins = Jenkins.get()
        jenkins.getItemByFullName(jobName)
            .scheduleBuild2(quietPeriod, action)
    }
}
