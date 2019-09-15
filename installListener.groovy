// install a listener

def jobName = 'test'
def item = Jenkins.get().getItemByFullName(jobName)

public class myListener extends listeners.ItemListener {
    public static void onStart(Item item) {
        item.scheduleBuild2(20)
    }
}
new myListener().onStart(item)