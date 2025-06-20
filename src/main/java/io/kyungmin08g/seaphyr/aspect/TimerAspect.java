package io.kyungmin08g.seaphyr.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TimerAspect {
  private final StopWatch stopWatch;

  @Around("@annotation(io.kyungmin08g.seaphyr.annotation.LogExecutionTime)")
  public Object runTimer(ProceedingJoinPoint joinPoint) {
    stopWatch.start();
    try {
      Object object = joinPoint.proceed();
      stopWatch.stop();

      String second = String.valueOf(stopWatch.getTotalTimeSeconds());
      String detailSecond = second.split("\\.")[0] + "." + second.split("\\.")[1].substring(0, 2);

      log.info("{}() method execution time: {} second", joinPoint.getSignature().getName(), detailSecond);
      return object;
    } catch (Throwable throwable) {
      stopWatch.stop();
      return null;
    }
  }
}
