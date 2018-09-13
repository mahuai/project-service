package com.resource.api.service;

import com.resource.api.entity.request.QueryRequest;
import com.resource.api.entity.request.UploadRequest;
import com.resource.api.entity.response.FileResponse;
import com.resource.api.entity.response.ResourceResponse;
import com.resource.api.exception.ResourceManagerException;

import java.io.IOException;
import java.util.List;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.api.service
 * @date: Created in 2018/8/28  11:49
 */
public interface ResourceManagerService {

    /**
     * 上传文件
     *
     * @param uploadRequest
     * @return
     * @throws ResourceManagerException
     * @throws IOException
     */
    ResourceResponse uploadFile(UploadRequest uploadRequest) throws ResourceManagerException;

    /**
     * 根据ObjectId 获取文件
     *
     * @param queryRequest
     * @return
     * @throws ResourceManagerException
     */
    FileResponse getObjectIdByFile(QueryRequest queryRequest) throws ResourceManagerException;


    /**
     * 根据条件查询
     * @param queryRequest
     * @return
     * @throws ResourceManagerException
     */
    List<FileResponse> getConditionsByFiles(QueryRequest queryRequest) throws ResourceManagerException;
}
