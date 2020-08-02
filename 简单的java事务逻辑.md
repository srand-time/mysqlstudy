```java
public void translate(long from,long into, double value){
    try{
        //开启事务
        txManager.start();
        
        //省略中间操作过程的代码
        
        //提交
        txManager.commit();
    }
    
    catch(Exception e){
        //出现异常，回滚
        txManager.rollback();
    }
    
    finally{
        //无论有没有出现异常，最终都需要断开链接
    	txManager.release();
    }
}
```



利用AOP更好。