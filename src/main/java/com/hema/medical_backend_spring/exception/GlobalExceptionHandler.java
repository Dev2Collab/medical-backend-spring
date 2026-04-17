package com.hema.medical_backend_spring.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNotFound(NoResourceFoundException ex, Model model , 
                              HttpServletRequest request) throws NoResourceFoundException {
         String path = request.getRequestURI();
    
    // let static resources 404 normally
    if (path.endsWith(".css") || path.endsWith(".js") || 
        path.endsWith(".png") || path.endsWith(".jpg") || 
        path.endsWith(".svg") || path.endsWith(".ico")) {
        throw ex;
    }
        model.addAttribute("error", "الصفحة غير موجودة");
        model.addAttribute("status", 404);
        return "notFound";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntime(RuntimeException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("status", 500);
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDenied(AccessDeniedException ex, Model model) {
        model.addAttribute("error", "غير مصرح لك بالوصول");
        model.addAttribute("status", 403);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("error", "حدث خطأ غير متوقع");
        model.addAttribute("status", 500);
        return "error";
    }
    
    @ExceptionHandler(IncorrectPasswordException.class)
    public String incorrectPassword(Exception ex, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("failMessage",ex.getMessage());
        return "redirect:/fail";
    }
}
