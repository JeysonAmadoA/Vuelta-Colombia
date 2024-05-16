package com.uptc.frmw.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class BaseController {

    public static Map<String, Object> getSaveResponse(String typeObject, Object savedObject){
        log.info("Se ha creado {} : {}", typeObject, savedObject);
        return getJsonResponse(savedObject);
    }

    public static Map<String, Object> getFindResponse(String typeObject, Object findObject, Object id){
        log.info("Se ha buscado {} : con ID: {}", typeObject, id);
        return getJsonResponse(findObject);
    }

    public static Map<String, Object> getFindResponse(String typeObject, Object findObject){
        log.info("Se ha buscado elementos de tipo {}", typeObject);
        return getJsonResponse(findObject);
    }

    public static Map<String, Object> getDeleteResponse(String typeObject, Object id){
        String deleteMsg = "Se ha eliminado " + typeObject + " con ID: " + id;
        log.warn(deleteMsg);
        return getJsonResponse(deleteMsg);
    }

    public static Map<String, Object> getUpdateResponse(String typeObject, Object updatedObject, Object id){
        log.warn("Se ha actualizado {} : con ID: {}", typeObject, id);
        return getJsonResponse(updatedObject);
    }

    public static Map<String, Object> getJsonResponse(Object result) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", result);
        return response;
    }

    public static Map<String, Object> getJsonResponse(Exception exception, int statusCode) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("data", exception.getMessage());
        response.put("statusCode", statusCode);
        return response;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> handleError(Exception exception){
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getJsonResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
