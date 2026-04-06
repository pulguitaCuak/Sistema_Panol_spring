package com.paniolweb.apppaniol.exceptions;

public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException(String mensaje) {
      super(mensaje);
   }
}
