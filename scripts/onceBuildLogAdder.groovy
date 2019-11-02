import hudson.model.listeners.RunListener;
import hudson.model.TaskListener;
import hudson.model.Run;
import java.io.PrintStream;
import javax.annotation.Nonnull;

public class myListener extends RunListener<Run> {
  
  public myListener() {
    ExtensionList.lookup(RunListener.class).add(this)
  }
  
  public void onCompleted(Run<?, ?> r, @Nonnull TaskListener listener) {
    PrintStream logger = listener.getLogger()
    logger.println("Something")
  }
  
}

new myListener()

// RunListener.all()