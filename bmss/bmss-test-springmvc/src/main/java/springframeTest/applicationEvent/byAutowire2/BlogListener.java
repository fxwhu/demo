package springframeTest.applicationEvent.byAutowire2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class BlogListener {

    @EventListener(condition = "#event.importantChange")
    public void blogModified(BlogModifieEvent event){
        System.out.println("listen to blog change " + event.getMessage());
    }
}
