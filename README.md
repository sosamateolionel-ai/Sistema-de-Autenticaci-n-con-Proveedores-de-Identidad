# Sistema de Autenticación con Proveedores de Identidad

## Descripción

Este proyecto implementa un sistema de autenticación que simula la validación de tokens de acceso mediante distintos proveedores de identidad: Google, GitHub y Apple. Utiliza programación orientada a objetos para establecer una estructura común y permitir que cada proveedor aplique sus propias reglas de validación.

## Funcionamiento

El programa utiliza una clase abstracta llamada `ProveedorIdentidad`, que contiene el nombre del proveedor y el método `autenticar()`. Este método verifica que el token no sea nulo ni esté vacío antes de delegar su validación en la clase correspondiente.

Se implementan tres proveedores:

* **Google:** verifica que el token comience con `ya29.` y tenga al menos 15 caracteres.
* **GitHub:** verifica que el token comience con `ghp_` y tenga exactamente 20 caracteres.
* **Apple:** verifica que el token tenga tres partes separadas por puntos, como en la estructura general de un JWT.

Si el token cumple la regla definida para el proveedor, se concede el acceso simulado. En caso contrario, se deniega y se muestra un mensaje en la consola.

El programa también prueba tokens con formato incorrecto y tokens vacíos o nulos.

## Clases principales

### `ProveedorIdentidad`

Clase abstracta que define el atributo `nombreProveedor`, su método de acceso `getNombreProveedor()` y el método `autenticar()`, encargado de validar la entrada y gestionar el resultado. Declara `validarToken()` como método abstracto.

### `AuthGoogle`

Hereda de `ProveedorIdentidad` e implementa la validación simulada de tokens de Google mediante un prefijo específico y una longitud mínima.

### `AuthGitHub`

Hereda de `ProveedorIdentidad` e implementa la validación simulada de tokens de GitHub mediante un prefijo específico y una longitud exacta.

### `AuthApple`

Hereda de `ProveedorIdentidad` e implementa una comprobación básica de la estructura de tres partes de un token JWT.

### `Main`

Crea una lista de proveedores, ejecuta las pruebas con tokens que cumplen las reglas definidas y prueba diferentes casos de error.

## Conceptos de programación utilizados

* **Abstracción:** la clase `ProveedorIdentidad` define la estructura común de los proveedores.
* **Herencia:** las clases `AuthGoogle`, `AuthGitHub` y `AuthApple` heredan de la clase abstracta.
* **Polimorfismo:** una lista de tipo `ProveedorIdentidad` permite trabajar con diferentes proveedores de identidad.
* **Métodos abstractos:** `validarToken()` obliga a cada proveedor a implementar su propia lógica.
* **Sobrescritura de métodos:** cada subclase redefine `validarToken()`.
* **Encapsulamiento:** se utilizan atributos protegidos y un método público de acceso.
* **Validación de datos:** se rechazan los tokens nulos o vacíos antes de realizar las comprobaciones específicas.
* **Colecciones:** se utiliza `ArrayList` para almacenar los proveedores.

## Tecnologías utilizadas

* Java.
* IntelliJ IDEA.
* Programación orientada a objetos (POO).

## Ejecución

<img width="732" height="372" alt="image" src="https://github.com/user-attachments/assets/513c36a1-faa1-44d0-8bab-839399523c23" />
<img width="812" height="442" alt="image" src="https://github.com/user-attachments/assets/a556de94-977b-4bb7-9bae-e2b689c27c65" />
<img width="778" height="395" alt="image" src="https://github.com/user-attachments/assets/b22c4f94-d432-4506-9264-230eb22d1e6d" />

## Objetivo del ejercicio

Aplicar abstracción, herencia y polimorfismo mediante un sistema que permite trabajar con diferentes proveedores de identidad. También se busca practicar los métodos abstractos, la sobrescritura y la validación de entradas.

## Consideraciones

La autenticación es una simulación educativa. El programa no se conecta realmente a las API de Google, GitHub o Apple, ni verifica firmas criptográficas, expiración o permisos de los tokens. Las reglas de formato utilizadas son específicas del ejercicio y no representan una validación real de credenciales.
