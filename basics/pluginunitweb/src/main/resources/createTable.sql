CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(64) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户登录密码',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否有效 0 有效 1 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) DEFAULT NULL COMMENT '用户表id',
  `sys_role_id` int(11) DEFAULT NULL COMMENT '角色表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表与用户表的关联表';

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `descritpion` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '授权连接',
  `pid` int(11) DEFAULT NULL COMMENT '父节点id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `sys_permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(11) DEFAULT NULL COMMENT '角色表id',
  `sys_permission_id` int(11) DEFAULT NULL COMMENT '权限表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';