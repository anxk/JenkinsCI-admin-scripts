// Install a listener, this is a example to install a listener which 
// trigger item(`test`) again with a slience time of 20 seconds when
// `test` is started.

def jobName = 'test'
def jenkins = Jenkins.get()
def item = jenkins.getItemByFullName(jobName)

public class myListener extends listeners.ItemListener {
    public static void onStart(Item item) {
        item.scheduleBuild2(20)
    }
}
new myListener().onStart(item)
