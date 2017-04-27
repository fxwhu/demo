package bmss;

import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public class JythonEnvironment {

    private volatile static JythonEnvironment instance;

    private JythonEnvironment() {
    }

    public static JythonEnvironment getInstance(){
        if(instance == null){
            synchronized (JythonEnvironment.class){
                if(instance == null){
                    instance = new JythonEnvironment();
                }
            }
        }
        return instance;
    }


    private PySystemState getPySystemState(){
        PySystemState.initialize();
        final PySystemState py = new PySystemState();
        py.setClassLoader(getClass().getClassLoader());
        return py;
    }

    public PythonInterpreter getPythonInterpreter(){
        PythonInterpreter inter = new PythonInterpreter(null, getPySystemState());
        return inter;
    }
}
