package com.huang.optimize.concurrency.executors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    private ConcurrentHashMap<String,String> valueHashMap = new ConcurrentHashMap<String,String>();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<String> inputValue = new ArrayList<String>();
        inputValue.add("a");
        inputValue.add("b");
        inputValue.add("c");
        inputValue.add("d");

        for(String oneValue : inputValue) {
            Map<String,String> oneValueMap = new HashMap<>();
            oneValueMap.put(oneValue,oneValue);
            //executorService.submit(new MyCallable(oneValueMap));
        }

    }

    static  class  MyCallable implements Callable<Map<String, String>> {


        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Map<String, String> call() throws Exception {
            return null;
        }
    }

}

