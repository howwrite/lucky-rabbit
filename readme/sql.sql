create table if not exists `user`
(
    `id`              bigint unsigned not null auto_increment primary key comment 'id',
    `nickname`        varchar(32)     not null comment '昵称',
    `password`        varchar(256)             default null comment '密码',
    `prefix`          varchar(8)               default null comment '手机国际区号',
    `mobile`          varchar(32)              default null comment '手机号码',
    `last_login_time` datetime comment '最后登录时间',
    `deleted`         bigint unsigned not null default 0 comment '逻辑删除',
    `deleted_time`    bigint                   default null comment '删除时间',
    `created_time`    bigint          not null comment '创建时间',
    `updated_time`    bigint          not null comment '记录修改时间',
    unique key `mobile_uni_key` (`prefix`, `mobile`, `deleted`)
) default charset = utf8mb4 comment = '用户主表';