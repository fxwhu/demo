**1.spring动态代理，本类中调用的方式:**
extend ApplicationObjectSupport 使用getApplicationContext().getBean(TestAsync.class).test3();
详见TestAsync


**2.关于spring事务中select...for update失效问题 时间设置稍长一点**
mysql> show variables like 'innodb_lock_wait_timeout';
+--------------------------+-------+
| Variable_name            | Value |
+--------------------------+-------+
| innodb_lock_wait_timeout | 50    |
+--------------------------+-------+
1 row in set
详见:data-mysql db

**3.关于for update锁表还是锁行的问题**
举个例子: 
假设有个表单products ，里面有id 跟name 二个栏位，id 是主键。 
例1: (明确指定主键(有包含)，并且有此数据，row lock) 
SELECT * FROM products WHERE id='3' FOR UPDATE;
例2: (明确指定主键，若查无此数据，无lock) 
SELECT * FROM products WHERE id='-1' FOR UPDATE;
例2: (无主键，table lock) 
SELECT * FROM products WHERE value='Mouse' FOR UPDATE;
例3: (主键不明确，table lock)
SELECT * FROM products WHERE id<>'3' FOR UPDATE;


**4.关于mybatis**
bind元素------模糊查询
<bind value="bind_param1" value="%" + param1 + "%"/>
test元素 foreach元素 set
----------------------------------------------------------------
typeHandle  jdbcType与javaType的映射关系
默认使用EnumOrdinalTypeHandler     java类型 Eunm   jdbc类型 NUMERIC 索引
org.apache.ibatis.type.EnumTypeHandler                     VARCHAE
建议还是使用EnumTypeHandler


自定义枚举的typeHandler如：

useAffectedRows=true   返回受影响的行

-----------------------------------------------------------------
主键回填和自定义    
主键回填
useGeneratedKeys="true"  keyProperty="id"
自定义 
useGeneratedKeys="true"  keyProperty="id"
<selectKey keyProperty="id" resultType="int" order="BEFORE">
  select if(max(id) is null, 1, max(id) + 2) as newId from XXX
</selectKey>

------------------------------------------------------------------
mybatis联级
1-1 association
1-多 collection
鉴别器 discriminator


-------------------------------------------------------------------
mybatis的解析以及运行原理
JDK代理
{使用详见ReflectHelloByJDk}
缺陷  需要提供接口
CGLIB代理


sqlSession下的四大对象
Executor
statementHandler
parameterHandler
resultHandler
``

mybatis批量更新
<setting value="defaultExecutorType" value="BATCH"/>
使用flushstatements立即提交

statementType="CALLABLE" 调用存储过程











