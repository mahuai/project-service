package com.resource.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.resource.api.entity.request.QueryRequest;
import com.resource.api.entity.request.UploadRequest;
import com.resource.api.entity.response.FileResponse;
import com.resource.api.entity.response.ResourceResponse;
import com.resource.api.exception.ResourceManagerException;
import com.resource.api.service.ResourceManagerService;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ms
 * @Description: class description
 * @Package com.resource.service.impl
 * @date: Created in 2018/8/28  11:55
 */
@Service(interfaceClass = ResourceManagerService.class)
public class ResourceManagerServiceImpl implements ResourceManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ResourceManagerServiceImpl.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private MongoDbFactory mongoDbFactory;


    /**
     * 上传
     *
     * @param request
     * @return
     * @throws ResourceManagerException
     */
    @Override
    public ResourceResponse uploadFile(UploadRequest request) throws ResourceManagerException {
        try {
            Resource file = new PathResource(request.getFilePath());
            ObjectId objectId = gridFsTemplate.store(file.getInputStream(), request.getFileName(), request.getContentType(), request.getMetadata());
            if (objectId != null) {
                return new ResourceResponse(objectId.toString());
            }
        } catch (IOException e) {
            logger.error("io exception: ", e);
            throw new ResourceManagerException("io exception");
        }
        return null;
    }

    /**
     * 根据ObjectId 获取文件
     *
     * @param queryRequest
     * @return
     * @throws ResourceManagerException
     */
    @Override
    public FileResponse getObjectIdByFile(QueryRequest queryRequest) throws ResourceManagerException {
        try {
            GridFSFile file = gridFsTemplate.findOne(new Query(new GridFsCriteria(queryRequest.getCondition().toString()).is(queryRequest.getValue())));
            if (file != null) {
                GridFsResource resource = conversion(file, queryRequest.getValue().toString());
                return new FileResponse(file.getChunkSize(), file.getFilename(), String.valueOf(file.getLength()), String.valueOf(file.getMetadata().get("_contentType")), readStream(resource.getInputStream()));
            }
        } catch (Exception e) {
            logger.error("get object id by file error:", e);
            throw new ResourceManagerException("get object id by file error");
        }
        return null;
    }

    /**
     * 根据ObjectId 获取文件
     *
     * @param
     * @return
     * @throws ResourceManagerException
     */
    @Override
    public List<FileResponse> getConditionsByFiles(QueryRequest queryRequest) throws ResourceManagerException {
        try {
            List<FileResponse> fileList = new ArrayList<>();
            GridFSFindIterable iterable;
            iterable = queryRequest != null ? gridFsTemplate.find(new Query().addCriteria(conversion(queryRequest).is(queryRequest.getValue()))) : gridFsTemplate.find(new Query());
            MongoCursor<GridFSFile> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                GridFSFile file = iterator.next();
                if (file != null) {
                    GridFsResource resource = conversion(file, file.getObjectId().toString());
                    FileResponse response = new FileResponse(file.getChunkSize(), file.getFilename(), String.valueOf(file.getLength()), String.valueOf(file.getMetadata().get("_contentType")), readStream(resource.getInputStream()));
                    fileList.add(response);
                }
            }
            return fileList;
        } catch (Exception e) {
            logger.error("get object id by file error: ", e);
            throw new ResourceManagerException("get object id by file error");
        }
    }

    protected GridFsCriteria conversion(QueryRequest queryRequest) {
        return (GridFsCriteria) queryRequest.getCondition();
    }


    /**
     * 获取byte
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    protected static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * GridFSFile 转换 GridFsResource
     *
     * @param file
     * @param objectId
     * @return
     */
    protected GridFsResource conversion(GridFSFile file, String objectId) {
        MongoDatabase db = mongoDbFactory.getDb();
        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
        GridFSDownloadStream in = gridFSBucket.openDownloadStream(new ObjectId(objectId));
        return new GridFsResource(file, in);
    }
}
