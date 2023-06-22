package com.jioxel.app.cspringbootform.interceptors;



import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timepoTranscurridoInterceptor")
public class TimepoTranscurridoInterceptor implements HandlerInterceptor{
     private static final Logger logger = LoggerFactory.getLogger(TimepoTranscurridoInterceptor.class);
     
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
               throws Exception {
          if(request.getMethod().equalsIgnoreCase("post")){
               return true;
          }

          if(handler instanceof HandlerMethod){
               HandlerMethod metodo = (HandlerMethod) handler;
               logger.info("Es un metodo del controlador: "+ metodo.getMethod().getName());
          }
          logger.info("TimepoTranscurridoInterceptor: preHandle() entrando...");
          logger.info("Interceptando: "+ handler);
          long tiempoInicio = System.currentTimeMillis();
          request.setAttribute("tiempoInicio", tiempoInicio);
          Random random = new Random();
          Integer demora = random.nextInt(500);
          Thread.sleep(demora);

          return true;
     }
     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
               @Nullable ModelAndView modelAndView) throws Exception {
          if(request.getMethod().equalsIgnoreCase("post")){
               return;
          }
          long tiempoFin = System.currentTimeMillis(); 
          long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
          long timepoTranscurrido= tiempoFin - tiempoInicio;
          if(handler instanceof HandlerMethod && modelAndView !=null){
               modelAndView.addObject("timepoTranscurrido", timepoTranscurrido);
          }
          logger.info("Tiempo transcurrido:"+ timepoTranscurrido + " preHandle() Saliendo...");
          logger.info("TimepoTranscurridoInterceptor: preHandle() Saliendo...");

     }

     
}
