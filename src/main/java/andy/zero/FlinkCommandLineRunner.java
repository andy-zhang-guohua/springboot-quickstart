package andy.zero;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlinkCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // 创建Flink任务运行的环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // 创建DataSet，数据是一行一行的文本
        DataSet<String> text = env.fromElements(
                "Flink Hello World",
                "Flink Flink World",
                "Hive Elastic Search",
                "Hadoop Hive zookeeper",
                "Hello World Hello"
        );

        // 通过Flink内置的转换函数进行计算
        DataSet<Tuple2<String, Integer>> counts = text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            /**
             *
             * @param value 要处理的值，这里对应上面 text 中的一行
             * @param collector
             * @throws Exception
             */
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
                // 将文本分割
                String[] tokens = value.toLowerCase().split("\\W+");

                for (String token : tokens) {
                    if (token.length() > 0) {
                        collector.collect(new Tuple2<String, Integer>(token, 1));
                    }
                }
            }
        }).groupBy(0).sum(1);

        //结果打印
        counts.printToErr();
    }
}
