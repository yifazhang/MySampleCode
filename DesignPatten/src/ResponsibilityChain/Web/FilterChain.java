package ResponsibilityChain.Web;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<Filter>();
    int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
       if (index == filters.size()) return;

       Filter filter = filters.get(index);
       index ++;
       filter.doFilter(request, response, chain);


    }
}
