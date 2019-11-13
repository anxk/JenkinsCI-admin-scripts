// Add TimerTrigger to jobs
import hudson.triggers.TimerTrigger;

j = Jenkins.get()
j.getJobNames().each {
    j.getItem(it).addTrigger(new TimerTrigger("* * * * *"))
    j.getItem(it).scheduleBuild2(5)
}
