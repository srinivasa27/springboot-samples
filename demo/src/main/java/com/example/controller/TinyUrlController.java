package com.example.controller;

import com.example.tinyurl.TinyUrlService;
import com.example.tinyurl.models.ServiceResponse;
import com.example.tinyurl.models.TinyUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/tinyurl")
@Api(value="URLs", description="Operations pertaining to creation and manipulation of TinyUrls")
public class TinyUrlController {

    @Autowired
    TinyUrlService urlService;

    @ApiOperation(value = "Create tiny url.", response = ServiceResponse.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody ServiceResponse createTinyUrl(@RequestBody TinyUrl urlRequestObj){
        ServiceResponse serviceResponse = new ServiceResponse();
        List<TinyUrl> responseList = null;
        if(null == urlRequestObj)
            return createNullExceptionResponse(new String[]{"actualUrlText"});
        urlRequestObj.setUrlId((long)Math.random());
        TinyUrl urlResponse = urlService.insertUrl(urlRequestObj);
        if(urlResponse != null){
            responseList = new ArrayList<>();
            responseList.add(urlResponse);
            serviceResponse = createResponse(1, null, responseList);
        }else{
            serviceResponse = createResponse(0, "Error Occured", null);
        }
        return serviceResponse;
    }

    @ApiOperation(value = "Delete tiny url.", response = ServiceResponse.class)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody ServiceResponse deleteTinyUrl(@RequestParam long rowId){
        ServiceResponse serviceResponse = new ServiceResponse();
        List<TinyUrl> responseList = null;
        if(StringUtils.isEmpty(rowId))
            return createNullExceptionResponse(new String[]{"urlId"});
        TinyUrl urlResponse = urlService.deleteUrl(rowId);
        if(urlResponse != null){
            responseList = new ArrayList<>();
            responseList.add(urlResponse);
            serviceResponse = createResponse(1, null, responseList);
        }else{
            serviceResponse = createResponse(0, "Error Occured", null);
        }
        return serviceResponse;
    }

    @ApiOperation(value = "Update already created tiny url.", response = ServiceResponse.class)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody ServiceResponse updateTinyUrl(@RequestBody TinyUrl urlRequestObj){
        ServiceResponse serviceResponse = new ServiceResponse();
        List<TinyUrl> responseList = null;
        if(null == urlRequestObj)
            return createNullExceptionResponse(new String[]{"urlId", "tinyUrlText", "actualUrlText"});
        TinyUrl urlResponse = urlService.updateUrl(urlRequestObj);
        if(urlResponse != null){
            responseList = new ArrayList<>();
            responseList.add(urlResponse);
            serviceResponse = createResponse(1, null, responseList);
        }else{
            serviceResponse = createResponse(0, "Error Occured", null);
        }
        return serviceResponse;
    }

    @ApiOperation(value = "Get Tiny url by Id.", response = ServiceResponse.class)
    @RequestMapping(value = "/getUrlById" , method = RequestMethod.POST)
    public @ResponseBody ServiceResponse getUrlById(@RequestParam long rowId){
        ServiceResponse serviceResponse = new ServiceResponse();
        List<TinyUrl> responseList = null;
        if(StringUtils.isEmpty(rowId))
            return createNullExceptionResponse(new String[]{"urlId", "tinyUrlText", "actualUrlText"});
        TinyUrl urlResponse = urlService.getUrl(rowId);
        if(urlResponse != null){
            responseList = new ArrayList<>();
            responseList.add(urlResponse);
            serviceResponse = createResponse(1, null, responseList);
        }else{
            serviceResponse = createResponse(0, "Error Occured", null);
        }
        return serviceResponse;
    }

    @ApiOperation(value = "Get All tiny urls.", response = ServiceResponse.class)
    @RequestMapping(value = "/getAllUrls", method = RequestMethod.GET)
    public @ResponseBody ServiceResponse getAllUrls(){
        ServiceResponse serviceResponse = new ServiceResponse();
        List<TinyUrl> responseList = urlService.getAllUrls();
        if(responseList != null && responseList.size() > 0){
            serviceResponse = createResponse(1, null, responseList);
        }else{
            serviceResponse = createResponse(0, "Error Occured", null);
        }
        return serviceResponse;
    }

    private ServiceResponse createNullExceptionResponse(String[] fields){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setResponseCode(0);
        if(fields.length == 1)
            serviceResponse.setResponseException(fields + " is Null");
        else
            serviceResponse.setResponseException("One or more input fields out of " + fields + " are Null");
        return serviceResponse;
    }

    private ServiceResponse createResponse(int status, String exception, List<TinyUrl> responseList){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setResponseCode(status);
        serviceResponse.setResponseException(exception);
        serviceResponse.setResponse(responseList);

        return serviceResponse;
    }


    public TinyUrlService getUrlService() {
        return urlService;
    }

    public void setUrlService(TinyUrlService urlService) {
        this.urlService = urlService;
    }
}
