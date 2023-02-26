package Qnum7;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class WebCrawler {
    private static final int NUM_THREADS = 10;

    public WebCrawler() {
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> results = new ArrayList();

        for(int i = 0; i < 100; ++i) {
            results.add(executorService.submit(new WebCrawler.CrawlTask("https://schoolworkspro.com/" + i)));
        }

        Iterator var7 = results.iterator();

        while(var7.hasNext()) {
            Future result = (Future)var7.next();

            try {
                System.out.println((String)result.get());
            } catch (ExecutionException | InterruptedException var6) {
                System.out.println("Task failed: " + var6.getMessage());
            }
        }

        executorService.shutdown();
    }

    private static class CrawlTask implements Callable<String> {
        private final String url;

        public CrawlTask(String url) {
            this.url = url;
        }

        public String call() throws Exception {
            return "Crawled " + this.url;
        }
    }
}
