def q = Jenkins.get().queue
q.getItems().each{
	if(it.getCauses() =~ 'TimerTrigger') {
		q.cancel(it)
	}
}
