package bmss.test;

import bmss.ExecPython;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public enum TestExecPython {
    INSTANCE;

    public void test() {
        String scriptFile = "bmss-test-leconf-dubbo\\bmss-test-java-language\\bmss-test-java-python\\py\\test.py";
        Map<String,String> properties = new HashMap<String,String>();
        properties.put("userName", "Demo");

        ExecPython.INSTANCE.execute(scriptFile, properties);

    }
}
