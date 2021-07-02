package andy.zero.hasor;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.dataql.DataQL;

public class DataQueryContext {
    private static AppContext appContext = null;
    private static DataQL dataQL     = null;
    public static DataQL getDataQL() {
        if (appContext == null) {
            appContext = Hasor.create().build();
            dataQL = appContext.getInstance(DataQL.class);
        }
        return dataQL;
    }
}