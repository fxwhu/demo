package bmss;

import org.python.util.PythonInterpreter;

import java.util.Map;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public enum ExecPython {
    INSTANCE;

    public void execute(String scriptFile, Map<String,String> properties)
    {
        //获取python解释器
        final PythonInterpreter inter = JythonEnvironment.getInstance().getPythonInterpreter();

        //设置python属性,python脚本中可以使用
        for (Map.Entry<String,String> entry : properties.entrySet())
        {
            inter.set(entry.getKey(), entry.getValue());
        }

        try {
            //通过python解释器调用python脚本
            inter.execfile(scriptFile);
        } catch (Exception e) {
            System.out.println("ExecPython encounter exception:" + e);
        }
    }
}
