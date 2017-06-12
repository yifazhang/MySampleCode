package ResponsibilityChain.Filter;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class Main {

    public static void main(String[] args) {
        String name = "大家好,123@126.com,<script>,敏感,被就业,今天很开心";
        MsgProcessor mp = new MsgProcessor();
        mp.setMsg(name);

        FilterChain fc = new FilterChain();
        fc.addFilter(new HtmlFilter())
                .addFilter(new SesitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new CharFilter());

        fc.addFilter(fc2);

        mp.setFc(fc);
        name = mp.process();
        System.out.println(name);
    }

}
