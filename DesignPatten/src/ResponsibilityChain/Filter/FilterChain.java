package ResponsibilityChain.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<Filter>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public String doFilter(String str) {
        String r = str;
        for(Filter filter : filters) {
            r = filter.doFilter(r);
        }
        return r;
    }

}
