package io.FicoScoreInsuranceSimulacion.client.api;

import io.FicoScoreInsuranceSimulacion.client.ApiException;
import io.FicoScoreInsuranceSimulacion.client.model.Domicilio;
import io.FicoScoreInsuranceSimulacion.client.model.Domicilio.EstadoEnum;
import okhttp3.OkHttpClient;
import io.FicoScoreInsuranceSimulacion.client.model.Persona;
import io.FicoScoreInsuranceSimulacion.client.model.Respuesta;
import io.FicoScoreInsuranceSimulacion.client.ApiClient;
import io.FicoScoreInsuranceSimulacion.client.api.ApiTest;
import io.FicoScoreInsuranceSimulacion.client.api.FicoScoreInsuranceApi;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    
	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
    private final FicoScoreInsuranceApi api = new FicoScoreInsuranceApi();
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
    
    @Test
    public void getFicoscoreTest() throws ApiException {
    	String xApiKey = "your_api_key";
    	
    	Persona requestPersona = new Persona();
    	Domicilio requestDomicilio = new Domicilio();

        requestDomicilio.setDireccion(null);
        requestDomicilio.setColonia(null);
        requestDomicilio.setCiudad(null);
        requestDomicilio.setCodigoPostal(null);
        requestDomicilio.setMunicipio(null);
        requestDomicilio.setEstado(EstadoEnum.AGS);

        requestPersona.setPrimerNombre("ROBERTO");
        requestPersona.setSegundoNombre(null);
        requestPersona.setApellidoPaterno("SAHAGUN");
        requestPersona.setApellidoMaterno("ZARAGOZA");
        requestPersona.setApellidoAdicional(null);
        requestPersona.setFechaNacimiento("2001-01-01");
        requestPersona.setRfc(null);
        requestPersona.setCurp(null);
        requestPersona.setDomicilio(requestDomicilio);
        
		try {
			Respuesta response = api.getFicoscore(xApiKey, requestPersona);
	        Assert.assertTrue(response != null);
	        if(response != null) {
	        	logger.info(response.toString());
	        }
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}        
    }
    
}
