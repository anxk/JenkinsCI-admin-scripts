// Add TimerTrigger to jobs

j = Jenkins.get()
j.getJobNames().each {
    j.getItem(it).addTrigger(new TimerTrigger("* * * * *"))
    j.getItem(it).scheduleBuild2(5)
}
