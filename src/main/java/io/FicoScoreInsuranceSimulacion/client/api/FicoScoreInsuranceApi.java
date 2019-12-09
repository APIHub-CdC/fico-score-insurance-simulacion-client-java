package io.FicoScoreInsuranceSimulacion.client.api;

import io.FicoScoreInsuranceSimulacion.client.ApiClient;
import io.FicoScoreInsuranceSimulacion.client.ApiException;
import io.FicoScoreInsuranceSimulacion.client.ApiResponse;
import io.FicoScoreInsuranceSimulacion.client.Configuration;
import io.FicoScoreInsuranceSimulacion.client.Pair;
import io.FicoScoreInsuranceSimulacion.client.ProgressRequestBody;
import io.FicoScoreInsuranceSimulacion.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.FicoScoreInsuranceSimulacion.client.model.Persona;
import io.FicoScoreInsuranceSimulacion.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FicoScoreInsuranceApi {
    private ApiClient apiClient;
    public FicoScoreInsuranceApi() {
        this(Configuration.getDefaultApiClient());
    }
    public FicoScoreInsuranceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call getFicoscoreCall(String xApiKey, Persona body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call getFicoscoreValidateBeforeCall(String xApiKey, Persona body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getFicoscore(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getFicoscore(Async)");
        }
        
        okhttp3.Call call = getFicoscoreCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta getFicoscore(String xApiKey, Persona body) throws ApiException {
        ApiResponse<Respuesta> resp = getFicoscoreWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> getFicoscoreWithHttpInfo(String xApiKey, Persona body) throws ApiException {
        okhttp3.Call call = getFicoscoreValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

}
