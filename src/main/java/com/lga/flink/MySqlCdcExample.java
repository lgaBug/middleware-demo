package com.lga.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.connectors.mysql.table.StartupOptions;

public class MySqlCdcExample {

    public static void main(String[] args) throws Exception {
        // 创建 Flink 执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1); // 为了便于观察，设置并行度为 1

        // 配置 MySQL CDC 源
        MySqlSource<String> mySqlSource = MySqlSource.<String>builder()
                .hostname("localhost")         // MySQL 主机名
                .port(3306)                   // MySQL 端口
                .databaseList("test_db")      // 要监控的数据库，多个用逗号分隔
                .tableList("test_db.users")   // 要监控的表，格式为"数据库.表名"，多个用逗号分隔
                .username("flink_cdc")        // MySQL 用户名
                .password("password")         // MySQL 密码
                .deserializer(new com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema()) // 使用 JSON 格式进行反序列化
                .startupOptions(StartupOptions.initial()) // 从头开始读取历史数据
                .build();

        // 添加 CDC 源并打印捕获的变更
        env.fromSource(mySqlSource, WatermarkStrategy.noWatermarks(), "MySQL CDC Source")
                .print(); // 将捕获的变更打印到控制台

        // 执行作业
        env.execute("MySQL CDC Example");
    }
}
