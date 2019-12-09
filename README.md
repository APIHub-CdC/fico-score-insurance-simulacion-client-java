# pld-naturales-simulacion-client-java

Devuelve las coinicidencias de las personas que se encuentran en listas nacionales e internacionales de Prevención de Lavado de Dinero (entorno de simulación).

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir os siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/PLDNaturalesSimulacion/client/api/ApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
private final PldNaturalesSimulacionApi api = new PldNaturalesSimulacionApi();    
private ApiClient apiClient = null; 

@Before()
public void setUp() {
    this.apiClient = api.getApiClient();
    this.apiClient.setBasePath("the_url");
    OkHttpClient insecureClient = ApiClient.getClientNoSSLVerification();
    OkHttpClient okHttpClient = insecureClient.newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build();
    apiClient.setHttpClient(okHttpClient);  
}
```

De igual manera, en el archivo **ApiTest**, se deberá modificar el siguiente fragmento de código con los datos correspondientes:

```java
@Test
public void pldTest() throws ApiException {
    String xApiKey = "your_api_key";
    Peticion persona = new Peticion();
    
    persona.setFolioOtorgante("000008");
    persona.setTipoDocumento("01");
    persona.setNumeroDocumento("01");
    persona.setNombre("Maria");
    persona.setSegundoNombre(null);
    persona.setApellidoPaterno("Sanchez");
    persona.setApellidoMaterno("Mathews");
    
    try {
        Respuesta response = api.pld(xApiKey, persona);
        Assert.assertTrue(response != null);
        if(response != null) {
            logger.info(response.toString());
        }
    } catch (ApiException e) {
        logger.info(e.getResponseBody());
    }
}
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```
