package com.tianyi.bph.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ TransactionalTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
@Transactional
// 这个非常关键，如果不加入这个注解配置，事务控制就会完全失效
// 这里的事务关联到配置文件中的事务控制器(transactionManager =
// "transactionManager")，同时指定自动回滚(defaultRollback = true).
// 这样做操作的数据库才不会污染数据库！
// @TransactionConfiguration(transactionManager = "txJdbcManager",
// defaultRollback = true)
@ContextConfiguration("classpath:spring/*.xml")
@ActiveProfiles("test")
public abstract class BaseTest {

}