package SpringWeb;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


//缓存切面，拦截方法增加功能
//Configuration声明该类与Spring有关的配置
@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String,Object> cache;
    //传达要拦截的方法即含有Cache注解的方法
    @Around("@annotation(SpringWeb.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) {
//        Map<String,Object> cache = new HashMap<>();
        try   {
            //获取被拦截的方法
            MethodSignature signature=(MethodSignature)joinPoint.getSignature();

            String methodName=signature.getName();

            Object cachedValue=cache.opsForValue().get(methodName);
            if (cachedValue==null){
                System.out.println("使用真实数据");
                 Object realValue = joinPoint.proceed();
                cache.opsForValue().set(methodName,realValue);
                return realValue;
            }else {
                System.out.println("使用缓存数据");
                return cachedValue;
            }
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
