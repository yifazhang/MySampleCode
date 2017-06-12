package ResponsibilityChain.Web;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class Main {

    public static void main(String[] args) {
        String name = "大家好,123@126.com,<script>,敏感,被就业,今天很开心";

        Request request = new Request();
        request.setRequestStr(name);

        Response response = new Response();
        response.setResponseStr("response");

        FilterChain fc = new FilterChain();
        fc.addFilter(new HtmlFilter())
                .addFilter(new SesitiveFilter())
                .addFilter(new CharFilter());

        fc.doFilter(request,response,fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }

}
