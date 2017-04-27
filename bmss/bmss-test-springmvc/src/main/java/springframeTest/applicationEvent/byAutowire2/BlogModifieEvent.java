package springframeTest.applicationEvent.byAutowire2;

import org.springframework.context.ApplicationEvent;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
public class BlogModifieEvent extends ApplicationEvent{

    private final String message;

    private final boolean importantChange;

    public BlogModifieEvent(String message, boolean importantChange) {
        super(message);
        this.message = message;
        this.importantChange = importantChange;
    }

    public String getMessage() {
        return message;
    }

    public boolean isImportantChange() {
        return importantChange;
    }
}
