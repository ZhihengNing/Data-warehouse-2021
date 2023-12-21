create table all_all
(
    crew1       varchar(255) comment '人员1',
    crew2       varchar(255) comment '人员2',
    asin        array<string> comment '电影数组',
    cooperation varchar(255) comment '关系'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('colelction.delim' = '-', 'field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/all_all';

create table crew
(
    name varchar(255) comment '人员名称'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/crew';

create table review
(
    asin        varchar(255) comment '电影Id',
    user_id     varchar(255) comment '用户id',
    rating      int comment '评论评分',
    review_sum  varchar(255) comment '评论总结',
    review_date date comment '评论日期',
    helpfulness int comment '认为有帮助的人数'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/review';

create table role
(
    name varchar(255) comment '人员名称',
    asin varchar(255) comment '电影Id',
    role varchar(255) comment '人员角色'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/role';

create table users
(
    id   varchar(255) comment '用户Id',
    name varchar(255) comment '用户名字'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/users';

create table movie
(
    asin              varchar(255) comment '电影Id',
    title             varchar(255) comment '电影标题',
    star_rating       decimal(2, 1) comment '电影评分',
    production        varchar(255) comment '电影形式',
    run_time          varchar(255) comment '电影长度',
    release_day       date comment '发行日期',
    release_year      int comment '发行年份',
    release_month     int comment '发行月份',
    release_season    varchar(255) comment '发行季节',
    style             varchar(255) comment '电影类别',
    directors         array<string> comment '导演',
    actors            array<string> comment '演员',
    additional_option array<string> comment '附加版本',
    other_format      array<string> comment '其他版本'
)
    row format serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
        with serdeproperties ('colelction.delim' = '-', 'field.delim' = ',') stored as
    inputformat 'org.apache.hadoop.mapred.TextInputFormat'
    outputformat 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
    location 'hdfs://namenode:8020/user/hive/warehouse/movie';