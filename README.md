# Gestion-biblioteca
### Integrantes
 * Juan Diego Becerra Peña
 * Diego Fernando Ruiz Rojas
 * Laura Nathalia Garcia Acuña
 * Hayden Esteban Cristancho Pinzón

### Sprint 1

### #1 Iniciar Sesión

    Como: Usuario de la comunidad de la ECI.

    Necesito: Ingresar al sistema de gestión de recursos de la biblioteca.

    Para: Realizar la gestión o reserva de un recurso especifico.

Se debe realizar la auntenticación contra el LDAP de la Escuela, realizando el inicio de sesión con el usuario de correo electrónico del miembro de la comunidad.
Se recomienda implementar Apache Shiro para la correcta implementación del inicio de sesión.

### Criterios de Aceptación:

 * Se debe contar con dos perfiles para los usuarios autenticados: Comunidad, Administrador.
        
        1. Comunidad: juan.becerra-pe@mail.escuelaing.edu.co - 12345
        2. Administrador: pruebaAdmin@prueba.com - 123321
       
 * Las páginas a las que tengo acceso deben estar restringidas con base en el perfil al que pertenece un usuario.

   Página Comunidad
   
  ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553589159981126/unknown.png)
  
  
  Pagina Administrador
  
  ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553832731574272/unknown.png)
  
 * Así como puedo iniciar sesión, debe haber una opción de cierre de sesión.
  
   
  ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553589159981126/unknown.png)
  
    El botón de cierre de sesión se encuentra en la parte superior derecha 
  
 * Si no existe una sesión activa, no debe ser posible acceder a ninguna página que requiera permisos de acceso.
       
       Si no se esta logeado y se intenta hacer una reserva, se dirige automaticamente a la pantalla de login.
       
 * Una vez un usuario haya iniciado sesión, no se debe permitir volver al formulario de inicio de sesión.
 
       Se implementó correctamente

### #2 Registrar un recurso

     Como: Usuario Administrador.

     Necesito: Registrar un nuevo recurso.

     Para: Que este pueda ser visualizado y utilizado por los miembros de la comunidad.
  
Un recurso es todo aquel elemento o espacio que es ofrecido por la biblioteca a la comunidad perteneciente a la ECI, estos recursos pueden ser salas de estudio,        equipos de computo, y equipos multimedia para el desarrollo de diferentes actividades.

### Criterios de Aceptación

 * La información básica de un recurso es: Nombre, ubicación, tipo, capacidad, identificador interno.
    
      ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966558491508617266/unknown.png)
    
 * El recurso también debe tener un horario de disponibilidad, donde se indica en qué horarios es posible solicitar reservas.
 * Una vez el recurso es creado debe aparecer disponible para ser reservado por los miembros de la comunidad.
 
    ![IMG1](https://cdn.discordapp.com/attachments/745800236181618718/966553895633567834/unknown.png)
    
 * No pueden existir dos identificadores internos iguales dentro de los recursos.
            
          Se implementó correctamente.

### #4 Consultar recursos

    Como: Usuario Comunidad.

    Necesito: Ver todos los recursos disponibles en la Biblioteca.

    Para: Realizar poder realizar la reserva de aquel en el que me encuentro interesado.

Los usuarios del sistema necesitan poder visualizar de una forma sencilla y agradable los recursos habilitados por la biblioteca para proceder a realizar una reserva de los mismos.

### Criterios de Aceptación:

 * Al momento de realizar la consulta, de deben mostrar todos lo recursos que se encuentran activos.
    
 * Deben existir filtros que me permitan realizar una búsqueda mejor direccionada. Por tipo, capacidad y ubicación.
      
      ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553589159981126/unknown.png)
       
 * Desde la interfaz de consulta debe existir una funcionalidad que me permita realizar la reserva de este recurso.
 
    ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553895633567834/unknown.png)
    
    ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553939745046528/unknown.png)
    
    ![img1](https://cdn.discordapp.com/attachments/745800236181618718/966553990647140362/unknown.png)
    
 * La consulta de recursos la puede realizar cualquier usuario (autenticado o no autenticado)
            
        Se implementó correctamente.
